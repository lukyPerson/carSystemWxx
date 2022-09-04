package com.jkxy.car.api.service;

import com.jkxy.car.api.pojo.OrderTable;
import com.jkxy.car.api.pojo.Stock;

import java.util.List;

public interface StockService {
    Stock getStockByModelId(String modelId);
    void insertStock(Stock stock);
    Integer updateStock(String modelId,int opNum);
    void deleteStock(Stock Stock);
}
