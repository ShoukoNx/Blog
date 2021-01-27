package com.shouko.blog.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2020/12/14 21:19
 * @Description： 用户实体类
 * @Version: 1.0.0
 */
@Data
public class User {
    private Long id; //用户ID
    private String username; //用户名
    private String password; //密码

    private String nickname; //昵称
    private String avatar; //头像
    private String type; //用户类型


    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //更新时间



}
