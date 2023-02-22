package com.misable.feign.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class DkpUser implements Serializable {
    private String id;
    private String password;
    private String username;
    private int state;
    private int lockState;
    private int lockTime;
    private String role;


}
