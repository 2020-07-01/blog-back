package com.content.service;

import com.entity.Article;
import com.entity.ArticleType;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The interface Article type service.
 *
 * @ClassName : ArticleService
 * @Author : yq
 * @Date: 2021 -07-26
 * @Description :
 */
public interface ArticleTypeService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<ArticleType> findAll();

    /**
     * Save.
     *
     * @param articleType the article type
     */
    void save(ArticleType articleType);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(String id);
}
