package com.gc.firstappdemo.mybatis;

import com.gc.firstappdemo.domain.User;
import org.apache.ibatis.jdbc.SQL;

public class UserDynaSql {
    public String selectProvider(User user){
        return new SQL(){
            {
              SELECT("*");
              FROM("user");
              if(user.getUserName() != null){
                  WHERE("user_name = #{userName}");
              }
            }
        }.toString();
    }

    public String insertProvider(User user){
        return new SQL(){
            {
                INSERT_INTO("user");
                if(user.getUserName() != null){
                    VALUES("user_name","#{userName}");
                }
                if(user.getUserId() != null){
                    VALUES("user_id","#{userId}");
                }
            }
        }.toString();
    }
}
