package com.chengzstory.orangeplay.service.impl;

import com.chengzstory.orangeplay.entity.User;
import com.chengzstory.orangeplay.mapper.UserMapper;
import com.chengzstory.orangeplay.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
