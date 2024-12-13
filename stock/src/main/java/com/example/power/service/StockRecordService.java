package com.example.power.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.power.model.*;
import com.example.power.repository.StockRecordMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StockRecordService extends ServiceImpl<StockRecordMapper, StockRecord> implements IService<StockRecord> {


    private static final Map<String, String> stockMap = new HashMap<>();

    // 静态代码块，初始化 HashMap
    static {
        stockMap.put("sz000938", "紫光股份");
        stockMap.put("sz002049", "紫光国微");
        stockMap.put("sh601901", "方正证券");
        stockMap.put("sz002294", "信立泰");
        stockMap.put("sz002030", "达安基因");
    }

    /**
     * 返回全局的 HashMap
     *
     * @return 包含股票代码和简称的 HashMap
     */
    public Map<String, String> getStockMap() {
        return stockMap;
    }


    /**
     * 返回全局的股票简称列表
     *
     * @return 包含股票简称的 List
     */
    public List<String> getStockNamesList() {
        // 将 HashMap 的 value 提取到 List 中
        return stockMap.values().stream().collect(Collectors.toList());
    }
    public StockRecord convertToStockRecord(StockResult stockResult) {
        StockRecord stockRecord = new StockRecord();

        // 提取 StockInfo 数据
        StockInfo data = stockResult.getData();
        stockRecord.setBuyFive(data.getBuyFive());
        stockRecord.setBuyFivePri(data.getBuyFivePri());
        stockRecord.setBuyFour(data.getBuyFour());
        stockRecord.setBuyFourPri(data.getBuyFourPri());
        stockRecord.setBuyOne(data.getBuyOne());
        stockRecord.setBuyOnePri(data.getBuyOnePri());
        stockRecord.setBuyThree(data.getBuyThree());
        stockRecord.setBuyThreePri(data.getBuyThreePri());
        stockRecord.setBuyTwo(data.getBuyTwo());
        stockRecord.setBuyTwoPri(data.getBuyTwoPri());
        stockRecord.setCompetitivePri(data.getCompetitivePri());
        stockRecord.setDate(data.getDate());
        stockRecord.setGid(data.getGid());
        stockRecord.setIncrePer(data.getIncrePer());
        stockRecord.setIncrease(data.getIncrease());
        stockRecord.setName(data.getName());
        stockRecord.setNowPri(data.getNowPri());
        stockRecord.setReservePri(data.getReservePri());
        stockRecord.setSellFive(data.getSellFive());
        stockRecord.setSellFivePri(data.getSellFivePri());
        stockRecord.setSellFour(data.getSellFour());
        stockRecord.setSellFourPri(data.getSellFourPri());
        stockRecord.setSellOne(data.getSellOne());
        stockRecord.setSellOnePri(data.getSellOnePri());
        stockRecord.setSellThree(data.getSellThree());
        stockRecord.setSellThreePri(data.getSellThreePri());
        stockRecord.setSellTwo(data.getSellTwo());
        stockRecord.setSellTwoPri(data.getSellTwoPri());
        stockRecord.setTime(data.getTime());
        stockRecord.setTodayMax(data.getTodayMax());
        stockRecord.setTodayMin(data.getTodayMin());
        stockRecord.setTodayStartPri(data.getTodayStartPri());
        stockRecord.setTraAmount(data.getTraAmount());
        stockRecord.setTraNumber(data.getTraNumber());
        stockRecord.setYestodEndPri(data.getYestodEndPri());

        // 提取 PanData 数据
        PanData dapandata = stockResult.getDapandata();
        stockRecord.setDot(dapandata.getDot());
        stockRecord.setNowPic(dapandata.getNowPic());
        stockRecord.setRate(dapandata.getRate());
        stockRecord.setTraAmountPan(dapandata.getTraAmount());
        stockRecord.setTraNumberPan(dapandata.getTraNumber());

        // 提取 GoPicture 数据
        GoPicture gopicture = stockResult.getGopicture();
        stockRecord.setMinurl(gopicture.getMinurl());
        stockRecord.setDayurl(gopicture.getDayurl());
        stockRecord.setWeekurl(gopicture.getWeekurl());
        stockRecord.setMonthurl(gopicture.getMonthurl());

        return stockRecord;
    }

    /**
     * 保存股票记录
     *
     * @param stockRecord 股票记录对象
     * @return 是否保存成功
     */
    public boolean saveStockRecord(StockRecord stockRecord) {
        return save(stockRecord);
    }

    /**
     * 根据股票代码查询股票记录
     *
     * @param gid 股票代码
     * @return 股票记录对象
     */
    public StockRecord getByGid(String gid) {
        return lambdaQuery().eq(StockRecord::getGid, gid).one();
    }

    /**
     * 更新股票记录
     *
     * @param stockRecord 股票记录对象
     * @return 是否更新成功
     */
    public boolean updateStockRecord(StockRecord stockRecord) {
        return updateById(stockRecord);
    }

    /**
     * 根据股票代码删除股票记录
     *
     * @param gid 股票代码
     * @return 是否删除成功
     */
    public boolean deleteByGid(String gid) {
        return lambdaUpdate().eq(StockRecord::getGid, gid).remove();
    }

    /**
     * 根据 name 查询数据库，并返回 id 最大的记录
     *
     * @param name 股票名称
     * @return id 最大的记录
     */
    public StockRecord getLatestRecordByName(String name) {
        QueryWrapper<StockRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name) // 根据 name 查询
                .orderByDesc("id") // 按 id 降序排列
                .last("LIMIT 1");  // 取第一条记录

        return getOne(queryWrapper);
    }


    /**
     * 根据 name 查询数据库，并返回 id 最大的三条记录
     *
     * @param name 股票名称
     * @return id 最大的三条记录
     */
    public List<StockRecord> getTop3RecordsByName(String name) {
        QueryWrapper<StockRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name) // 根据 name 查询
                .orderByDesc("id") // 按 id 降序排列
                .last("LIMIT 3");  // 取前三条记录

        return list(queryWrapper);
    }
}