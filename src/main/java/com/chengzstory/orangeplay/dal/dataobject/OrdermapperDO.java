package com.chengzstory.orangeplay.dal.dataobject;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 订单-订单详情项映射表
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
@Data
public class OrdermapperDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    private Integer order;
    /**
     * 订单详情ID
     */
    private Integer item;

}
