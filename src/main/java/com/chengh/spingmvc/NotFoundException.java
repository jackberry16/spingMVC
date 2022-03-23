package com.chengh.spingmvc;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotFoundException implements ErrorController {

    @RequestMapping("/error")
    public String error(){
        return "接口不存在！";
    }
}
