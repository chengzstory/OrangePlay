package com.chengzstory.orangeplay.domain.vo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by chengzstory on 2018/2/28.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponse implements Serializable {

    private static final long serialVersionUID = 7968670115522770715L;

    private String username;

    private String token;
}
