package com.gc.firstappdemo.aop;

import com.gc.firstappdemo.domain.User;
import com.gc.firstappdemo.reposity.UserReposity2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;



/**
 * @ClassName Exist
 * @Description TODO
 * @Author guicheng
 * @Date 2018/12/20 15:21
 * @Version
 **/
@Component
@Aspect
public class ExistAspect {

    @Autowired
    private UserReposity2 userReposity2;

    private Logger logger = LoggerFactory.getLogger(ExistAspect.class);

    @Pointcut("@annotation(com.gc.firstappdemo.aop.Exist)")
    public void existLocation(){}

    @Before("existLocation()")
    public boolean before(JoinPoint joinPoint) throws Exception{
        Object[] args = joinPoint.getArgs();
        User user = null;
        for(Object o : args){
            if(o instanceof User){
                user = (User)o;
                break;
            }
        }
        if(user.getUserName()==null){
            logger.info("参数没有user");
            throw new Exception("参数有误");
        }
        List<User> userByUserName = userReposity2.findUsersByUserNameIs(user.getUserName());
        if(userByUserName.size()!=0){
            logger.info("用户名已存在");
            throw new Exception("用户名已存在");
        }
       return true;
    }

}
