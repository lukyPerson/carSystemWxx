package com.jkxy.car.api.pojo;

import lombok.Data;

@Data
public class Car extends Base{
    private String carName;
    private String carType;
    private String price;
    private String carSeries;
}
