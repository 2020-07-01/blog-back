package com.content.service;

import com.entity.Article;
import com.support.Pageable;

/**
 * @ClassName : ArticleService
 * @Author : yq
 * @Date: 2021-07-28
 * @Description :
 */
public interface ArticleService {

    Pageable<?> page(Pageable<?> pageable);

    void saveArticle(Article article);

    void delete(String id);
}
