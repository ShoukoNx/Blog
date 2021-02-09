package com.shouko.blog.query;

import lombok.Data;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2021/1/30 14:44
 * @Description： 文章搜索类
 * @Version: 1.0.0
 */

@Data
public class SearchArticle {
    private String title;
    private Long typeId;
}
