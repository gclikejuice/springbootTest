package com.gc.firstappdemo.service.impl;

import com.gc.firstappdemo.domain.User;
import com.gc.firstappdemo.domain.UserDto;
import com.gc.firstappdemo.reposity.UserReposity;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    PageInfo<List<User>> findPageAll(int PageSize, int PageNo, User user);


    void insert(User user);

    List<User> findAll(User user);

    void delete(User user);
}
