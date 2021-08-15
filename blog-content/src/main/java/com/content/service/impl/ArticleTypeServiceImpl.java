package com.content.service.impl;

import com.content.repository.ArticleTypeRepository;
import com.content.service.AbstractService;
import com.content.service.ArticleTypeService;
import com.entity.Article;
import com.entity.ArticleType;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;


/**
 * @ClassName : ArticleServiceImpl
 * @Author : yq
 * @Date: 2021-07-26
 * @Description :
 */
@Service
public class ArticleTypeServiceImpl extends AbstractService<ArticleType> implements ArticleTypeService {

    private ArticleTypeRepository articleTypeRepository;

    @Override
    public List<ArticleType> findAll() {
        return mongoTemplate.findAll(ArticleType.class);
    }

    @Override
    public void save(ArticleType articleType) {
        mongoTemplate.save(articleType, getCollectionName());
    }

    @Override
    public void deleteById(String id) {
        if (StringUtils.isBlank(id)) {
            return;
        }
        articleTypeRepository.deleteById(id);
        //离线方式  默认分类
    }

    static class QueryBuilder {
        Query query = new Query();
        Criteria criteria = new Criteria();

        public QueryBuilder addIdList(List<String> idList) {
            if (!CollectionUtils.isEmpty(idList)) {
                criteria.and("_id").in(idList);
            }
            return this;
        }

        public Query builder() {
            query.addCriteria(criteria);
            return query;
        }
    }

    @Autowired
    private void setArticleTypeRepository(ArticleTypeRepository articleTypeRepository) {
        this.articleTypeRepository = articleTypeRepository;
    }
}



