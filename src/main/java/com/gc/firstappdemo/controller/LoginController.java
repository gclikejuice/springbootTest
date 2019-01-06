package com.gc.firstappdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/**
 * @ClassName LoginController
 * @Description TODO
 * @Author guicheng
 * @Date 2018/12/25 15:37
 * @Version
 **/
@RestController
public class LoginController {
    private final ConcurrentMap<String,Object> concurrentMap = new ConcurrentHashMap<>();

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public String login(User user){
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUserName(),user.getUserPassword());
//        subject.login(usernamePasswordToken);
//        return "login";
//    }
//    @RequestMapping("/error")
//    public String error(){
//        return "error";
//    }
//
//    @RequestMapping("/index")
//    public String index(){
//        return "index";
//    }
//
//    @RequestMapping("create")
//    @RequiresPermissions({"save"})
//    @RequiresRoles({"admin"})
//    public Map<String,Object> save(){
//        concurrentMap.put("data","success");
//        return concurrentMap;
//    }
}

