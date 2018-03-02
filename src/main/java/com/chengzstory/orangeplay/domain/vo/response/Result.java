package com.chengzstory.orangeplay.domain.vo.response;

import com.chengzstory.orangeplay.domain.constant.MsgCenter;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by chengzstory on 2018/2/28.
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 8609999257611673895L;

    private String message;
    private T data;
    private boolean success;

    public Result(String message, T data, boolean success) {
        this.message = message;
        this.data = data;
        this.success = success;
    }

    public static Result success(Object data) {
        return new Result(MsgCenter.OK, data, true);
    }

    public static Result success() {
        return new Result(MsgCenter.OK, null, true);
    }

    public static Result fail(String message) {
        return new Result(message, null, false);
    }
}
