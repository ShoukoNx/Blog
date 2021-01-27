package com.shouko.blog.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2020/12/14 19:53
 * @Description： 评论实体类
 * @Version: 1.0.0
 */

@Data
public class Comment {
    //TODO:
    private Long id; //评论id
    private String nickname; //评论用户名
    private String avatar; //评论头像
    private String type; //评论类型：管理员、普通用户
    private String content; //评论内容


    private Comment parentComment; //父评论id
    private ArrayList<Comment> replies; //子评论id

    private LocalDateTime createTime; //发布日期

}
