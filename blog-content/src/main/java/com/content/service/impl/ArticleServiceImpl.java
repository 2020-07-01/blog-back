package com.content.service.impl;

import com.content.service.AbstractService;
import com.content.service.ArticleService;
import com.entity.Article;
import com.support.Pageable;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
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
    public Pageable<?> page(Article article, Pageable<?> pageable) {
        Query query = new QueryBuilder().page(pageable).addArticleTypeId(article.getArticleTypeId()).build();

        List<Article> articleList = mongoTemplate.find(query, Article.class, getCollectionName());
        Long count = mongoTemplate.count(new Query(), getCollectionName());
        return Pageable.of(articleList, count, pageable.getPageNo(), pageable.getPageSize());
    }

    @Override
    public void saveArticle(Article article) {
        if (article == null) {
            return;
        }
        if (StringUtils.isNotBlank(article.getArticleId())) {
            article.setUpdateTime(new Date());
        } else {
            article.setCreateTime(new Date());
        }
        article.setUpdateTime(new Date());
        mongoTemplate.save(article);
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Article getArticleById(String articleId) {
        if (StringUtils.isBlank(articleId)) {
            //todo 失败处理
        }
        Query query = new QueryBuilder().addArticleId(articleId).build();
        return mongoTemplate.findOne(query, Article.class, getCollectionName());
    }

    static class QueryBuilder {
        Query query = new Query();

        public QueryBuilder page(Pageable<?> pageable) {
            if (pageable != null) {
                query.limit(pageable.getPageSize());
                query.skip(pageable.getSkip());
            }
            return this;
        }

        public QueryBuilder addArticleTypeId(String articleTypeId) {
            if (StringUtils.isNotEmpty(articleTypeId)) {
                query.addCriteria(Criteria.where("articleTypeId").is(articleTypeId));
            }
            return this;
        }

        public QueryBuilder addArticleId(String articleId) {
            if (StringUtils.isNotEmpty(articleId)) {
                query.addCriteria(Criteria.where("articleId").is(articleId));
            }
            return this;
        }


        public Query build() {
            return query;
        }
    }
}
