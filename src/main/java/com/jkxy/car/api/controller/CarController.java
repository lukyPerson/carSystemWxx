package com.jkxy.car.api.controller;

import com.jkxy.car.api.VO.FindAllReqHeaderVO;
import com.jkxy.car.api.VO.FindByKeyWordReqVO;
import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.service.CarService;
import com.jkxy.car.api.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping("car")
public class CarController {
    //test net
    @Autowired
    private CarService carService;


    /**
     * 模糊查询并分页展示
     *
     * @return
     */
    @GetMapping("findByKeyWord")
    public JSONResult findByKeyWord(@RequestParam String key,@RequestParam(required = false) String pageSize,@RequestParam(required = false) String currentPage) {
        List<Car> cars = carService.findByKeyWord(key,pageSize,currentPage);
        return JSONResult.ok(cars);
    }
    /**
     * 查询所有
     *
     * @return
     */
//    @LogAuth
    @GetMapping("findAll")
    public JSONResult findAll(@RequestBody @Valid FindAllReqHeaderVO req) {
        List<Car> cars = carService.findAll();
        return JSONResult.ok(cars);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @GetMapping("findById/{id}")
    public JSONResult findById(@PathVariable int id) {
        Car car = carService.findById(id);
        return JSONResult.ok(car);
    }

    /**
     * 通过车名查询
     *
     * @param carName
     * @return
     */
    @GetMapping("findByCarName/{carName}")
    public JSONResult findByCarName(@PathVariable String carName) {
        List<Car> cars = carService.findByCarName(carName);
        return JSONResult.ok(cars);
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @GetMapping("deleteById/{id}")
    public JSONResult deleteById(@PathVariable int id) {
        carService.deleteById(id);
        return JSONResult.ok();
    }

    /**
     * 通过id更新全部信息
     *
     * @return
     */
    @PostMapping("updateById")
    public JSONResult updateById(Car car) {
        carService.updateById(car);
        return JSONResult.ok();
    }

    /**
     * 通过id增加
     *
     * @param car
     * @return
     */
    @PostMapping("insertCar")
    public JSONResult insertCar(@RequestBody Car car) {
        carService.insertCar(car);
        return JSONResult.ok();
    }
}
