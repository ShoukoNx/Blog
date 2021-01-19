package com.shouko.blog.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2020/12/14 19:51
 * @Description： 博客实体类
 * @Version: 1.0.0
 */


@Data
public class Article {
    //TODO:
    private Long id; //文章ID
    private String title; //文章标题
    private String content; //文章内容
    private String copyrightInfo; //版权信息（转载，原创，翻译）
    private ArrayList<Label> labels; //标签

    private Integer views; //访问量

    private Long typeId; //类型ID
    private Type type; //类型实体


    private Long userId; //发布用户ID
    private User user; //发布用户实体

    private boolean canAppreciate; //是否可以赞赏
    private Integer appreciation; //赞赏数
    private boolean canComment; //是否可以评论
    private Integer commentCount; //评论总数

    private boolean published; //是否发布

    private LocalDateTime publishTime; //发布日期
    private LocalDateTime updateTime; //更新日期


}
