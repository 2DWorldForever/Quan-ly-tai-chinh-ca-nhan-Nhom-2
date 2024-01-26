package com.qltccn.nhom2.dto;

import com.qltccn.nhom2.model.User;

import java.math.BigDecimal;

public class Form {

    private User user;
    private BigDecimal incomeMoney;
    private BigDecimal payMoney;
    private BigDecimal totalMoney;

    public Form(BigDecimal incomeMoney, BigDecimal payMoney, BigDecimal totalMoney) {
        this.incomeMoney = incomeMoney;
        this.payMoney = payMoney;
        this.totalMoney = totalMoney;
    }

    public Form(User user, BigDecimal incomeMoney, BigDecimal payMoney, BigDecimal totalMoney) {
        this.user = user;
        this.incomeMoney = incomeMoney;
        this.payMoney = payMoney;
        this.totalMoney = totalMoney;
    }

    public BigDecimal getIncomeMoney() {
        return incomeMoney;
    }

    public void setIncomeMoney(BigDecimal incomeMoney) {
        this.incomeMoney = incomeMoney;
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Form{");
        sb.append("user=").append(user);
        sb.append(", incomeMoney=").append(incomeMoney);
        sb.append(", payMoney=").append(payMoney);
        sb.append(", totalMoney=").append(totalMoney);
        sb.append('}');
        return sb.toString();
    }
}
