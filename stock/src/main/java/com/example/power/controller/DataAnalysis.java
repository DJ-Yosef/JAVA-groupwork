
package com.example.power.controller;


import com.example.power.model.StockRecord;
import com.example.power.model.StockResult;
import com.example.power.model.MainResponse;
import com.example.power.service.StockRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/AI")

public class DataAnalysis {

    @Resource
    private SparkManager sparkManager;


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StockRecordService stockRecordService;


    @GetMapping("/askAIanswer")
    public String answerQuestion(@RequestParam String ask, @RequestParam String name) {

        // 直接使用传入的name作为gid，去掉原来反转stockMap的逻辑
        String gid = name;

        // 硬编码的请求参数
        String url = "http://web.juhe.cn/finance/stock/hs?key=feda13679811972f011db554e2f863e4" + "&gid=" + gid;

        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/x-www-form-urlencoded");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // 发送GET请求
        ResponseEntity<MainResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, MainResponse.class);

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            MainResponse body = response.getBody();

            // 遍历 result 中的每个 StockResult
            for (StockResult stockResult : body.getResult()) {
                // 将 StockResult 转换为 StockRecord
                StockRecord stockRecord = stockRecordService.convertToStockRecord(stockResult);
                stockRecordService.save(stockRecord);
            }
        }
        StockResult stockResult = response.getBody().getResult().get(0);

        String ask1 = "咨询类问题：这是我的问题：" + ask + "请你根据以下的股票数据回答" + stockResult.toString();
        String answer = sparkManager.sendMesToAIUseXingHuo(ask1.toString()); // 调用 AI 接口获取答案
        return answer;
    }

    @GetMapping("/predictStockData")
    public String predictStockData(@RequestParam String ask,@RequestParam String name) {

        List<StockRecord> top3RecordsByName = stockRecordService.getTop3RecordsByName(name);
        String ask1 = "预测类问题：这是我的问题：" + ask + "请你基本以下的股票数据回答" + top3RecordsByName.toString();
        String answer = sparkManager.sendMesToAIUseXingHuo(ask1.toString()); // 调用 AI 接口获取答案
        return answer;

    }

}
