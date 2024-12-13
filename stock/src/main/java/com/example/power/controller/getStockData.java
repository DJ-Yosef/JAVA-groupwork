package com.example.power.controller;

import com.example.power.model.MainResponse;
import com.example.power.model.StockRecord;
import com.example.power.model.StockResult;
import com.example.power.service.StockRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class getStockData {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StockRecordService stockRecordService;


    private static final String KEY = "feda13679811972f011db554e2f863e4";


    @GetMapping("/getStockInfo/{num}")
    public String getStockInfo(@PathVariable String num) {
        // 硬编码的请求参数
        String url = "http://web.juhe.cn/finance/stock/hs?key=" + KEY + "&gid=" + num ;

        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/x-www-form-urlencoded");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // 发送GET请求

        ResponseEntity<MainResponse> response =  restTemplate.exchange(url, HttpMethod.GET, entity, MainResponse.class);



        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            MainResponse body = response.getBody();

            // 遍历 result 中的每个 StockResult
            for (StockResult stockResult : body.getResult()) {
                // 将 StockResult 转换为 StockRecord
                StockRecord stockRecord = stockRecordService.convertToStockRecord(stockResult);
                stockRecordService.save(stockRecord);
            }

            return"股票代码为：" + num+"最新数据获取成功，并已保存到数据库";
        } else {
            return "数据获取失败，请重试";
        }


    }
}
