package com.chengh.spingmvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping("1")
    public String getParam(@TestAnnotation(value = "s") String s){
        System.out.println(s);
        return "success";
    }
}
