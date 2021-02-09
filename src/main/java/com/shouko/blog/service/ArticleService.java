package com.shouko.blog.service;

import com.shouko.blog.entity.Article;
import com.shouko.blog.query.*;

import java.util.List;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2021/1/28 14:25
 * @Description： 文章业务层接口
 * @Version: 1.0.0
 */
public interface ArticleService {

    int createArticle(Article article); // 创建文章


    List<ArticleQuery> getAllArticles(); // 在文章管理界面展示所有文章
    ShowArticle getArticleById(Long id); // 更新文章前展示文章信息
    List<ArticleQuery> getArticleByTitleAndType(SearchArticle searchArticle); // 在文章管理界面搜索文章
    List<FirstPageArticle> getFirstPageArticles(); // 获取首页文章
    List<FirstPageArticle> getArticlesByTypeId(Long typeId); // 获取文章区文章
    DetailedArticle getDetailedArticle(Long id); // 获取详情文章

    int updateArticle(ShowArticle showArticle); // 更新文章


    void deleteArticle(Long id); // 删除文章
}
