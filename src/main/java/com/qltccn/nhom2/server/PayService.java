package com.qltccn.nhom2.server;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qltccn.nhom2.model.Pay;

import java.math.BigDecimal;

public interface PayService extends IService<Pay> {

    BigDecimal selectTotalIncome(int userId);
}
