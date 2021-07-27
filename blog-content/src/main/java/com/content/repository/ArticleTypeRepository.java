package com.content.repository;

import com.entity.ArticleType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

/**
 * @ClassName : ArticleTypeRepository
 * @Author : yq
 * @Date: 2021-07-27
 * @Description :
 */
@Component
public interface ArticleTypeRepository extends MongoRepository<ArticleType, String> {
}
