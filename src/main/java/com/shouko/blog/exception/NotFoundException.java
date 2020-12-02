package com.shouko.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2020/12/1 21:14
 * @Description： 未知异常
 * @Version: 1.0
 */

@ResponseStatus(HttpStatus.NOT_FOUND)

public class NotFoundException extends RuntimeException {

    public NotFoundException(){
        super();
    }

    public NotFoundException(String message){
        super(message);
    }
    public NotFoundException(String message, Throwable cause){
        super(message, cause);
    }

}
