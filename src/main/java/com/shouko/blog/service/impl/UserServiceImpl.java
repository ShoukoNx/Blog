package com.shouko.blog.service.impl;

import com.shouko.blog.Dao.UserDao;
import com.shouko.blog.entity.User;
import com.shouko.blog.service.UserService;
import com.shouko.blog.util.MD5Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2021/1/25 19:45
 * @Description： 用户服务类实现
 * @Version: 1.0.0
 */

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User checkUser(String username, String password) {
        String encryptedPassword = MD5Generator.code(password);
        User user = userDao.findByUsernameAndPassword(username,encryptedPassword);
        return user;
    }
}
