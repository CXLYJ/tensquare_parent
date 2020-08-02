package com.tensquare.base.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by lyj on 2019/1/19.
 */
@Entity
@Table(name = "tb_label")
@Data
public class Label implements Serializable{

//    @Id
//    @ExcelIgnore
//    private String id;
//    @ExcelProperty("标签名称")
//    private String labelName;
//    @ExcelProperty("使用数量")
//    private Long count;
//    @ExcelProperty("关注数")
//    private Long fans;
//    @ExcelProperty("是否推荐")
//    private String recommend;
//
//
//    @ExcelProperty("姓名")
//    private String name;
//    @ExcelProperty("年龄")
//    private String age;
//    @ExcelProperty("性别")
//    private Integer sex;
//    @ExcelProperty("简介")
//    private String description;
//    @ExcelProperty("地址")
//    private String address;
//    @ExcelIgnore
//    private Integer number;


    @Id
    @ExcelIgnore
    private String id;
    @ExcelProperty(value = {"表头1","表头1","表头31"},index = 0)
    private String labelName;
    @ExcelProperty(value = {"表头1","表头1","表头32"},index = 1)
    private Long count;
    @ExcelProperty(value = {"表头3","表头3","表头3"},index = 2)
    private Long fans;
    @ExcelProperty(value = {"表头4","表头4","表头4"},index = 3)
    private String recommend;


    @ExcelProperty(value = {"表头5","表头51","表头52"},index = 4)
    private String name;
    @ExcelProperty(value = {"表头6","表头61","表头611"},index = 5)
    private String age;
    @ExcelProperty(value = {"表头6","表头61","表头612"},index = 6)
    private Integer sex;
    @ExcelProperty(value = {"表头6","表头62","表头621"},index = 7)
    private String description;
    @ExcelProperty(value = {"表头6","表头62","表头622"},index = 8)
    private String address;
    @ExcelIgnore
    private Integer number;
}
