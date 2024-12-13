package com.example.power.controller;

import com.example.power.model.StockRecord;
import com.example.power.service.StockRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockRecordController {

    @Autowired
    private StockRecordService stockRecordService;

    /**
     * 根据 name 查询数据库，并返回 id 最大的记录
     *
     * @param name 股票名称
     * @return id 最大的记录
     */
    @GetMapping("/getLatestRecordByName")
    public StockRecord getLatestRecordByName(@RequestParam String name) {
        return stockRecordService.getLatestRecordByName(name);
    }
    @GetMapping("/getStockNames")
    public List<String> getStockNames() {
        return stockRecordService.getStockNamesList();
    }
    /**
     * 保存股票记录
     *
     * @param stockRecord 股票记录对象
     * @return 保存结果
     */
    @PostMapping("/save")
    public String saveStockRecord(@RequestBody StockRecord stockRecord) {
        boolean isSaved = stockRecordService.saveStockRecord(stockRecord);
        return isSaved ? "保存成功" : "保存失败";
    }

    /**
     * 根据股票代码查询股票记录
     *
     * @param gid 股票代码
     * @return 股票记录对象
     */
    @GetMapping("/get")
    public StockRecord getStockRecord(@RequestParam String gid) {
        return stockRecordService.getByGid(gid);
    }
}