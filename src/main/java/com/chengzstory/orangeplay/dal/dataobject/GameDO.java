package com.chengzstory.orangeplay.dal.dataobject;

import com.baomidou.mybatisplus.annotations.TableId;
import java.util.Date;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 游戏表
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
@Data
public class GameDO implements Serializable {

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

}
