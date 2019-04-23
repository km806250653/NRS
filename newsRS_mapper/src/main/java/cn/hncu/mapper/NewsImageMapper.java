package cn.hncu.mapper;

import cn.hncu.pojo.NewsImage;
import cn.hncu.pojo.NewsImageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsImageMapper {
    int countByExample(NewsImageExample example);

    int deleteByExample(NewsImageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NewsImage record);

    int insertSelective(NewsImage record);

    List<NewsImage> selectByExample(NewsImageExample example);

    NewsImage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NewsImage record, @Param("example") NewsImageExample example);

    int updateByExample(@Param("record") NewsImage record, @Param("example") NewsImageExample example);

    int updateByPrimaryKeySelective(NewsImage record);

    int updateByPrimaryKey(NewsImage record);
}