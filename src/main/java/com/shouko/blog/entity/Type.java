package com.shouko.blog.entity;

import lombok.Data;

import java.util.ArrayList;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2020/12/14 19:57
 * @Description： 类型实体类
 * @Version: 1.0.0
 */

@Data
public class Type {
    //实现类型实体类
    private Long id; //类型ID
    private String name; //类型名称
    private ArrayList<Article> articles; //文章
}
