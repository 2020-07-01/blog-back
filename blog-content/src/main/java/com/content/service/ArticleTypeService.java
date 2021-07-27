package com.content.service;

import com.entity.ArticleType;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName : ArticleService
 * @Author : yq
 * @Date: 2021-07-26
 * @Description :
 */
public interface ArticleTypeService {

    List<ArticleType> findAll();

    void save(ArticleType articleType);

}
