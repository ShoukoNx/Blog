package com.shouko.blog.query;

import com.shouko.blog.entity.Type;
import com.shouko.blog.entity.User;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2021/1/30 15:33
 * @Description： 首页文章
 * @Version: 1.0.0
 */

@Data
public class FirstPageArticle {

    private Long id;
    private String title;
    private String description;
    private String nickname;
    private String avatar;
    private LocalDateTime createTime;
    private Integer views;
    private String typeName;
    private String typeColor;
    private String firstPagePic;

}
