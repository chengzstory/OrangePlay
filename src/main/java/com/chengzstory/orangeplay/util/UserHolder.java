package com.chengzstory.orangeplay.util;

import com.chengzstory.orangeplay.domain.model.User;
import com.chengzstory.orangeplay.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by chengzstory on 2018/2/28.
 */
@Component
public class UserHolder {
    private static ThreadLocal<User> users = new ThreadLocal<User>();

    @Autowired
    private TokenService tokenService;

    public User getUser() {
        return users.get();
    }

    public void setUser(User user) {
        users.set(user);
    }

    public void remove() {
        users.remove();
    }
}
