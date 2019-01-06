package com.gc.firstappdemo.reposity;

import com.gc.firstappdemo.domain.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @ClassName UserReposity
 * @Description TODO
 * @Author guicheng
 * @Date 2018/12/17 11:17
 * @Version
 **/
public interface UserReposity2 extends JpaRepository<User,String> {
    List<User> findUsersByUserNameIs(String userName);
}
