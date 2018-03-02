package com.chengzstory.orangeplay;

import com.chengzstory.orangeplay.annotation.Authorization;
import com.chengzstory.orangeplay.dal.dataobject.UserDO;
import com.chengzstory.orangeplay.dal.mapper.UserMapper;
import com.chengzstory.orangeplay.domain.constant.MsgCenter;
import com.chengzstory.orangeplay.domain.model.Token;
import com.chengzstory.orangeplay.domain.model.User;
import com.chengzstory.orangeplay.exception.GameException;
import com.chengzstory.orangeplay.service.TokenService;
import com.chengzstory.orangeplay.service.UserService;
import com.chengzstory.orangeplay.util.UserHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by chengzstory on 2018/2/28.
 */
@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserHolder userHolder;

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {
        if (! (handle instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handle;
        Method method = handlerMethod.getMethod();

        if (method.getAnnotation(Authorization.class) == null) {
            return true;
        }

        Cookie[] cookies = request.getCookies();
        Token token = null;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                token = tokenService.getToken(cookie.getValue());
            }
        }

        if (token != null && tokenService.checkToken(token)) {
            userHolder.setUser(userService.selectOne(token.getUsername()));
            return true;
        }
        throw new GameException(MsgCenter.TOKEN_ERROR);
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
