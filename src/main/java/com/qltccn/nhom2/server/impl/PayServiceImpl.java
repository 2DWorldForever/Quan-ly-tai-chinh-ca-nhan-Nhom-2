package com.qltccn.nhom2.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qltccn.nhom2.model.Pay;
import com.qltccn.nhom2.mapper.PayMapper;
import com.qltccn.nhom2.server.PayService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PayServiceImpl extends ServiceImpl<PayMapper, Pay> implements PayService {
    @Override
    public BigDecimal selectTotalIncome(int userId) {
        Double totalIncome = this.baseMapper.selectTotalIncome(userId);
        if (totalIncome == null) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(totalIncome);
    }
}
