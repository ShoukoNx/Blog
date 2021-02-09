package com.shouko.blog.controller;

import com.shouko.blog.query.DetailedArticle;
import com.shouko.blog.query.FirstPageArticle;
import com.shouko.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2020/12/1 21:05
 * @Description： 首页控制器
 * @Version:
 */

@Controller
public class IndexController {

    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public String index(Model model){
        List<FirstPageArticle> firstPageArticles = articleService.getFirstPageArticles();
        model.addAttribute("firstPageArticles", firstPageArticles);
        return "index";
    }

    @GetMapping("/index")
    public String index2(Model model){
        List<FirstPageArticle> firstPageArticles = articleService.getFirstPageArticles();
        model.addAttribute("firstPageArticles", firstPageArticles);
        return "index";
    }



    @GetMapping("/article/{id}")
    public String article(@PathVariable Long id, Model model){
        DetailedArticle detailedArticle = articleService.getDetailedArticle(id);
        model.addAttribute("article", detailedArticle);
        return "article";
    }


}
