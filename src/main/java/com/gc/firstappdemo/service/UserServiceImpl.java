package com.gc.firstappdemo.service;

import com.gc.firstappdemo.domain.User;
import com.gc.firstappdemo.domain.UserDto;
import com.gc.firstappdemo.reposity.UserReposity;
import com.gc.firstappdemo.reposity.UserReposity2;
import com.gc.firstappdemo.service.impl.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author guicheng
 * @Date 2018/12/17 15:21
 * @Version
 **/
@Service
public class UserServiceImpl {
    @Autowired
    private UserReposity userReposity;
    @Autowired
    private UserReposity2 userReposity2;

    @Cacheable("userList")
    public List<User> findAll(User user){
        return userReposity2.findAll();
    }

    public PageInfo<List<User>> findPageAll(int pageSize,int pageNo,User user){
        PageHelper.startPage(pageNo,pageSize);
        List<User> users = userReposity.findAll(user);
        return new PageInfo(users);
    }

    public List<UserDto> findUserDtoAll(User user){
        List<UserDto> userDtoAll = userReposity.findUserDtoAll(user);
        return userDtoAll;
    }

    public List<User> findAll2(User user){
        List<User> all = userReposity2.findAll();
        return all;
    }

    @Transactional
    @CachePut(cacheNames = {"user"},key = "#user.userId")
    public void insertCache(User user){
        userReposity2.save(user);
    }

    @CacheEvict(cacheNames = {"user"},key = "#user.userId")
    public void deleteCache(User user){
        userReposity2.delete(user);
    }

    @Cacheable(cacheNames = {"user"},key = "#user.userName")
    public List<User> findOne(User user){
        return userReposity2.findUsersByUserNameIs(user.getUserName());
    }

//    @CachePut(cacheNames = {"user"},key = "#user.userName")

    @CachePut("userList")
    public List<User> updateCache(User user){
        userReposity2.saveAndFlush(user);
        List<User> users = new ArrayList<>();
        users.add(user);
        return users;
    }

}
