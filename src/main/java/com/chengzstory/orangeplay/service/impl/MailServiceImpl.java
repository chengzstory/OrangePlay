package com.chengzstory.orangeplay.service.impl;

import com.chengzstory.orangeplay.domain.constant.MsgCenter;
import com.chengzstory.orangeplay.exception.GameException;
import com.chengzstory.orangeplay.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by chengzstory on 2018/2/28.
 */
@Slf4j
@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender sender;

    @Value("${spring.mail.username}")
    private String from;

    public void sendMail(String to, String subject, String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        try {
            sender.send(message);
            log.info("注册验证邮件已经发送");
        } catch (Exception e) {
            log.error("注册验证邮件时发生异常");
            e.printStackTrace();
            throw new GameException(MsgCenter.Mail_SEND_FAILED);
        }
    }

    public void sendValidateMail(String to, String code) {
        String title = "OrangePlay注册验证码";
        String content = "感谢您注册WePlay，您的验证码为 \n" + code + "\n，请注意保存，此验证码有效期为 10分钟 ，并且只能使用一次。";

        sendMail(to, title, content);
    }

    public void sendFetchMail(String to, String code) {
        String title = "OrangePlay找回密码";
        String content = "这封邮件是在验证您的WePlay邮箱，用来找回密码，如果不是您本人的操作，请忽略此邮件。\n您的验证码为 \n" + code + "\n请注意保存，此验证码有效期为 10分钟 ，并且只能使用一次。";

        sendMail(to, title, content);
    }
}

