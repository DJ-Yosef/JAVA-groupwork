package com.example.power.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data // 使用 Lombok 的 @Data 注解，自动生成 Getter、Setter、toString 等方法
@TableName("stock_record") // 指定数据库表名
public class StockRecord {

    // StockInfo 字段
    @TableField("buy_five")
    private String buyFive;         // 买五数量

    @TableField("buy_five_pri")
    private String buyFivePri;      // 买五价格

    @TableField("buy_four")
    private String buyFour;         // 买四数量

    @TableField("buy_four_pri")
    private String buyFourPri;      // 买四价格

    @TableField("buy_one")
    private String buyOne;          // 买一数量

    @TableField("buy_one_pri")
    private String buyOnePri;       // 买一价格

    @TableField("buy_three")
    private String buyThree;        // 买三数量

    @TableField("buy_three_pri")
    private String buyThreePri;     // 买三价格

    @TableField("buy_two")
    private String buyTwo;          // 买二数量

    @TableField("buy_two_pri")
    private String buyTwoPri;       // 买二价格

    @TableField("competitive_pri")
    private String competitivePri;  // 竞价价格

    @TableField("`date`")
    private String date;            // 日期

    @TableField("gid")
    private String gid;             // 股票代码

    @TableField("incre_per")
    private String increPer;        // 涨跌百分比

    @TableField("increase")
    private String increase;        // 涨跌金额

    @TableField("`name`")
    private String name;            // 股票名称

    @TableField("now_pri")
    private String nowPri;          // 当前价格

    @TableField("reserve_pri")
    private String reservePri;      // 保留价格

    @TableField("sell_five")
    private String sellFive;        // 卖五数量

    @TableField("sell_five_pri")
    private String sellFivePri;     // 卖五价格

    @TableField("sell_four")
    private String sellFour;        // 卖四数量

    @TableField("sell_four_pri")
    private String sellFourPri;     // 卖四价格

    @TableField("sell_one")
    private String sellOne;         // 卖一数量

    @TableField("sell_one_pri")
    private String sellOnePri;      // 卖一价格

    @TableField("sell_three")
    private String sellThree;       // 卖三数量

    @TableField("sell_three_pri")
    private String sellThreePri;    // 卖三价格

    @TableField("sell_two")
    private String sellTwo;         // 卖二数量

    @TableField("sell_two_pri")
    private String sellTwoPri;      // 卖二价格

    @TableField("`time`")
    private String time;            // 时间

    @TableField("today_max")
    private String todayMax;        // 今日最高价

    @TableField("today_min")
    private String todayMin;        // 今日最低价

    @TableField("today_start_pri")
    private String todayStartPri;   // 今日开盘价

    @TableField("tra_amount")
    private String traAmount;       // 成交金额

    @TableField("tra_number")
    private String traNumber;       // 成交数量

    @TableField("yestod_end_pri")
    private String yestodEndPri;    // 昨日收盘价

    // PanData 字段
    @TableField("dot")
    private String dot;             // 当前点数

    @TableField("now_pic")
    private String nowPic;          // 当前涨跌图标

    @TableField("rate")
    private String rate;            // 涨跌率

    @TableField("tra_amount_pan")
    private String traAmountPan;    // 大盘成交金额

    @TableField("tra_number_pan")
    private String traNumberPan;    // 大盘成交数量

    // GoPicture 字段
    @TableField("minurl")
    private String minurl;          // 分时图 URL

    @TableField("dayurl")
    private String dayurl;          // 日 K 线图 URL

    @TableField("weekurl")
    private String weekurl;         // 周 K 线图 URL

    @TableField("monthurl")
    private String monthurl;        // 月 K 线图 URL
}