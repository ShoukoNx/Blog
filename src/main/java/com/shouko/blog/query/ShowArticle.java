package com.shouko.blog.query;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2021/1/29 14:27
 * @Description： 在修改文章界面展示文章
 * @Version: 1.0.0
 */

@Data
public class ShowArticle {

    private Long id;
    private String title;
    private String copyrightInfo;
    private String description;
    private String content;
    private String firstPagePic;
    private Long typeId;
    private boolean canComment;
    private boolean published;
    private boolean recommend;
    private boolean canAppreciate;
    private LocalDateTime updateTime;

}
