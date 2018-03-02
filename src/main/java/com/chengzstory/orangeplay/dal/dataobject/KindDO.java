package com.chengzstory.orangeplay.dal.dataobject;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 游戏种类表
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
@Data
public class KindDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 种类ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 种类名字
     */
    private String name;



}
