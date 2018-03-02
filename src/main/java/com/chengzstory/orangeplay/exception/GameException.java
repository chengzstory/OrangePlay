package com.chengzstory.orangeplay.exception;

/**
 * Created by chengzstory on 2018/2/28.
 */
public class GameException extends RuntimeException {
    private String message;

    public GameException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
