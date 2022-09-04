package com.jkxy.car.api.service.Impl;

import com.jkxy.car.api.common.constant.BaseConstant;
import com.jkxy.car.api.dao.UserMapper;
import com.jkxy.car.api.pojo.User;
import com.jkxy.car.api.pojo.UserDTO;
import com.jkxy.car.api.service.UserService;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getUserByPhone(String phone) {
        return userMapper.getUserByPhone(phone);
    }

    @Override
    public String login(String phone, String pwd) {
        User userByPhone = getUserByPhone(phone);
        if (userByPhone == null){
            throw new RuntimeException("用户不存在");
        }
        if (pwd.isEmpty() || !pwd.equals(userByPhone.getPwd())){
            throw new RuntimeException("密码错误");
        }
        return null;
    }
}
