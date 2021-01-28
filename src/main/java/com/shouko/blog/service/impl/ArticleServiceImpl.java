package com.shouko.blog.service.impl;

import com.shouko.blog.Dao.ArticleDao;
import com.shouko.blog.entity.Article;
import com.shouko.blog.query.ArticleQuery;
import com.shouko.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2021/1/28 14:26
 * @Description： 文章业务层实现
 * @Version: 1.0.0
 */

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleDao articleDao;

    @Autowired
    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
    public int createArticle(Article article) {
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        article.setViews(0);
        article.setCommentCount(0);
        return articleDao.createArticle(article);
    }

    @Override
    public List<ArticleQuery> getAllArticles() {
        return articleDao.getAllArticles();
    }

    @Override
    public void deleteArticle(Long id) {
        articleDao.delete(id);
    }
}
