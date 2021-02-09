package com.shouko.blog.Dao;

import com.shouko.blog.entity.Article;
import com.shouko.blog.entity.Type;
import com.shouko.blog.query.*;
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
    int updateArticle(ShowArticle showArticle);

    // 查询所有文章
    List<ArticleQuery> getAllArticles();
    // 根据id查询文章
    ShowArticle getArticleById(Long id);
    // 搜索文章
    List<ArticleQuery> getArticleByTitleAndType(SearchArticle searchArticle);
    // 获取首页文章
    List<FirstPageArticle> getFirstPageArticles();
    // 根据typeId查询对应的文章
    List<FirstPageArticle> getArticlesByTypeId(Long typeId);
    // 获取文章页面详情
    DetailedArticle getDetailedArticle(Long id);

    // 更新访问量
    int updateViews(Long id);


    // 删除文章
    void delete(Long id);
}
