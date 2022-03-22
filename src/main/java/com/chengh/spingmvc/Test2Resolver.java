package com.chengh.spingmvc;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.AbstractNamedValueMethodArgumentResolver;

public class Test2Resolver extends AbstractNamedValueMethodArgumentResolver {
    /**
     * 获取当前参数的注解信息
     *
     * @param parameter 需要被解析的Controller参数
     */
    @Override
    protected NamedValueInfo createNamedValueInfo(MethodParameter parameter) {
        Test2Annotation test2Annotation = parameter.getParameterAnnotation(Test2Annotation.class);
        return new NamedValueInfo(test2Annotation.name(), test2Annotation.required(), test2Annotation.defaultValue());
    }

    /**
     * 在这里进行参数的类型转换
     *
     * @param name
     * @param parameter 需要被解析的Controller参数
     * @param request   当前request
     * @return 转换后的参数值
     */
    @Override
    protected Object resolveName(String name, MethodParameter parameter, NativeWebRequest request) throws Exception {
        return "resolver2 success";
    }

    /**
     * 解析器是否支持当前参数
     *
     * @param parameter 需要被解析的Controller参数
     * @return 是否使用该注解
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(Test2Annotation.class);
    }
}
