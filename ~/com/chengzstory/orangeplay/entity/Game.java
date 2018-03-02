package com.chengzstory.orangeplay.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import java.util.Date;
import com.baomidou.mybatisplus.enums.IdType;
import java.io.Serializable;

/**
 * <p>
 * 游戏表
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 开发者
     */
    private String creater;
    /**
     * 游戏名字
     */
    private String name;
    /**
     * 游戏描述
     */
    private String desc;
    /**
     * 系统配置要求
     */
    private String systemcfg;
    /**
     * 正常价格
     */
    private Double price;
    /**
     * 打折后价格
     */
    private Double discount;
    /**
     * 创建时间
     */
    private Date ctime;
    /**
     * 上架时间
     */
    private Date utime;
    /**
     * 状态，0为未上架，1为已上架，2为已下架
     */
    private Integer stat;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSystemcfg() {
        return systemcfg;
    }

    public void setSystemcfg(String systemcfg) {
        this.systemcfg = systemcfg;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return "Game{" +
        ", id=" + id +
        ", creater=" + creater +
        ", name=" + name +
        ", desc=" + desc +
        ", systemcfg=" + systemcfg +
        ", price=" + price +
        ", discount=" + discount +
        ", ctime=" + ctime +
        ", utime=" + utime +
        ", stat=" + stat +
        "}";
    }
}
