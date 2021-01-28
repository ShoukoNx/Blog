package com.shouko.blog.service;

import com.shouko.blog.entity.Article;
import com.shouko.blog.query.ArticleQuery;

import java.util.List;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2021/1/28 14:25
 * @Description： 文章业务层接口
 * @Version: 1.0.0
 */
public interface ArticleService {

    int createArticle(Article article);

    List<ArticleQuery> getAllArticles();

    void deleteArticle(Long id);
}
