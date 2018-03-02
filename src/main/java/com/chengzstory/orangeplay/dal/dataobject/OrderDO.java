package com.chengzstory.orangeplay.dal.dataobject;

import com.baomidou.mybatisplus.annotations.TableId;
import java.util.Date;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
@Data
public class OrderDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 购买者ID
     */
    private Integer uid;
    /**
     * 订单总价
     */
    private Double price;
    /**
     * 创建时间
     */
    private Date ctime;
    /**
     * 更新时间
     */
    private Date utime;
    /**
     * 订单状态，0为未支付，1为已支付，2为取消订单
     */
    private Integer stat;

}
