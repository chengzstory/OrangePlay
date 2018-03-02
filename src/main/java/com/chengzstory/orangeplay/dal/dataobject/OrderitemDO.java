package com.chengzstory.orangeplay.dal.dataobject;

import com.baomidou.mybatisplus.annotations.TableId;
import java.util.Date;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 每个订单对应的订单详细内容
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
@Data
public class OrderitemDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 游戏id
     */
    private Integer gid;
    /**
     * 购买时价格
     */
    private Double price;
    /**
     * 激活码
     */
    private Integer code;
    /**
     * 创建时间
     */
    private Date ctime;
    /**
     * 更新时间
     */
    private Date utime;
}
