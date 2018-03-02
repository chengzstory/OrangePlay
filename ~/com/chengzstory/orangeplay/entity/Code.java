package com.chengzstory.orangeplay.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import java.io.Serializable;

/**
 * <p>
 * 激活码
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
public class Code implements Serializable {

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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return "Code{" +
        ", id=" + id +
        ", item=" + item +
        ", uid=" + uid +
        ", code=" + code +
        ", stat=" + stat +
        "}";
    }
}
