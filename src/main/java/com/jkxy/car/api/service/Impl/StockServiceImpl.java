package com.jkxy.car.api.service.Impl;

import com.jkxy.car.api.dao.StockMapper;
import com.jkxy.car.api.pojo.OrderTable;
import com.jkxy.car.api.pojo.Stock;
import com.jkxy.car.api.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class StockServiceImpl implements StockService {
    @Autowired
    StockMapper stockMapper;
    @Override
    public Stock getStockByModelId(String modelId) {
        return stockMapper.getStockByModelId(modelId);

    }

    @Override
    public void insertStock(Stock stock) {

    }

    @Override
    public Integer updateStock(String modelId,int opNum) {
        Stock stock = getStockByModelId(modelId);
        if (stock == null){
            throw new RuntimeException("车系库存不存在");
        }
        if (opNum<0 && Integer.valueOf(stock.getStockNum())<=0){
            throw new RuntimeException("库存不足");
        }
        int num = Integer.valueOf(stock.getStockNum()) + opNum;
        stock.setStockNum(String.valueOf(num));
        stock.setUpdateTs(new Date());
        return stockMapper.updateStock(stock);
    }

    @Override
    public void deleteStock(Stock Stock) {

    }
}
