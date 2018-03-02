package com.chengzstory.orangeplay.domain.constant;

/**
 * Created by chengzstory on 2018/2/28.
 */
public enum UserStatus {
    NORMAL(0),
    INVALIDATE(1),
    LIMITED(2),
    DELETED(3);

    int code;
    UserStatus(int code) {
        this.code = code;
    }

    public static UserStatus getByCode(int code) {
        for (UserStatus status : values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }
}
