package com.jkxy.car.api.dao;

import com.jkxy.car.api.pojo.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StockMapper {
    Stock getStockByModelId(@Param("id") String id);
    Integer updateStock(Stock stock);
}
