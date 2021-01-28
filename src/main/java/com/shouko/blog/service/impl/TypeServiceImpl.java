package com.shouko.blog.service.impl;

import com.shouko.blog.Dao.TypeDao;
import com.shouko.blog.entity.Type;
import com.shouko.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2021/1/25 21:55
 * @Description： 类型业务层接口实现
 * @Version: 1.0.0
 */

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;


    @Transactional
    @Override
    public int createType(Type type) {
        return typeDao.createType(type);
    }

    @Override
    public Type getType(Long id) {
        return typeDao.getType(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeDao.getTypeByName(name);
    }

    @Override
    public List<Type> getAllType() {
        return typeDao.getAllType();
    }

    @Override
    @Transactional
    public int updateType(Type type) {
        return typeDao.updateType(type);
    }

    @Override
    @Transactional
    public void deleteType(Long id) {
        typeDao.deleteType(id);
    }
}
