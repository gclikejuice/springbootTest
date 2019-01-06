package com.gc.firstappdemo.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gc.firstappdemo.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName HelloServlet
 * @Description TODO
 * @Author guicheng
 * @Date 2018/12/20 10:46
 * @Version
 **/

@WebServlet(urlPatterns = "/HelloServlet")
public class HelloServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("HelloServlet doGet: req.requestURI ="+req.getRequestURI());
        StringBuffer cookieStr = new StringBuffer();
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie : cookies){
            cookieStr.append(cookie.getName()+"="+cookie.getValue()+"\n");
        }
        Map<String,String> headers = new HashMap<>();
        logger.info("Request Headers : ");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
            headers.put(s,s);
            logger.info("header = "+s+"\n");
        }
        ObjectMapper om = new ObjectMapper();
        String resultJson = om.writeValueAsString(getMap(cookies.toString(),headers));
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        logger.info("HelloServlet doPost" + resultJson);
        out.println(resultJson);
    }

    private Map<String,Object> getMap(String cookies,Map<String,String> headers){
        Map<String,Object> map = new HashMap<>();
        map.put("userName","gui");
        map.put("id","1");
        map.put("cookie",cookies);
        map.put("headers",headers);
        return map;
    }

}
