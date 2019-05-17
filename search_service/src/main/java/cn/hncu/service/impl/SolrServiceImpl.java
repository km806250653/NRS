package cn.hncu.service.impl;

import cn.hncu.entity.PageResult;
import cn.hncu.pojo.NewsForSolr;
import cn.hncu.service.ISolrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.*;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/5/12.
 */
@Service
public class SolrServiceImpl implements ISolrService {
    @Autowired
    private SolrTemplate solrTemplate;

    @Override
    public PageResult search(String keywords,int currentPage,int pageSize) {
        SimpleHighlightQuery query = new SimpleHighlightQuery();

        HighlightOptions options = new HighlightOptions();
        options.addField("km_news_title");
        options.addField("km_news_content");
        options.setSimplePrefix("<span style='color:red'>");
        options.setSimplePostfix("</span>");
        query.setHighlightOptions(options);
        Criteria criteria = new Criteria("km_keywords").is(keywords);
        query.addCriteria(criteria);
        query.setOffset((currentPage-1)*pageSize);
        query.setRows(pageSize);
        HighlightPage<NewsForSolr> highPage = solrTemplate.queryForHighlightPage(query, NewsForSolr.class);
        List<HighlightEntry<NewsForSolr>> highlighted = highPage.getHighlighted();
        for (HighlightEntry<NewsForSolr> highlightEntry : highlighted) {
            NewsForSolr entity = highlightEntry.getEntity();
            List<HighlightEntry.Highlight> highlights = highlightEntry.getHighlights();
            for (HighlightEntry.Highlight highlight : highlights) {
                String field = highlight.getField().getName();
                if(field.endsWith("title")){
                    //高亮的是km_news_title域
                    entity.setTitle(highlight.getSnipplets().get(0));
                }else {
                    entity.setContent(highlight.getSnipplets().get(0));
                }
            }
        }
        return new PageResult(highPage.getTotalElements(),highPage.getContent());
    }

    @Override
    public List<NewsForSolr> findBox() {
        Query query = new SimpleQuery();
        query.setOffset(0);
        query.setRows(10);
        Criteria criteria = new Criteria("id").isNotNull();
        query.addCriteria(criteria);
        Sort sort = new Sort(Sort.Direction.DESC,"km_news_visit_count");
        query.addSort(sort);
        ScoredPage<NewsForSolr> page = solrTemplate.queryForPage(query, NewsForSolr.class);
        return page.getContent();
    }
}
