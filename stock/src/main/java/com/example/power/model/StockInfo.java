package com.example.power.model;

import lombok.Data;

@Data
public class StockInfo {
    private String buyFive;         // 买五数量
    private String buyFivePri;      // 买五价格
    private String buyFour;         // 买四数量
    private String buyFourPri;      // 买四价格
    private String buyOne;          // 买一数量
    private String buyOnePri;       // 买一价格
    private String buyThree;        // 买三数量
    private String buyThreePri;     // 买三价格
    private String buyTwo;          // 买二数量
    private String buyTwoPri;       // 买二价格
    private String competitivePri;  // 竞价价格
    private String date;            // 日期
    private String gid;             // 股票代码
    private String increPer;        // 涨跌百分比
    private String increase;        // 涨跌金额
    private String name;            // 股票名称
    private String nowPri;          // 当前价格
    private String reservePri;      // 保留价格
    private String sellFive;        // 卖五数量
    private String sellFivePri;     // 卖五价格
    private String sellFour;        // 卖四数量
    private String sellFourPri;     // 卖四价格
    private String sellOne;         // 卖一数量
    private String sellOnePri;      // 卖一价格
    private String sellThree;       // 卖三数量
    private String sellThreePri;    // 卖三价格
    private String sellTwo;         // 卖二数量
    private String sellTwoPri;      // 卖二价格
    private String time;            // 时间
    private String todayMax;        // 今日最高价
    private String todayMin;        // 今日最低价
    private String todayStartPri;   // 今日开盘价
    private String traAmount;       // 成交金额
    private String traNumber;       // 成交数量
    private String yestodEndPri;    // 昨日收盘价
}