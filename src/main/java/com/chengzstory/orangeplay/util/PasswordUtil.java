package com.chengzstory.orangeplay.util;

import org.springframework.util.DigestUtils;

/**
 * Created by chengzstory on 2018/2/28.
 */
public class PasswordUtil {
    private static final String SALT = "gp30#?>2a";

    public static String pwd2Md5(String paswword) {
        return DigestUtils.md5DigestAsHex((paswword + SALT).getBytes());
    }
}
