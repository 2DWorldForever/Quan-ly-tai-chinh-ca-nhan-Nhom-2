package com.qltccn.nhom2.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qltccn.nhom2.model.Income;
import com.qltccn.nhom2.mapper.IncomeMapper;
import com.qltccn.nhom2.server.IncomeService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class IncomeServiceImpl extends ServiceImpl<IncomeMapper, Income> implements IncomeService {
    @Override
    public BigDecimal selectTotalIncome(int userId) {
        Double totalIncome = this.baseMapper.selectTotalIncome(userId);
        if (totalIncome == null) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(totalIncome);
    }
}
