package com.chengzstory.orangeplay.entity;

import java.io.Serializable;

/**
 * <p>
 * 订单-订单详情项映射表
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
public class Ordermapper implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    private Integer order;
    /**
     * 订单详情ID
     */
    private Integer item;


    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Ordermapper{" +
        ", order=" + order +
        ", item=" + item +
        "}";
    }
}
