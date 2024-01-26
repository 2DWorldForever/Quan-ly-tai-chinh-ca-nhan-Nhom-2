package com.qltccn.nhom2.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;


@TableName("pay")
public class Pay {
    @TableField("id")
    private int id;
    @TableField("user_id")
    private int userId;
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 15, fraction = 0)
    @NotNull(message = "Vui lòng điền số tiền đã giao dịch")
    @TableField("money")
    private BigDecimal money;
    @TableField("update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Vui lòng nhập ngày thực hiện giao dịch")
    private Date updateTime;
    @TableField("comment")
    @NotEmpty(message = "Vui lòng điền tên hoặc mô tả chi phí")
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Pay{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", money=").append(money);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", comment='").append(comment).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
