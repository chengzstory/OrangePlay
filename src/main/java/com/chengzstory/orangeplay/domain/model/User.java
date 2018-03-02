package com.chengzstory.orangeplay.domain.model;

import com.chengzstory.orangeplay.dal.dataobject.UserDO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chengzstory on 2018/2/28.
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 5275559345887575268L;

    private String username;
    private String password;
    private String nickname;
    private String email;
    private Long phone;
    private Date ctime;
    private Integer stat;

    public static User convertFromDO(UserDO userDO) {
        if (userDO == null) {
            return null;
        }

        User user = new User();
        BeanUtils.copyProperties(userDO, user);
        return user;
    }

    public static UserDO convertToDO(User user) {
        if (user == null) {
            return null;
        }

        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(user, userDO);
        return userDO;
    }
}
