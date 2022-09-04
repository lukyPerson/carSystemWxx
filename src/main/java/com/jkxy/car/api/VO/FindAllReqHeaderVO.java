package com.jkxy.car.api.VO;

import com.jkxy.car.api.pojo.AuthAble;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FindAllReqHeaderVO implements AuthAble {
    @NotBlank
    private String phone;
    @NotBlank
    private String pwd;
}
