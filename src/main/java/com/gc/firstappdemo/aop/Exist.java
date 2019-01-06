package com.gc.firstappdemo.aop;

import java.lang.annotation.*;

/**
 * @ClassName Exist
 * @Description TODO
 * @Author guicheng
 * @Date 2018/12/20 15:31
 * @Version
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Exist {
}
