package com.shouko.blog.entity;

import lombok.Data;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2020/12/14 19:58
 * @Description： 标签实体类
 * @Version: 1.0.0
 */

@Data
public class Label {
    private Long id; //标签id
    private String name; //标签名称
}
