package com.chengzstory.orangeplay.util;

import java.util.UUID;

/**
 * Created by chengzstory on 2018/3/1.
 */
public class CodeUtil {
    public static String generateCode() {
        String uuid = UUID.randomUUID().toString().toUpperCase();
        return uuid.substring(0, 5);
    }
}
