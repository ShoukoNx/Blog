package com.shouko.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shouko.blog.entity.Type;
import com.shouko.blog.query.FirstPageArticle;
import com.shouko.blog.service.ArticleService;
import com.shouko.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2021/1/30 15:30
 * @Description： 文章区控制器
 * @Version: 1.0.0
 */

@Controller
public class ArticleZoneController {

    private ArticleService articleService;
    private TypeService typeService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Autowired
    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/article-zone")
    public String articleZone(){
        return "redirect:article-zone/-1";
    }

    @GetMapping("/article-zone/{id}")
    public String types(@PathVariable Long id,
                        @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
                        Model model){
        List<Type> types = typeService.getAllTypeAndArticle();
        if (id == -1) {
            id = types.get(0).getId();
        }
        model.addAttribute("types", types);
        List<FirstPageArticle> articles = articleService.getArticlesByTypeId(id);
        PageHelper.startPage(pageNum, 3);
        PageInfo<FirstPageArticle> pageInfo = new PageInfo<>(articles);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("activeTypeId", id);
        return "article-zone";
    }


}
