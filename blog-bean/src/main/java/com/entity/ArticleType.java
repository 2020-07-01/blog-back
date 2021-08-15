package com.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @ClassName : ArticleType
 * @Author : yq
 * @Date: 2021-07-26
 * @Description :
 */
@Data
@Document(collection = "articleType")
public class ArticleType {

    @Id
    private String articleTypeId;

    private String articleTypeName;

    private Date createTime;
}
