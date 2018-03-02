package com.chengzstory.orangeplay.domain.model;

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
public class Token implements Serializable {

    private static final long serialVersionUID = -5441536270981740203L;

    private String username;

    private String token;
}
