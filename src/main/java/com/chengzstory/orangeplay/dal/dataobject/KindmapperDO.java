package com.chengzstory.orangeplay.dal.dataobject;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 游戏-种类详情项映射表
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
@Data
public class KindmapperDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 游戏ID
     */
    private Integer game;
    /**
     * 游戏种类ID
     */
    private Integer kind;

}
