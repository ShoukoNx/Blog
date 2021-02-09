package com.shouko.blog.Dao;

import com.shouko.blog.entity.Type;
import com.shouko.blog.query.FirstPageArticle;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2021/1/25 21:32
 * @Description： 类型持久层接口
 * @Version: 1.0.0
 */

@Mapper
@Repository
public interface TypeDao {

    //C
    int createType(Type type);

    //R
    Type getType(Long id);
    Type getTypeByName(String name);
    List<Type> getAllType();
    // 查询所有分类
    List<Type> getAllTypeAndArticle();


    //U
    int updateType(Type type);

    //D
    void deleteType(Long id);

}
