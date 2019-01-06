package com.gc.firstappdemo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName HelloFilter
 * @Description TODO
 * @Author guicheng
 * @Date 2018/12/20 13:47
 * @Version
 **/
@WebFilter(urlPatterns = "/HelloServlet")
public class HelloFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(HelloFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("进入init方法");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("进入doFilter方法");
        filterChain.doFilter(servletRequest,servletResponse);
        logger.info("进入doFilter之后执行setToken(response)");
        setToken(servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("进入销毁方法");
    }

    private void setToken(ServletResponse response){
        if(!(response instanceof HttpServletResponse)){
            return;
        }
        ((HttpServletResponse) response).setHeader("token","123456789");
    }
}
