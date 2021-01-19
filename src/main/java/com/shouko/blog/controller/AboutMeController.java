package com.shouko.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author ShoukoNx
 * @Date Created in 2021/1/18 13:08
 * @Description 关于我界面控制器
 * @Version 1.0.0
 */

@Controller
public class AboutMeController {

    @GetMapping("/about")
    public String about(){
        return "about";
    }
}
