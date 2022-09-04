package com.jkxy.car.api.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Base {
    private int id;
    private Date createTs;
    private Date updateTs;
    private Boolean isDelete;
}
