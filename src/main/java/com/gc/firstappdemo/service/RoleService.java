package com.gc.firstappdemo.service;

import com.gc.firstappdemo.domain.Role;
import com.gc.firstappdemo.reposity.RoleReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RoleService
 * @Description TODO
 * @Author guicheng
 * @Date 2018/12/18 13:22
 * @Version
 **/

@Service
public class RoleService {
    @Autowired
    private RoleReposity reposity;

    public List<Role> findAll(Role role){
        String userId = "1";
        List<Role> roles = reposity.listByUserId(userId);
        return roles;
    }
}
