package com.facade.controller;

import com.content.coordinate.ArticleCoordinateService;
import com.content.service.ArticleService;
import com.entity.Article;
import com.support.Pageable;
import com.support.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName : ArticleController
 * @Author : yq
 * @Date: 2021-07-26
 * @Description :
 */
@RestController
@RequestMapping(value = "/v1/article")
public class ArticleController {

    private ArticleCoordinateService articleCoordinateService;
    private ArticleService articleService;

    @GetMapping(value = "/page")
    public Response<?> page(@RequestParam(value = "articleTypeId") String articleTypeId, Pageable<?> pageable) {
        Article article = new Article();
        article.setArticleTypeId(articleTypeId);
        return Response.success(articleService.page(article, pageable));
    }

    @PostMapping(value = "/save")
    public Response<?> save(@RequestBody Article article) {
        articleCoordinateService.save(article);
        return Response.success();
    }

    @GetMapping(value = "/detail")
    public Response<?> detail(@RequestParam(value = "articleId") String articleId) {
        return Response.success(articleService.getArticleById(articleId));
    }

    @Autowired
    private void setArticleCoordinateService(ArticleCoordinateService articleCoordinateService) {
        this.articleCoordinateService = articleCoordinateService;
    }

    @Autowired
    private void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }
}
