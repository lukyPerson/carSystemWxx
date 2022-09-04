package com.jkxy.car.api.pojo;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import lombok.Data;

@Data
public class Stock extends Base{
    private int id;
    private String modelId;
    private String stockNum;
}
