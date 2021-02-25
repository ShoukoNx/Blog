package com.shouko.blog.query;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2021/2/6 14:31
 * @Description： 详情博客
 * @Version: 1.0.0
 */

@Data
public class DetailedArticle {

    private Long id;
    private String copyrightInfo;
    private String title;
    private String content;
    private Integer views;

    private boolean canAppreciate;
    private Integer appreciation;

    private boolean canComment;
    private Integer commentCount;

    private String nickname;
    private String avatar;


    private String typeName;
    private String typeColor;

    private LocalDateTime updateTime;
}
