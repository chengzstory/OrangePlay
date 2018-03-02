package com.chengzstory.orangeplay.service;

/**
 * Created by chengzstory on 2018/2/28.
 */
public interface MailService {
    void sendMail(String to, String subject, String content);

    void sendValidateMail(String to, String code);

    void sendFetchMail(String to, String code);
}
