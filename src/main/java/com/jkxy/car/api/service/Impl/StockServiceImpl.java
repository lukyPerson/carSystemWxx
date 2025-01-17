package com.jkxy.car.api.service.Impl;

import com.google.common.collect.Interner;
import com.google.common.collect.Interners;
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
    private Interner<String> stringPool = Interners.newWeakInterner();
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
        Integer a = 0;
        synchronized (stringPool.intern(modelId)) {
            Stock stock = getStockByModelId(modelId);
            if (stock == null){
                throw new RuntimeException("车系库存不存在");
            }
            if (opNum < 0 && Integer.valueOf(stock.getStockNum()) <= 0) {
                throw new RuntimeException("库存不足");
            }
            int num = Integer.valueOf(stock.getStockNum()) + opNum;
            stock.setStockNum(String.valueOf(num));
            stock.setUpdateTs(new Date());
            a = stockMapper.updateStock(stock);
        }
        return a;
    }

    @Override
    public void deleteStock(Stock Stock) {

    }
}
