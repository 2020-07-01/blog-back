package com.facade.controller;

import com.entity.ArticleType;
import com.content.service.ArticleTypeService;
import com.content.service.impl.ArticleTypeServiceImpl;
import com.support.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private void setArticleTypeService(ArticleTypeServiceImpl articleTypeService) {
        this.articleTypeService = articleTypeService;
    }

}
