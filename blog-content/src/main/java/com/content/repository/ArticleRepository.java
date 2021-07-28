package com.content.repository;

import com.entity.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

/**
 * @ClassName : ArticleRepository
 * @Author : yq
 * @Date: 2021-07-28
 * @Description :
 */
@Component
public interface ArticleRepository extends MongoRepository<Article,String> {

}
