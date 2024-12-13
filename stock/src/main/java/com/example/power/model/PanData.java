package com.example.power.model;

import lombok.Data;

@Data
public class PanData {
    private String dot;             // 当前点数
    private String name;            // 股票名称
    private String nowPic;          // 当前涨跌图标
    private String rate;            // 涨跌率
    private String traAmount;       // 大盘成交金额
    private String traNumber;       // 大盘成交数量
}