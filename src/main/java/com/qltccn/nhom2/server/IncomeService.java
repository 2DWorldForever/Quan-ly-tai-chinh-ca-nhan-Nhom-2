package com.qltccn.nhom2.server;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qltccn.nhom2.model.Income;

import java.math.BigDecimal;

public interface IncomeService extends IService<Income> {

    BigDecimal selectTotalIncome(int userId);
}
