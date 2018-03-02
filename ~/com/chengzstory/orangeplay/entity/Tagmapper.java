package com.chengzstory.orangeplay.entity;

import java.io.Serializable;

/**
 * <p>
 * 游戏-标签映射表
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
public class Tagmapper implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 游戏ID
     */
    private Integer game;
    /**
     * 标签ID
     */
    private Integer tag;


    public Integer getGame() {
        return game;
    }

    public void setGame(Integer game) {
        this.game = game;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Tagmapper{" +
        ", game=" + game +
        ", tag=" + tag +
        "}";
    }
}
