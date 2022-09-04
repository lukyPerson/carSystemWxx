package com.jkxy.car.api.controller;

import com.jkxy.car.api.service.StockService;
import com.jkxy.car.api.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
    @Autowired
    StockService stockService;

    @GetMapping("/stock")
    public JSONResult getStockByModelId(@RequestParam String modelId){
        return JSONResult.ok(stockService.getStockByModelId(modelId));
    }
}
