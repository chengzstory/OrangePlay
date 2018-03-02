package com.chengzstory.orangeplay.dal.dataobject;

import com.baomidou.mybatisplus.annotations.TableId;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.chengzstory.orangeplay.domain.model.User;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
@Data
@TableName("user")
public class UserDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码(加盐并加密)
     */
    private String password;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 注册邮箱
     */
    private String email;
    /**
     * 手机号码
     */
    private Long phone;
    /**
     * 创建时间
     */
    private Date ctime;
    /**
     * 更新时间
     */
    private Date utime;
    /**
     * 用户状态，0为正常，1为未验证，2为受限，3为删除
     */
    private Integer stat;
}
