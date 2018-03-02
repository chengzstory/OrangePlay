package com.chengzstory.orangeplay.service.impl;

import com.chengzstory.orangeplay.entity.Code;
import com.chengzstory.orangeplay.mapper.CodeMapper;
import com.chengzstory.orangeplay.service.CodeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 激活码 服务实现类
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
@Service
public class CodeServiceImpl extends ServiceImpl<CodeMapper, Code> implements CodeService {

}
