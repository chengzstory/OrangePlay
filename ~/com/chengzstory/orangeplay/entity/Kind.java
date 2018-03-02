package com.chengzstory.orangeplay.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import java.io.Serializable;

/**
 * <p>
 * 游戏种类表
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
public class Kind implements Serializable {

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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Kind{" +
        ", id=" + id +
        ", name=" + name +
        "}";
    }
}
