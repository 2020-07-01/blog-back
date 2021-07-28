package com.facade.controller;

import com.content.service.impl.ArticleServiceImpl;
import com.entity.Article;
import com.support.Pageable;
import com.support.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : ArticleController
 * @Author : yq
 * @Date: 2021-07-26
 * @Description :
 */
@RestController
@RequestMapping(value = "/v1/article")
public class ArticleController {

    private ArticleServiceImpl articleService;


    @GetMapping(value = "/page")
    public Response<?> page(Pageable<?> pageable) {
        return Response.success(articleService.page(pageable));
    }

    @Autowired
    private void setArticleService(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }
}
