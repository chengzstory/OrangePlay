package com.chengzstory.orangeplay.util;

import com.chengzstory.orangeplay.exception.GameException;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by chengzstory on 2018/2/28.
 */
@Slf4j
public class AssertUtil {

    public static void isTrue(boolean match, String errorMsg) {
        if (match) {
            throw new GameException(errorMsg);
        }
    }

    public static void isTrueWithLogger(boolean match, String errorMsg) {
        if (match) {
            log.error(errorMsg);
            throw new GameException(errorMsg);
        }
    }
}
