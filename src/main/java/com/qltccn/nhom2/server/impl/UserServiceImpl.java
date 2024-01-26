package com.qltccn.nhom2.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qltccn.nhom2.model.User;
import com.qltccn.nhom2.mapper.UserMapper;
import com.qltccn.nhom2.server.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
