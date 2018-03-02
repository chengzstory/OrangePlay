package com.chengzstory.orangeplay.dal.dataobject;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 游戏-标签映射表
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
@Data
public class TagmapperDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 游戏ID
     */
    private Integer game;
    /**
     * 标签ID
     */
    private Integer tag;

}
