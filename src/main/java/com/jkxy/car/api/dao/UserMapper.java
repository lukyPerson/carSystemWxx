package com.jkxy.car.api.dao;

import com.jkxy.car.api.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User getUserByPhone(@Param("phone") String phone);
}
