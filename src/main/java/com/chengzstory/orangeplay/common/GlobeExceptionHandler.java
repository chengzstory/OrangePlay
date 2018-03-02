package com.chengzstory.orangeplay.common;

import com.chengzstory.orangeplay.domain.vo.response.Result;
import com.chengzstory.orangeplay.exception.GameException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chengzstory on 2018/3/2.
 */
@ControllerAdvice
@Slf4j
public class GlobeExceptionHandler {

    @ExceptionHandler(GameException.class)
    @ResponseBody
    public Result customHandle(GameException ex) {
        return Result.fail(ex.getMessage());
    }
}
