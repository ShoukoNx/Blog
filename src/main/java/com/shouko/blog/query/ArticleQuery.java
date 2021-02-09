package com.shouko.blog.query;

import com.shouko.blog.entity.Type;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2021/1/28 14:35
 * @Description： 文章查询实体类
 * @Version: 1.0.0
 */

@Data
public class ArticleQuery {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime updateTime;
    private boolean published;
    private boolean recommend;
    private Long typeId;
    private Type type;


}
