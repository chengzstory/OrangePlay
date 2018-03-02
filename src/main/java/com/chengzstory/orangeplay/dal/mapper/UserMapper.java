package com.chengzstory.orangeplay.dal.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chengzstory.orangeplay.dal.dataobject.UserDO;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
@Repository
public interface UserMapper extends BaseMapper<UserDO> {

}
