package com.facade.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.entity.Article;
import com.entity.ArticleType;
import com.content.service.impl.ArticleTypeServiceImpl;
import com.support.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
/**
 * @ClassName : ArticleTypeController
 * @Author : yq
 * @Date: 2021-07-26
 * @Description :
 */
@RestController
@RequestMapping(value = "/v1/article-type")
public class ArticleTypeController {

    private ArticleTypeServiceImpl articleTypeService;

    @GetMapping(value = "/all")
    public Response<List<ArticleType>> findAll() {
        return Response.success(articleTypeService.findAll());
    }

    @PostMapping(value = "/save")
    public Response<?> save(@RequestBody(required = false) ArticleType articleType) {
        articleTypeService.save(articleType);
        return Response.success();
    }

    @DeleteMapping(value = "/delete")
    public Response<?> delete(@RequestParam(value = "id", required = true) String id) {
        articleTypeService.deleteById(id);
        return Response.success();
    }






    @GetMapping(value = "/demo")
    public Response<?> demo() {
        Article article = new Article();
        article.setArticleId("1");
        article.setArticleTitle("demo");
        article.setArticleTypeId("2");
        article.setContent("内容很长");
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());
        return Response.success(article);
    }

    @Autowired
    private void setArticleTypeService(ArticleTypeServiceImpl articleTypeService) {
        this.articleTypeService = articleTypeService;
    }

}
