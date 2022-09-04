package com.jkxy.car.api.service.Impl;

import com.jkxy.car.api.dao.CarDao;
import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.service.CarService;
import com.jkxy.car.api.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service("carService")
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public List<Car> findByKeyWord(String key,String pageSize,String currentPage) {
        //默认一页显示十条记录，默认显示第一页
        int size = 10;
        int curPage = 1;
        if (!StringUtils.isEmpty(pageSize)){
            size = Integer.valueOf(pageSize);
        }
        if (!StringUtils.isEmpty(currentPage)){
            curPage = Integer.valueOf(currentPage);
        }
        key = "%"+key + "%";
        List<Car> cars = carDao.findByKey(key);
        List<Car> cars1 = cars.stream().sorted(Comparator.comparing(Car::getCreateTs)).collect(Collectors.toList());
        return PageUtil.pageBySubList(cars1, size, curPage);
    }

    @Override
    public Car findById(int id) {
        return carDao.findById(id);
    }

    @Override
    public List<Car> findByCarName(String carName) {
        return carDao.findByCarName(carName);
    }

    @Override
    public void deleteById(int id) {
        carDao.deleteById(id);
    }

    @Override
    public void updateById(Car car) {
        carDao.updateById(car);
    }

    @Override
    public void insertCar(Car car) {
        carDao.insertCar(car);
    }
}
