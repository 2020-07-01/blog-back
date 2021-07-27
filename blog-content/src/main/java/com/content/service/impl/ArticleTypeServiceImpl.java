package com.content.service.impl;

import com.content.repository.ArticleTypeRepository;
import com.content.service.AbstractService;
import com.content.service.ArticleTypeService;
import com.entity.ArticleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @ClassName : ArticleServiceImpl
 * @Author : yq
 * @Date: 2021-07-26
 * @Description :
 */
@Service
public class ArticleTypeServiceImpl extends AbstractService<ArticleType> implements ArticleTypeService {

    private MongoTemplate mongoTemplate;
    private ArticleTypeRepository articleTypeRepository;

    @Override
    public List<ArticleType> findAll() {
        return null;
    }

    @Override
    public void save(ArticleType articleType) {
        mongoTemplate.save(articleType, getCollectionName());
    }

    @Autowired
    private void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Autowired
    private void setArticleTypeRepository(ArticleTypeRepository articleTypeRepository) {
        this.articleTypeRepository = articleTypeRepository;
    }
}



