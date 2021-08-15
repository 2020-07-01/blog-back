package com.facade.controller;

import com.content.service.ArticleTypeService;
import com.entity.ArticleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName : InitController
 * @Author : yq
 * @Date: 2021-08-05
 * @Description :
 */
@RefreshScope
@RequestMapping(value = "/init")
@RestController
public class InitController {

    private ArticleTypeService articleTypeService;

    @Autowired
    private void setArticleTypeService(ArticleTypeService articleTypeService){
        this.articleTypeService = articleTypeService;
    }

    @Value("${java1234.name}")
    private String name;

    @RequestMapping(value = "/name")
    public String getName(){
        return "真厉害";
    }

    @GetMapping(value = "/type")
    public String initArticleType(){

        ArticleType articleType = new ArticleType();
        articleType.setArticleTypeName("java");
        articleType.setCreateTime(new Date());

        ArticleType articleType1 = new ArticleType();
        articleType1.setArticleTypeName("计算机网络");
        articleType1.setCreateTime(new Date());

        ArticleType articleType2  = new ArticleType();
        articleType2.setArticleTypeName("操作系统");
        articleType2.setCreateTime(new Date());

        articleTypeService.save(articleType);
        articleTypeService.save(articleType1);
        articleTypeService.save(articleType2);

        return "success";
    }
}
