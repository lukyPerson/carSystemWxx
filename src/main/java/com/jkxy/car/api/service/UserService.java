package com.jkxy.car.api.service;


import com.jkxy.car.api.pojo.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    User getUserByPhone(String phone);

    String login(String phone, String pwd);
}
