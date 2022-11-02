package com.jkxy.car.api.controller;

import com.jkxy.car.api.VO.BuyCarReqVO;
import com.jkxy.car.api.pojo.OrderTable;
import com.jkxy.car.api.service.OrderService;
import com.jkxy.car.api.service.StockService;
import com.jkxy.car.api.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    StockService stockService;

    @GetMapping("/getById")
    public JSONResult getOrderByid(@RequestParam String id){
        return JSONResult.ok(orderService.getOrderById(Integer.valueOf(id)));
    }
    @GetMapping("/getByUserId")
    public JSONResult getOrderByUserId(@RequestParam String userId){
        return JSONResult.ok(orderService.getOrderByUserId(userId));
        //切换分支测试
    }
//    下订单
    @PostMapping("/buyCar")
    public JSONResult buyCar(@RequestBody BuyCarReqVO reqVO){
        if (stockService.updateStock(reqVO.getModelId(), -1) == 1) {
            OrderTable orderTable = new OrderTable();
            orderTable.setUserId(reqVO.getUserId());
            orderTable.setModelId(reqVO.getModelId());
            orderService.insertOrder(orderTable);
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("下单失败");

    }
}
