package com.example.power.model;

import lombok.Data;

import java.util.List;

@Data
public class MainResponse {
    private String resultcode; // 结果代码
    private String reason; // 请求成功的原因
    private List<StockResult> result; // 包含实际数据的数组
    private int error_code; // 错误代码


}