package com.tensquare.search.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * Created by lyj on 2019/1/23.
 * 文章实体类
 */
@Document(indexName = "tensquare",type = "article")
@Data
public class Article implements Serializable{

    @Id
    private String id;

    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String title; //标题

    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String content; //内容

    private String state; //审核状态

}
