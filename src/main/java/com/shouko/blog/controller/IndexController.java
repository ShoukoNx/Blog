package com.shouko.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2020/12/1 21:05
 * @Description： 首页控制器
 * @Version:
 */

@Controller
public class IndexController {
    //TODO

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/article/{id}")
    public String article(@PathVariable Long id, Model model){
        return "article";
    }

}
