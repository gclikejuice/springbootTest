package com.gc.firstappdemo.exceptionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName CustomExceptionHandler
 * @Description TODO
 * @Author guicheng
 * @Date 2018/12/20 8:36
 * @Version
 **/
@ControllerAdvice
public class CustomExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request,HttpServletResponse response,Exception e){
        logger.info("异常类型名称为"+e.getMessage());
        e.printStackTrace();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessage",e.getMessage());
        modelAndView.setView(new RedirectView("/user/error"));
        request.setAttribute("errorMessage",e.getMessage());
        return modelAndView;
    }
}
