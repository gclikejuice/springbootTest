package com.gc.firstappdemo.reposity;

import com.gc.firstappdemo.domain.User;
import com.gc.firstappdemo.domain.UserDto;
import com.gc.firstappdemo.mybatis.UserDynaSql;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName UserReposity
 * @Description TODO
 * @Author guicheng
 * @Date 2018/12/17 11:17
 * @Version
 **/
public interface UserReposity{

    @Select("select * from user")
    @Results({
            @Result(id=true,column = "user_Id",property = "userId"),
            @Result(column = "user_Name",property = "userName"),
            @Result(column = "user_Password",property = "userPassword"),
            @Result(column = "user_id",property = "roles",
            many = @Many(select = "com.gc.firstappdemo.reposity.RoleReposity.listByUserId",
            fetchType = FetchType.EAGER)),})
    List<UserDto> findUserDtoAll(User user);

    @Select("select * from user")
    List<User> findAll(User user);

    @Insert("INSERT INTO `test`.`user` (`user_name`, `user_id`, `user_password`) VALUES (#{userName}, ${userId}, 'userPassword');\n")
    void insert(User user);
    @Update("UPDATE `test`.`user` SET `user_name`='ggg', `user_id`='5', `user_password`='userPassword' WHERE (`user_id`='5');\n ")
    void update(User user);

    @Delete("")
    void delete(User user);

    @SelectProvider(type = UserDynaSql.class,method = "selectProvider")
    List<User> selectProvider(User user);
    @InsertProvider(type = UserDynaSql.class,method = "insertProvider")
    void insertProvider(User user);

    @Select("select * from user where user_name = #{userName}")
    User findOneByUsername(String username);
}
