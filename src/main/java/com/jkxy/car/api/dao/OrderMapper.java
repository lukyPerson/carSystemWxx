package com.jkxy.car.api.dao;

import com.jkxy.car.api.pojo.OrderTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface OrderMapper {

    List<OrderTable> getOrder(@Param("orderId") int orderId);

    List<OrderTable> getOrderByUserId(@Param("userId") String userId);

    int insertOrder(@Param("order") OrderTable orderTable);
}
