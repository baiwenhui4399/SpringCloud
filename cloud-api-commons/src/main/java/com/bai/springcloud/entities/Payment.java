package com.bai.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: SpringCloud
 * @description: 流水号类
 * @author: BaiWenHui
 * @create: 2022-07-17 10:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private long id;
    //数据库id字段类型为bigint
    private String serial;
}
