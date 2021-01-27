package com.shouko.blog.service;

import com.shouko.blog.entity.Type;

import java.util.List;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2021/1/25 21:51
 * @Description： 类型业务层接口
 * @Version: 1.0.0
 */
public interface TypeService {

    //C
    int createType(Type type);

    //R
    Type getType(Long id);
    Type getTypeByName(String name);
    List<Type> getAllType();

    //U
    int updateType(Type type);

    //D
    void deleteType(Long id);

}
