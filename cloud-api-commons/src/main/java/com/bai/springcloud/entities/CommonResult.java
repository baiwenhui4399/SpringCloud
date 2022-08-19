package com.bai.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: SpringCloud
 * @description: 返回给前端结果类
 * @author: BaiWenHui
 * @create: 2022-07-17 10:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;//编码
    private String message;//提示
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
