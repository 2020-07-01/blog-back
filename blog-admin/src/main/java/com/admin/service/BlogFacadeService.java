package com.admin.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName : BlogFacadeService
 * @Author : yq
 * @Date: 2021-08-15
 * @Description :
 */
@FeignClient(name = "blog-facade")
public interface BlogFacadeService {


    @RequestMapping(value = "/init/name")
    String getName();

}

