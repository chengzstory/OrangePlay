package com.chengzstory.orangeplay.service;

import com.chengzstory.orangeplay.domain.model.Token;

/**
 * <p>
 * token表 服务类
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
public interface TokenService {
    Token createToken(String username);

    boolean checkToken(Token token);

    Token getToken(String authentication);

    void deleteToken(String username);
}
