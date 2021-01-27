package com.shouko.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shouko.blog.entity.Type;
import com.shouko.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2021/1/25 23:58
 * @Description： 分类控制器
 * @Version: 1.0.0
 */

@Controller
@RequestMapping("admin")
public class TypeController {
    private TypeService typeService;

    @Autowired
    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/types")
    public String list(Model model, @RequestParam(defaultValue = "1",
            value = "pageNum") Integer pageNum){
        String order = "id desc";
        PageHelper.startPage(pageNum, 10, order);
        List<Type> list = typeService.getAllType();
        PageInfo<Type> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/types";
    }
}
