package com.shouko.blog.Dao;

import com.shouko.blog.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2021/1/25 19:30
 * @Description： 用户持久层接口
 * @Version: 1.0.0
 */


@Repository
public interface UserDao {
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
