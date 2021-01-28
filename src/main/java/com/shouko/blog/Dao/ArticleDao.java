package com.shouko.blog.Dao;

import com.shouko.blog.entity.Article;
import com.shouko.blog.query.ArticleQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2021/1/28 14:24
 * @Description： 文章管理持久层接口
 * @Version: 1.0.0
 */


@Mapper
@Repository
public interface ArticleDao {

    // 新增文章
    int createArticle(Article article);

    // 查询所有文章
    List<ArticleQuery> getAllArticles();

    // 删除文章
    void delete(Long id);
}
