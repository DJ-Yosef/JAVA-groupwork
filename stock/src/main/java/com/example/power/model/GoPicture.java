package com.example.power.model;

import lombok.Data;

@Data
public class GoPicture {
    private String minurl;          // 分时图 URL
    private String dayurl;          // 日 K 线图 URL
    private String weekurl;         // 周 K 线图 URL
    private String monthurl;        // 月 K 线图 URL
}