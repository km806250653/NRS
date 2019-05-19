package cn.hncu.service.impl;

import cn.hncu.entity.PageResult;
import cn.hncu.mapper.*;
import cn.hncu.pojo.*;
import cn.hncu.service.INewsService;
import cn.hncu.utils.FastDFSClient;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
@Service
public class NewsServiceImpl implements INewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private NewsImageMapper imageMapper;

    @Autowired
    private CommentMapper commentMapper;


    @Autowired
    private FavoritesMapper favoritesMapper;


    @Autowired
    private CategoryMapper categoryMapper;



    @Autowired
    private SolrTemplate solrTemplate;

    @Autowired
    private ExamineMapper examineMapper;


    @Override
    public News findOne(Integer id) {
        return newsMapper.selectByPrimaryKey(id);
    }



    @Override
    public PageResult findListByCid(Integer cid, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(cid);
        Page<News> page = (Page<News>) newsMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public PageResult findListByUid(Integer uid, int pageNum) {
        PageHelper.startPage(pageNum, 4);
        NewsExample example = new NewsExample();
        //构建查询条件
        NewsExample.Criteria criteria = example.createCriteria();
        //查询状态未未审核或审核通过的
        criteria.andStatusIn(Arrays.asList(new Integer[]{0,1}));
        criteria.andUidEqualTo(uid);
        //排序方式
        example.setOrderByClause("release_date desc");
        //长文本需使用该方法
        Page<News> page = (Page<News>) newsMapper.selectByExampleWithBLOBs(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public PageResult findFavoriteByUid(Integer uid, Integer pageNum) {
        //从收藏表中查询该用户的收藏
        FavoritesExample favoriteExample = new FavoritesExample();
        FavoritesExample.Criteria favoriteExampleCriteria = favoriteExample.createCriteria();
        favoriteExampleCriteria.andUidEqualTo(uid);
        List<Favorites> favorites = favoritesMapper.selectByExample(favoriteExample);
        if(favorites.size()<=0){
            //没有收藏
            return new PageResult(0,new ArrayList<News>());
        }
        //获取收藏新闻的id集合
        ArrayList<Integer> idList = new ArrayList<>();
        favorites.forEach(favorite->idList.add(favorite.getNid()));

        PageHelper.startPage(pageNum, 4);
        NewsExample example = new NewsExample();
        //构建查询条件
        NewsExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(idList);
        //长文本需使用该方法
        Page<News> page = (Page<News>) newsMapper.selectByExampleWithBLOBs(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public List<News> findExceptionListByUid(Integer uid, Integer status) {
        NewsExample example = new NewsExample();
        //构建查询条件
        NewsExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        //根据状态构建条件
        if(status==-1){
            criteria.andStatusIn(Arrays.asList(new Integer[]{2,3,4}));
        }else {
            criteria.andStatusEqualTo(status);
        }
        //长文本需使用该方法
        return newsMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public void favorite(Integer nid, Integer uid) {
        //添加到收藏表
        Favorites favorite = new Favorites(nid, uid);
        favoritesMapper.insert(favorite);
        //新闻被收藏+1
        News news = newsMapper.selectByPrimaryKey(nid);
        news.setFavoriteCount(news.getFavoriteCount() + 1);
        newsMapper.updateByPrimaryKey(news);
        //操作solr
        importToSolr(news);
    }

    @Override
    public void removeFavorite(Integer nid, Integer uid) {
        //从收藏表删除
        FavoritesExample example = new FavoritesExample();
        FavoritesExample.Criteria criteria = example.createCriteria();
        criteria.andNidEqualTo(nid);
        criteria.andUidEqualTo(uid);
        favoritesMapper.deleteByExample(example);
        //新闻收藏量-1

        //操作mysql
        News news = newsMapper.selectByPrimaryKey(nid);
        news.setFavoriteCount(news.getFavoriteCount() - 1);
        newsMapper.updateByPrimaryKey(news);
        //操作solr
        importToSolr(news);
    }

    @Override
    public boolean isFavorite(Integer nid, Integer uid) {
        if(uid == -1)
            //未登录
            return false;
        //查询数据库是否存在该记录
        FavoritesExample example = new FavoritesExample();
        FavoritesExample.Criteria criteria = example.createCriteria();
        criteria.andNidEqualTo(nid);
        criteria.andUidEqualTo(uid);
        List<Favorites> favorites = favoritesMapper.selectByExample(example);
        if (favorites.size() > 0)
            return true;
        return false;
    }

    @Override
    public void insertNews(News news) {
        //设置发布时间
        news.setReleaseDate(new Date());
        news.setFavoriteCount(0);
        news.setVisitCount(0);
        news.setCommentCount(0);
        news.setStatus(0);
        if("".equals(news.getSource())){
            //原创
            news.setSource("../pages/details.html#?id="+news.getId());
        }
        newsMapper.insert(news);
        //操作solr
        importToSolr(news);
    }

    @Override
    public News findByNid(Integer id) {
        return newsMapper.selectByPrimaryKey(id);
    }

    //查找主页封面
    @Override
    public Map<String,Object> findHot() {
        HashMap<String, Object> map = new HashMap<>();
        //查询带图片的，用作轮播图
        map.put("listImage",hotRank(10, true,-1));
        map.put("list",hotRank(10,false,-1));
        return map;
    }

    @Override
    public List<Map> findRank() {
        ArrayList<Map> list = new ArrayList<>();
        List<Category> categories = categoryMapper.selectByExample(null);
        categories.forEach(category -> {
            Map map = new HashMap<>();
            map.put("category",category);
            //查询带图片三条
            map.put("imageNewsList",hotRank(3,true,category.getId()));
            //查询不带图片的十条
            map.put("list",hotRank(10,false,category.getId()));
            list.add(map);
        });
        return list;
    }

    @Override
    public PageResult findPage(int currentPage, int pageSize,Integer cid, String keywords,String type) {
        PageHelper.offsetPage((currentPage-1)*pageSize,pageSize);
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("visit_count DESC");
        //过滤条件
        //分类
        if(cid!=-1){
            criteria.andCidEqualTo(cid);
        }
        //搜索
        if(!"".equals(keywords)){
            criteria.andTitleLike("%"+keywords+"%");
        }
        //待审核
        if("examine".equals(type)){
            criteria.andStatusIn(Arrays.asList(new Integer[]{0,3}));
        }
        //违规新闻
        if("violation".equals(type)){
            criteria.andStatusIn(Arrays.asList(new Integer[]{2,4}));
        }
        Page<News> page = (Page<News>)newsMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public void updateStatus(Integer id,int status) {
        News news = newsMapper.selectByPrimaryKey(id);

        //更新solr索引库
        //第一种情况：未审核的审核通过，不做处理
        //第二种情况：未审核的驳回或删除，从索引库删除
        if(news.getStatus()==0 && (status==2||status==4)){
            solrTemplate.deleteById(id+"");
            solrTemplate.commit();
        }
        //第三种情况：再次审核的驳回或删除，不做处理
        //第四种情况：再次审核的审核通过，加入索引库
        if(news.getStatus()==3&&status==1){
            importToSolr(news);
        }
        //第五种情况：驳回或删除的申请再次审核，不做处理

        news.setStatus(status);
        newsMapper.updateByPrimaryKey(news);


    }

    /**
     * 封装按访问量查询前N条新闻的方法
     * @param count 查询条数
     * @param image 是否带图片
     * @param cid   是否带分类
     * @return
     */
    public List<News> hotRank(int count,boolean image,int cid){
        PageHelper.offsetPage(0,count);
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        if(cid!=-1){
            criteria.andCidEqualTo(cid);
        }
        if(image){
            criteria.andImageIsNotNull();
        }else {
            criteria.andImageIsNull();
        }
        example.setOrderByClause("visit_count DESC");
        List<News> list = newsMapper.selectByExampleWithBLOBs(example);
        return list;
    }


    /**
     * 根据id删除图片
     *
     * @param id
     * @throws Exception
     */
    @Override
    public void deleById(Integer id) throws Exception {
        //查询该新闻，用于写日志  暂时为控制台输出
        News news = newsMapper.selectByPrimaryKey(id);
        System.out.print(new Date());
        System.out.println("准备删除新闻id:" + news.getId() + ",标题 : " + news.getTitle());
        //获取fdfs客户端工具类对象
        FastDFSClient fastDFSClient = new FastDFSClient();

        //查询该新闻的所有图片
        NewsImageExample imageExample = new NewsImageExample();
        NewsImageExample.Criteria imageExampleCriteria = imageExample.createCriteria();
        imageExampleCriteria.andNidEqualTo(id);
        List<NewsImage> newsImages = imageMapper.selectByExample(imageExample);
        //遍历图片集合
            newsImages.forEach(newsImage -> {
                try {
                    //从fdfs服务器删除该图片
                    String url = newsImage.getUrl();
                    fastDFSClient.deleteFile(url, "http://192.168.25.136/");
                    //伪日志
                    System.out.println("从fdfs删除文件 : " + newsImage.getUrl());
                    //从数据库删除该图片url
                    imageMapper.deleteByPrimaryKey(newsImage.getId());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            //删除审核记录
        ExamineExample examineExample = new ExamineExample();
        ExamineExample.Criteria criteria = examineExample.createCriteria();
        criteria.andNidEqualTo(news.getId());
        examineMapper.deleteByExample(examineExample);

        //删除该新闻的评论
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria commentExampleCriteria = commentExample.createCriteria();
        commentExampleCriteria.andNidEqualTo(id);
        commentMapper.deleteByExample(commentExample);
        System.out.println("评论删除完毕");

        //删除对应的收藏
        FavoritesExample favoritesExample = new FavoritesExample();
        FavoritesExample.Criteria favoritesCriteria = favoritesExample.createCriteria();
        favoritesCriteria.andNidEqualTo(id);
        favoritesMapper.deleteByExample(favoritesExample);

        //从solr索引库中删除
        solrTemplate.deleteById(id+"");
        solrTemplate.commit();
        //从mysql删除该新闻
        newsMapper.deleteByPrimaryKey(id);

        System.out.print(new Date() + " : ");
        System.out.println("已删除新闻id:" + news.getId() + ",标题 : " + news.getTitle());
    }


    @Override
    public void update(News news) {
        if("".equals(news.getSource())){
            //原创
            news.setSource("../pages/details.html#?id="+news.getId());
        }
        //导入solr
        importToSolr(news);
        newsMapper.updateByPrimaryKeySelective(news);
    }

    public void importToSolr(News news){

        NewsForSolr newsForSolr = new NewsForSolr();
        newsForSolr.setNews(news);
        //查询分类
        Category category = categoryMapper.selectByPrimaryKey(news.getCid());
        newsForSolr.setCategory(category.getText());
        solrTemplate.saveBean(newsForSolr);
        solrTemplate.commit();
    }
}
