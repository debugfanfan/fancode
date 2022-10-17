package com.fan.fancode.domain.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户类
 * // @ApiModel表示对类进行说明
 *
 * @author debug_fan
 * @date 2022/10/15 14:35
 **/
@ApiModel(value = "用户实体类")
public class User {
    /**
     * 用户id
     * // @ApiModelProperty表示对类的属性进行说明
     */
    @ApiModelProperty(value = "用户唯一标识")
    private Long id;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;
    /**
     * 用户密码
     */
    @ApiModelProperty(value = "用户密码")
    private String password;

    public User() {
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

