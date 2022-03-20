package com.chengh.spingmvc;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

public class TestResolver implements HandlerMethodArgumentResolver {
    //是否启用该解析器
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //判断参数是否使用该注解
        return parameter.hasParameterAnnotation(TestAnnotation.class);
    }

    //解析逻辑
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        //获取HttpServletRequest
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        //获取注解
        TestAnnotation e = parameter.getParameterAnnotation(TestAnnotation.class);
        //从请求中获取对应名称的参数
        String s = request.getParameter(e != null ? e.value() : "s");
        //返回处理结果
        return s.toUpperCase();
    }
}
