package com.chengzstory.orangeplay.service.impl;

import com.chengzstory.orangeplay.entity.Game;
import com.chengzstory.orangeplay.mapper.GameMapper;
import com.chengzstory.orangeplay.service.GameService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 游戏表 服务实现类
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
@Service
public class GameServiceImpl extends ServiceImpl<GameMapper, Game> implements GameService {

}
