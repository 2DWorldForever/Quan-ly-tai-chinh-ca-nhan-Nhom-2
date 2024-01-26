package com.qltccn.nhom2.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;


@TableName(value = "user")
public class User {
    @TableField("id")
    private int id;
    @TableField("uname")
    @NotEmpty(message = "Vui lòng nhập tên đăng nhập")
    private String uname;
    @TableField("password")
    @NotEmpty(message = "Vui lòng nhập mật khẩu")
    private String password;
    @TableField("warn")
    private BigDecimal warn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getWarn() {
        return warn;
    }

    public void setWarn(BigDecimal warn) {
        this.warn = warn;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", uname='").append(uname).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", warn=").append(warn);
        sb.append('}');
        return sb.toString();
    }
}
