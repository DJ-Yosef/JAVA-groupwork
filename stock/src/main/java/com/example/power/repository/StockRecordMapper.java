package com.example.power.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.power.model.StockRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface StockRecordMapper extends BaseMapper<StockRecord> {
}