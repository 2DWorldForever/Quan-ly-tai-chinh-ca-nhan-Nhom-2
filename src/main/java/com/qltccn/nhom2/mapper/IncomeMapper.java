package com.qltccn.nhom2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qltccn.nhom2.model.Income;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface IncomeMapper extends BaseMapper<Income> {

    @Select("SELECT sum(money) FROM income WHERE user_id = #{userId}")
    double selectTotalIncome(@Param("userId") int userId);
}
