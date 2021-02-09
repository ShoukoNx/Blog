package com.shouko.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shouko.blog.entity.Article;
import com.shouko.blog.entity.User;
import com.shouko.blog.query.ArticleQuery;
import com.shouko.blog.query.SearchArticle;
import com.shouko.blog.query.ShowArticle;
import com.shouko.blog.service.ArticleService;
import com.shouko.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2021/1/28 14:27
 * @Description： 文章管理控制器
 * @Version: 1.0.0
 */

@Controller
@RequestMapping("/admin")
public class ArticleController {


    private TypeService typeService;
    private ArticleService articleService;

    @Autowired
    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    // 文章列表
    @RequestMapping("/articles")
    public String articles(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        String order = "update_time desc";
        PageHelper.startPage(pageNum,3,order);
        List<ArticleQuery> list = articleService.getAllArticles();
        PageInfo<ArticleQuery> pageInfo = new PageInfo<ArticleQuery>(list);
        model.addAttribute("types", typeService.getAllType());
        model.addAttribute("pageInfo", pageInfo);
        return "admin/articles";
    }

    @GetMapping("/article/input")
    public String createInput(Model model){
        model.addAttribute("types", typeService.getAllType());
        model.addAttribute("article", new Article());
        return "admin/article-input";
    }


    @PostMapping("/articles")
    public String createPost(Article article, RedirectAttributes attributes, HttpSession httpSession){
        article.setUser((User) httpSession.getAttribute("user"));
        article.setUserId(article.getUser().getId());
        article.setType(typeService.getType(article.getType().getId()));
        article.setTypeId(article.getTypeId());

        int a = articleService.createArticle(article);
        if(a == 0){
            attributes.addFlashAttribute("message", "发布失败");
        }else{
            attributes.addFlashAttribute("message", "发布成功");
        }
        return "redirect:/admin/articles";
    }

    @GetMapping("/articles/{id}/input")
    public String editInput(Model model, @PathVariable Long id){
        model.addAttribute("types", typeService.getAllType());
        model.addAttribute("article", articleService.getArticleById(id));
        return "admin/article-input";
    }

    @PostMapping("/articles/{id}")
    public String editPost(ShowArticle showArticle, RedirectAttributes attributes, HttpSession httpSession){
        int a = articleService.updateArticle(showArticle);
        if(a == 0){
            attributes.addFlashAttribute("message", "修改失败");
        }else{
            attributes.addFlashAttribute("message", "修改成功");
        }
        return "redirect:/admin/articles";
    }



    @GetMapping("/articles/{id}/delete")
    public String deleteGet(@PathVariable Long id, RedirectAttributes attributes){
        articleService.deleteArticle(id);
        attributes.addFlashAttribute("message", "文章删除成功");
        return "redirect:/admin/articles";
    }

    @PostMapping("/articles/search")
    public String searchPost(SearchArticle searchArticle, Model model,
                             @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        List<ArticleQuery> articleBySearch = articleService.getArticleByTitleAndType(searchArticle);
        PageHelper.startPage(pageNum,3);
        PageInfo<ArticleQuery> pageInfo = new PageInfo<>(articleBySearch);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/articles::articleList";
    }
}
