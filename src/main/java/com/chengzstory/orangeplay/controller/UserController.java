package com.chengzstory.orangeplay.controller;

import com.chengzstory.orangeplay.annotation.Authorization;
import com.chengzstory.orangeplay.domain.constant.MsgCenter;
import com.chengzstory.orangeplay.domain.vo.request.UserRequest;
import com.chengzstory.orangeplay.domain.vo.response.Result;
import com.chengzstory.orangeplay.domain.vo.response.TokenResponse;
import com.chengzstory.orangeplay.service.UserService;
import com.chengzstory.orangeplay.util.AssertUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by chengzstory on 2018/2/28.
 */
@RestController
@RequestMapping("user")
@Slf4j
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public Result register(@RequestBody UserRequest userRequest, HttpServletResponse response) {
        log.error(userRequest.toString());
        checkUserParam(userRequest);
        userService.register(UserRequest.convertTo(userRequest));
        return login(userRequest, response);
    }

    @GetMapping("sendMail")
    @Authorization
    public Result sendMail() {
        return userService.sendMail();
    }

    @PostMapping("validate")
    @Authorization
    public Result validate(String code) {
        return userService.validate(code);
    }

    @GetMapping("login")
    public Result login(UserRequest userRequest, HttpServletResponse response) {
        checkUserParam(userRequest);
        Result result  = userService.login(UserRequest.convertTo(userRequest));
        Cookie cookie = new Cookie("token", (String) result.getData());
        response.addCookie(cookie);
        return Result.success();
    }


    @GetMapping("logout")
    @Authorization
    public Result logout() {
        return userService.logout();
    }

    private void checkUserParam(UserRequest userRequest) {
        AssertUtil.isTrueWithLogger(StringUtils.isEmpty(userRequest.getUsername()), MsgCenter.EMPTY_USERNAME);
        AssertUtil.isTrueWithLogger(StringUtils.isEmpty(userRequest.getNickname()), MsgCenter.EMPTY_NICKNAME);
        AssertUtil.isTrueWithLogger(StringUtils.isEmpty(userRequest.getPassword()), MsgCenter.EMPTY_PASSWORD);
        AssertUtil.isTrueWithLogger(StringUtils.isEmpty(userRequest.getEmail()), MsgCenter.EMPTY_EMAIL);
        AssertUtil.isTrueWithLogger(StringUtils.isEmpty(userRequest.getPhone() + ""), MsgCenter.EMPTY_PHONE);
    }

    @GetMapping("checkUsername")
    public Result checkUsername(String username) {
        AssertUtil.isTrueWithLogger(StringUtils.isEmpty(username), MsgCenter.EMPTY_USERNAME);
        return userService.checkUsername(username);
    }
    @GetMapping("checkNickname")
    public Result checkNickname(String nickname) {
        AssertUtil.isTrueWithLogger(StringUtils.isEmpty(nickname), MsgCenter.EMPTY_NICKNAME);
        return userService.checkNickname(nickname);
    }
    @GetMapping("checkPassword")
    public Result checkPassword(String password) {
        AssertUtil.isTrueWithLogger(StringUtils.isEmpty(password), MsgCenter.EMPTY_PASSWORD);
        return userService.checkPassword(password);
    }
    @GetMapping("checkEmail")
    public Result checkEmail(String email) {
        AssertUtil.isTrueWithLogger(StringUtils.isEmpty(email), MsgCenter.EMPTY_EMAIL);
        return userService.checkEmail(email);
    }
    @GetMapping("checkPhone")
    public Result checkPhone(String phone) {
        AssertUtil.isTrueWithLogger(StringUtils.isEmpty(phone), MsgCenter.EMPTY_PHONE);
        return userService.checkPhone(phone);
    }
}
