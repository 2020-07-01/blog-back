package com.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @ClassName : Article
 * @Author : yq
 * @Date: 2021-07-26
 * @Description :
 */
@Data
@Document(collation = "article")
public class Article {

    @Id
    private String articleId;

    private String articleTypeId;

    private String content;

    private String articleTitle;

    private Date createTime;

    private Date updateTime;

}
