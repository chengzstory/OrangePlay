package com.chengzstory.orangeplay.entity;

import java.io.Serializable;

/**
 * <p>
 * 游戏图片映射表
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
public class Img implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 游戏ID
     */
    private Integer game;
    /**
     * 图片路径
     */
    private String img;


    public Integer getGame() {
        return game;
    }

    public void setGame(Integer game) {
        this.game = game;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Img{" +
        ", game=" + game +
        ", img=" + img +
        "}";
    }
}
