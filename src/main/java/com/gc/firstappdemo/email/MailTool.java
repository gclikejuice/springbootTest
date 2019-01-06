package com.gc.firstappdemo.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @ClassName MailTool
 * @Description TODO
 * @Author guicheng
 * @Date 2018/12/21 15:09
 * @Version
 **/

@Service
public class MailTool {
    @Autowired
    private JavaMailSender javaMailSender;

    private Logger logger = LoggerFactory.getLogger(MailTool.class);

    @Value("${spring.mail.username}")
    private String fromUser;

    public boolean send(String userName){
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom("1197361203@qq.com");
            simpleMailMessage.setTo(userName);
            simpleMailMessage.setSubject("testSubject");
            simpleMailMessage.setText("testText");
            javaMailSender.send(simpleMailMessage);
            logger.info("发送成功");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
