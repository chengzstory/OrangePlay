package com.chengzstory.orangeplay.domain.vo.request;

import com.chengzstory.orangeplay.domain.model.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * Created by chengzstory on 2018/2/28.
 */
@Data
public class UserRequest implements Serializable {

    private static final long serialVersionUID = 1308882018820248408L;

    private String username;
    private String password;
    private String nickname;
    private String email;
    private Long phone;

    public static User convertTo(UserRequest userRequestVO) {
        if (userRequestVO == null) {
            return null;
        }
        User user = new User();
        BeanUtils.copyProperties(userRequestVO, user);
        return user;
    }
}
