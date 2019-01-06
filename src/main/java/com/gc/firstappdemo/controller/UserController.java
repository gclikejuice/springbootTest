package com.gc.firstappdemo.controller;

import com.gc.firstappdemo.aop.Exist;
import com.gc.firstappdemo.domain.Role;
import com.gc.firstappdemo.domain.User;
import com.gc.firstappdemo.domain.UserDto;
import com.gc.firstappdemo.reposity.UserReposity;
import com.gc.firstappdemo.reposity.UserReposity2;
import com.gc.firstappdemo.reposity.UserReposity3;
import com.gc.firstappdemo.service.RoleService;
import com.gc.firstappdemo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author guicheng
 * @Date 2018/12/17 11:28
 * @Version
 **/
@RestController
@RequestMapping(value = "user")
public class UserController {
    private final ConcurrentMap<String,Object> concurrentMap = new ConcurrentHashMap<>();
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserReposity userReposity;
    @Autowired
    private UserReposity2 userReposity2;
    @Autowired
    private UserReposity3 userReposity3;


    @RequestMapping(value = "/findAll")
    public Map<String,Object> findAll(User user){
        List<User> userDtos = userServiceImpl.findAll(user);
        concurrentMap.put("data",userDtos);
        return concurrentMap;
    }

//    @RequestMapping(value = "/findPageAll")
//    public Map<String,Object> findPageAll(
//            @RequestParam(value = "pageNo",defaultValue = "0")int pageNo,
//            @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
//            User user){
//        PageInfo<List<User>> pageAll = service.findPageAll(pageNo, pageSize, user);
//        concurrentMap.put("data",pageAll);
//        return concurrentMap;
//    }

    @RequestMapping(value = "role/findAll")
    public Map<String,Object> findRoleAll(Role role){
        List<Role> roleServiceAll = roleService.findAll(role);
        concurrentMap.put("data",roleServiceAll);
        return concurrentMap;
    }

    @RequestMapping(value = "/findUserDtoAll")
    public Map<String,Object> findUserDtoAll(User user){
        List<UserDto> userDtoAll = userServiceImpl.findUserDtoAll(user);
        concurrentMap.put("data",userDtoAll);
        return concurrentMap;
    }

    @RequestMapping(value = "/findAll2")
    public Map<String,Object> findAll2(User user){
        List<User> all2 = userServiceImpl.findAll2(user);
        concurrentMap.put("data",all2);
        return concurrentMap;
    }
    @Exist
    @RequestMapping(value = "/testExist")
    public Map<String,Object> testExist(User user){
        concurrentMap.put("data","successful");
        return concurrentMap;
    }

    // 路径名前面必须加/
    @RequestMapping(value = "/error")
    public Map<String,Object> error(HttpServletRequest request, Model model){
        Object errorMessage = request.getParameter("errorMessage");
        if(errorMessage == null||!(errorMessage instanceof String)){
            concurrentMap.put("data","真发生错误了");
            return concurrentMap;
        }
        concurrentMap.put("data",(String)errorMessage);
        return concurrentMap;
    }

    @RequestMapping(value = "/insert")
    public Map<String,Object> insert(User user){
        try{
            userReposity.insert(user);
            concurrentMap.put("data","success");
        }catch (Exception e){
            e.printStackTrace();
            concurrentMap.put("data","fail");
        }finally {
            return concurrentMap;
        }
    }

    @RequestMapping(value = "/insertProvider")
    public Map<String,Object> insertProvider(User user){
        try{
            userReposity.insertProvider(user);
            concurrentMap.put("data","success");
        }catch (Exception e){
            e.printStackTrace();
            concurrentMap.put("data","fail");
        }finally {
            return concurrentMap;
        }
    }

    @RequestMapping(value = "/selectProvider")
    public Map<String,Object> selectProvider(User user){
        List<User> users = userReposity.selectProvider(user);
        concurrentMap.put("data",users);
        return concurrentMap;
    }

    @RequestMapping(value = "/insertCache")
    public Map<String,Object> insertCache(User user){
        try{
            userServiceImpl.insertCache(user);
            concurrentMap.put("data","success");
        }catch (Exception e){
            e.printStackTrace();
            concurrentMap.put("data","fail");
        }finally {
            return concurrentMap;
        }
    }


    @RequestMapping(value = "/deleteCache")
    public Map<String,Object> deleteCache(User user){
        try{
            userServiceImpl.deleteCache(user);
            concurrentMap.put("data","success");
        }catch (Exception e){
            e.printStackTrace();
            concurrentMap.put("data","fail");
        }finally {
            return concurrentMap;
        }
    }

    @RequestMapping(value = "/updateCache")
    public Map<String,Object> updateCache(User user){
        try{
            userServiceImpl.updateCache(user);
            concurrentMap.put("data","success");
        }catch (Exception e){
            e.printStackTrace();
            concurrentMap.put("data","fail");
        }finally {
            return concurrentMap;
        }
    }

    @RequestMapping(value = "/findOneCache")
    public Map<String,Object> findOneCache(User user){
        try{
            List<User> one = userServiceImpl.findOne(user);
            concurrentMap.put("data",one);
        }catch (Exception e){
            e.printStackTrace();
            concurrentMap.put("data","fail");
        }finally {
            return concurrentMap;
        }
    }

    @RequestMapping(value = "/mapperFindAll")
    public Map<String,Object> mapperFindAll(){
        List<User> users = userReposity3.findAll();
        concurrentMap.put("data",users);
        return concurrentMap;
    }
}
