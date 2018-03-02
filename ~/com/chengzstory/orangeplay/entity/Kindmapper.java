package com.chengzstory.orangeplay.entity;

import java.io.Serializable;

/**
 * <p>
 * 游戏-种类详情项映射表
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
public class Kindmapper implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 游戏ID
     */
    private Integer game;
    /**
     * 游戏种类ID
     */
    private Integer kind;


    public Integer getGame() {
        return game;
    }

    public void setGame(Integer game) {
        this.game = game;
    }

    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "Kindmapper{" +
        ", game=" + game +
        ", kind=" + kind +
        "}";
    }
}
