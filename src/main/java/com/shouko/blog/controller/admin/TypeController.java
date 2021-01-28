package com.shouko.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shouko.blog.entity.Type;
import com.shouko.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    // 分页查询分类
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

    // 返回新增分类页面
    @GetMapping("/types/input")
    public String createInput(Model model){
        model.addAttribute("type", new Type());
        return "admin/types-input";
    }

    // 新增分类
    @PostMapping("/types")
    public String createPost(@Validated Type type, RedirectAttributes attributes){
        Type t = typeService.getTypeByName(type.getName());
        if(t != null){
            attributes.addFlashAttribute("message", "该分类已存在");
            return "redirect:/types/input";
        }
        int n = typeService.createType(type);
        if(n == 0){
            attributes.addFlashAttribute("message", "新增失败");
        }else{
            attributes.addFlashAttribute("message", " 新增成功");
        }
        return "redirect:/types";
    }

    // 返回编辑分类页面
    @GetMapping("/types/{id}/input")
    public String updateInput(@PathVariable Long id, Model model){
        model.addAttribute("type", typeService.getType(id));
        return "redirect:admin/types-input";
    }

    // 更新分类
    @PostMapping("/types/{id}")
    public String updatePost(@Validated Type type, RedirectAttributes attributes){
        Type t = typeService.getTypeByName(type.getName());
        if(t != null){
            attributes.addFlashAttribute("message", "该分类已存在");
            return "redirect:/types/input";
        }
        int n = typeService.updateType(type);
        if(n == 0){
            attributes.addFlashAttribute("message", "更新失败");
        }else{
            attributes.addFlashAttribute("message", " 更新成功");
        }
        return "redirect:/types";
    }

    // 删除分类
    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        typeService.deleteType(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/types/";
    }
}
