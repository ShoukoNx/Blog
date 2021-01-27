package com.shouko.blog.service;

import com.shouko.blog.entity.User;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2021/1/25 19:43
 * @Description： 用户服务类接口
 * @Version: 1.0.0
 */
public interface UserService {
    User checkUser(String username, String password);
}
