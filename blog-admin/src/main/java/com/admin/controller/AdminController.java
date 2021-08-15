package com.admin.controller;

import com.admin.service.BlogFacadeService;
import com.alibaba.nacos.common.JustForTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : controller
 * @Author : yq
 * @Date: 2021-08-15
 * @Description :
 */
@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    private BlogFacadeService blogFacadeService;

    @Autowired
    private void setBlogFacadeService(BlogFacadeService blogFacadeService) {
        this.blogFacadeService = blogFacadeService;
    }

    @RequestMapping(value = "/test")
    public String test() {
        return blogFacadeService.getName();
    }

}


