package com.chengzstory.orangeplay.service;

import com.chengzstory.orangeplay.domain.constant.UserStatus;
import com.chengzstory.orangeplay.domain.model.User;
import com.chengzstory.orangeplay.domain.vo.response.Result;
import com.chengzstory.orangeplay.domain.vo.response.TokenResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
public interface UserService {
    Result register(User user);

    Result updateStatus(User user, UserStatus status);

    Result login(User user);

    Result logout();

    Result sendMail();

    Result validate(String code);

    User selectOne(String username);

    Result checkUsername(String username);

    Result checkEmail(String email);

    Result checkNickname(String nickname);

    Result checkPassword(String password);

    Result checkPhone(String phone);
}


