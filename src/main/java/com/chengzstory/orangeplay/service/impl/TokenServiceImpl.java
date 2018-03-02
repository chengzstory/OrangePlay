package com.chengzstory.orangeplay.service.impl;

import com.chengzstory.orangeplay.domain.constant.UserStatus;
import com.chengzstory.orangeplay.domain.model.Token;
import com.chengzstory.orangeplay.domain.model.User;
import com.chengzstory.orangeplay.service.TokenService;
import com.chengzstory.orangeplay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * token表 服务实现类
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
@Service
public class TokenServiceImpl implements TokenService {
    private RedisTemplate<String, String> redis;

    @Autowired
    private UserService userService;

    @Resource(name = "redisTemplate")
    public void setRedis(RedisTemplate redis) {
        this.redis = redis;
        // 泛型设置成 Long 后必须更改对应的序列化方案
        redis.setKeySerializer (new JdkSerializationRedisSerializer());
    }

    public Token createToken(String username) {
        // 使用 uuid 作为源 token
        String token = UUID.randomUUID().toString().replace("-", "");
        Token model = new Token (username, token);
        // 存储到 redis 并设置过期时间
        redis.boundValueOps(username).set(token, 1, TimeUnit.DAYS);
        return model;
    }

    public Token getToken(String authentication) {
        if (authentication == null || authentication.length () == 0) {
            return null;
        }
        String [] param = authentication.split("_");
        if (param.length != 2) {
            return null;
        }
        // 使用 username 和源 token 简单拼接成的 token，可以增加加密措施
        String username = param [0];
        String token = param [1];
        return new Token(username, token);
    }

    public boolean checkToken(Token model) {
        if (model == null) {
            return false;
        }
        User user = userService.selectOne(model.getUsername());
        if (user.getStat() == UserStatus.DELETED.getCode()) {
            return false;
        }
        String token = redis.boundValueOps(model.getUsername()).get();
        if (token == null || !token.equals(model.getToken())) {
            return false;
        }
        // 如果验证成功，说明此用户进行了一次有效操作，延长 token 的过期时间
        redis.boundValueOps(model.getUsername()).expire(1, TimeUnit.HOURS);
        return true;
    }

    public void deleteToken(String username) {
        redis.delete(username);
    }
}
