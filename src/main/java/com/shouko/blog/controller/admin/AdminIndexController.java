package com.shouko.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2021/2/10 15:21
 * @Description： 后台管理首页控制器
 * @Version: 1.0.0
 */

@Controller
public class AdminIndexController {
    @GetMapping("/admin/index")
    public String index(){
        return "admin/index";
    }
}
