package com.content.coordinate;

import com.content.service.impl.ArticleServiceImpl;
import com.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName : ArticleCoordinateService
 * @Author : yq
 * @Date: 2021-07-30
 * @Description :
 */
@Service
public class ArticleCoordinateService {

    private ArticleServiceImpl articleService;

    public void save(Article article){
        articleService.saveArticle(article);
    }

    @Autowired
    private void setArticleService(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }


}
