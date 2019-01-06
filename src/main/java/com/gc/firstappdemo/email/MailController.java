package com.gc.firstappdemo.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @ClassName MailController
 * @Description TODO
 * @Author guicheng
 * @Date 2018/12/21 15:42
 * @Version
 **/
@RestController
@RequestMapping("/mail")
public class MailController {

    public final static ConcurrentMap<String,Object> map = new ConcurrentHashMap<>();

    @Autowired
    private MailTool mailTool;

    @RequestMapping("/send")
    public Map<String,Object> mail(String userName){
        map.put("data",mailTool.send(userName));
        return map;
    }
}
