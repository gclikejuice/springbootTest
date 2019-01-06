package com.gc.firstappdemo.reposity;

import com.gc.firstappdemo.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleReposity {

    @Select("select r.* from role r\n" +
            "join user_role ur on r.id = ur.role_id\n" +
            "join users u on u.user_id = ur.user_id\n" +
            "where u.user_id = #{userId}")
    List<Role> listByUserId(String userId);
}
