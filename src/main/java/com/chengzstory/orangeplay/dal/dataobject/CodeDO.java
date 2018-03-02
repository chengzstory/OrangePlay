package com.chengzstory.orangeplay.dal.dataobject;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 激活码
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
@Data
public class CodeDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 订单项ID
     */
    private Integer item;
    /**
     * 用户ID
     */
    private Integer uid;
    /**
     * 激活码
     */
    private String code;
    /**
     * 激活码状态，0表示未使用，1表示已使用
     */
    private Integer stat;

}
