package com.qltccn.nhom2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qltccn.nhom2.model.Pay;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PayMapper extends BaseMapper<Pay> {

    @Select("SELECT sum(money) FROM pay WHERE user_id = #{userId}")
    double selectTotalIncome(@Param("userId") int userId);
}
