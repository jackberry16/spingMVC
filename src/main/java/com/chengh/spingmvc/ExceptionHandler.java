package com.chengh.spingmvc;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        System.out.println("ExceptionHandler.resolveException");
        ModelAndView modelAndView = new ModelAndView();
        //设置出现异常后调整的页面
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
