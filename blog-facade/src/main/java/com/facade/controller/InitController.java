package com.facade.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.content.service.ArticleTypeService;
import com.entity.ArticleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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
    private void setArticleTypeService(ArticleTypeService articleTypeService) {
        this.articleTypeService = articleTypeService;
    }

    @Value("${java1234.name}")
    private String name;

    @RequestMapping(value = "/name")
    public String getName() {
        return "真厉害";
    }

    @GetMapping(value = "/type")
    public String initArticleType() {

        ArticleType articleType = new ArticleType();
        articleType.setArticleTypeName("java");
        articleType.setCreateTime(new Date());

        ArticleType articleType1 = new ArticleType();
        articleType1.setArticleTypeName("计算机网络");
        articleType1.setCreateTime(new Date());

        ArticleType articleType2 = new ArticleType();
        articleType2.setArticleTypeName("操作系统");
        articleType2.setCreateTime(new Date());

        articleTypeService.save(articleType);
        articleTypeService.save(articleType1);
        articleTypeService.save(articleType2);

        return "success";
    }

    @SentinelResource("helloWorld")
    @RequestMapping("helloWorld")
    public String helloWorld() {
        return "Sentinel 你大爷的!" + System.currentTimeMillis();
    }


    /**
     * 用来表示资源是否被限流和降级
     *
     * @return
     */
    @SentinelResource(value = "test1", blockHandler = "blockHandlerForTest1")
    @RequestMapping("test1")
    public String test1() {
        return "Sentinel 你大爷的!test1" + System.currentTimeMillis();
    }

    public String blockHandlerForTest1(BlockException blockException) {

        blockException.printStackTrace();
        return "系统繁忙，请稍后......";
    }



}
