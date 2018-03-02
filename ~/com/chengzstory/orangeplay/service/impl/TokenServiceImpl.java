package com.chengzstory.orangeplay.service.impl;

import com.chengzstory.orangeplay.entity.Token;
import com.chengzstory.orangeplay.mapper.TokenMapper;
import com.chengzstory.orangeplay.service.TokenService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * token表 服务实现类
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
@Service
public class TokenServiceImpl extends ServiceImpl<TokenMapper, Token> implements TokenService {

}
