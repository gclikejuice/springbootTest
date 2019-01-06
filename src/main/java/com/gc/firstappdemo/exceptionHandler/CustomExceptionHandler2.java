package com.gc.firstappdemo.exceptionHandler;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName CustomExceptionHandler2
 * @Description TODO
 * @Author guicheng
 * @Date 2018/12/20 9:52
 * @Version
 **/
public class CustomExceptionHandler2 implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        return null;
    }
}
