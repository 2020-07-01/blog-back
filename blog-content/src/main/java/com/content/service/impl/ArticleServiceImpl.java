package com.content.service.impl;

import com.content.service.AbstractService;
import com.content.service.ArticleService;
import com.entity.Article;
import com.support.Pageable;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName : ArticleServiceImpl
 * @Author : yq
 * @Date: 2021-07-28
 * @Description :
 */
@Service
public class ArticleServiceImpl extends AbstractService<Article> implements ArticleService {

    @Override
    public Pageable<?> page(Pageable<?> pageable) {
        Query query = new QueryBuilder().page(pageable).builder();
        List articleList = mongoTemplate.find(query, getClazz(), getCollectionName());
        Long count = mongoTemplate.count(new Query(), getCollectionName());
        return Pageable.of(articleList, count, pageable.getPageNo(), pageable.getPageSize());
    }

    @Override
    public void saveArticle(Article article) {

    }

    @Override
    public void delete(String id) {

    }

    static class QueryBuilder {
        Criteria criteria = new Criteria();
        Query query = new Query();

        public QueryBuilder page(Pageable<?> pageable) {
            if (pageable != null) {
                query.limit(pageable.getPageSize());
                query.skip(pageable.getSkip());
            }
            return this;
        }

        public Query builder() {
            return query.addCriteria(criteria);
        }
    }
}
