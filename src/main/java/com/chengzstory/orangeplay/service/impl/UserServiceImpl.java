package com.chengzstory.orangeplay.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chengzstory.orangeplay.annotation.Authorization;
import com.chengzstory.orangeplay.dal.dataobject.UserDO;
import com.chengzstory.orangeplay.dal.mapper.UserMapper;
import com.chengzstory.orangeplay.domain.constant.MsgCenter;
import com.chengzstory.orangeplay.domain.constant.UserStatus;
import com.chengzstory.orangeplay.domain.model.Token;
import com.chengzstory.orangeplay.domain.model.User;
import com.chengzstory.orangeplay.domain.vo.response.Result;
import com.chengzstory.orangeplay.exception.GameException;
import com.chengzstory.orangeplay.service.MailService;
import com.chengzstory.orangeplay.service.TokenService;
import com.chengzstory.orangeplay.service.UserService;
import com.chengzstory.orangeplay.util.CodeUtil;
import com.chengzstory.orangeplay.util.PasswordUtil;
import com.chengzstory.orangeplay.util.UserHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserHolder userHolder;

    @Autowired
    private MailService mailService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    @Transactional
    public Result register(User user) {
        checkRegister(user);
        user.setPassword(PasswordUtil.pwd2Md5(user.getPassword()));
        userMapper.insert(User.convertToDO(user));
        updateStatus(user, UserStatus.INVALIDATE);
        return Result.success();
    }

    @Override
    public Result login(User user) {
        String password = PasswordUtil.pwd2Md5(user.getPassword());

        EntityWrapper ew = new EntityWrapper();
        ew.where("username={0}", user.getUsername()).and("password={0}", password);

        if (userMapper.selectList(ew).isEmpty()) {
            throw new GameException(MsgCenter.ERROR_LOGIN);
        }

        Token token = tokenService.createToken(user.getUsername());
        userHolder.setUser(user);
        return Result.success(token.getUsername() + "_" + token.getToken());
    }

    @Override
    public Result logout() {
        User user = userHolder.getUser();
        tokenService.deleteToken(user.getUsername());
        userHolder.remove();
        return Result.success();
    }

    @Override
    public Result sendMail() {
        User user = userHolder.getUser();
        String code = CodeUtil.generateCode();
        redisTemplate.boundValueOps(user.getEmail()).set(code, 15, TimeUnit.MINUTES);
        mailService.sendValidateMail(user.getEmail(), code);
        return Result.success();
    }

    @Override
    public Result validate(String code) {
        User user = userHolder.getUser();
        if (user == null) {
            throw new GameException(MsgCenter.TOKEN_ERROR);
        }
        String redisCode = redisTemplate.boundValueOps(user.getEmail()).get();
        if (code.equals(redisCode)) {
            updateStatus(user, UserStatus.NORMAL);
            return Result.success();
        }
        throw new GameException(MsgCenter.CODE_ERROR);
    }

    @Override
    public Result updateStatus(User user, UserStatus status) {
        UserDO userDO = User.convertToDO(user);
        EntityWrapper<UserDO> ew = new EntityWrapper<>();
        ew.where("username={0}", user.getUsername());
        userDO.setStat(status.getCode());
        userMapper.update(userDO, ew);
        return Result.success();
    }

    @Override
    public User selectOne(String username) {
        UserDO userDO = new UserDO();
        userDO.setUsername(username);

        User user = User.convertFromDO(userMapper.selectOne(userDO));
        return user;
    }

    @Override
    public Result checkUsername(String username) {
        EntityWrapper<UserDO> ew = new EntityWrapper<>();
        ew.where("username={0}", username);

        if (!userMapper.selectList(ew).isEmpty()) {
            log.error("username:{} 的用户已存在", username);
            throw new GameException(MsgCenter.USER_USERNAME_EXISTS);
        }
        return Result.success();
    }

    @Override
    public Result checkEmail(String email) {
        if (Pattern.compile("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$").
                matcher(email).find() == false) {
            throw new GameException(MsgCenter.ERROR_EMAIL);
        }

        EntityWrapper<UserDO> ew = new EntityWrapper<>();
        ew.where("email={0}", email);
        if (!userMapper.selectList(ew).isEmpty()) {
            throw new GameException(MsgCenter.EMAIL_REGISTERED);
        }
        return Result.success();
    }

    @Override
    public Result checkNickname(String nickname) {
        if (StringUtils.isBlank(nickname) || nickname.length() >= 20) {
            throw new GameException(MsgCenter.ERROR_NICINAME);
        }
        return Result.success();
    }

    @Override
    public Result checkPassword(String password) {
        if (password.length() < 6 || password.length() > 16) {
            throw new GameException(MsgCenter.ERROR_PASSWORD_FORMAT);
        }
        return Result.success();
    }

    @Override
    public Result checkPhone(String phone) {
        if (Pattern.compile("1[3|5|7|8|]\\d{9}").matcher(phone).find() == false) {
            throw new GameException(MsgCenter.ERROR_PHONE);
        }
        return Result.success();
    }

    protected void checkRegister(User user) {
        checkUsername(user.getUsername());
        checkNickname(user.getNickname());
        checkPassword(user.getPassword());
        checkEmail(user.getEmail());
        checkPhone(user.getPhone() + "");
    }
}
