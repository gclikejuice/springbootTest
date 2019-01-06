package com.gc.firstappdemo.config;

import com.gc.firstappdemo.interceptor.CustomInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
/**
 * @ClassName CustomWebMvcConfig
 * @Description TODO
 * @Author guicheng
 * @Date 2018/12/19 13:50
 * @Version
 **/
@Configuration
public class CustomWebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/jsp/**").addResourceLocations("classpath:/jsp/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        CustomInterceptor customInterceptor = new CustomInterceptor();
        registry.addInterceptor(customInterceptor).addPathPatterns("/**")
        .excludePathPatterns("/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry){

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
//        super.addViewControllers(registry);
//        registry.addViewController("/").setViewName("/login");
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry resolverRegistry){
        super.configureViewResolvers(resolverRegistry);
        resolverRegistry.viewResolver(internalResourceViewResolver());
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setContentType("text/html");
        return viewResolver;
    }
}
