package com.repository;

import com.entity.ArticleType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

/**
 * @ClassName : ArticleRepository
 * @Author : yq
 * @Date: 2021-07-26
 * @Description :
 */
@Component
public interface ArticleTypeRepository extends MongoRepository<ArticleType, String> {




}


