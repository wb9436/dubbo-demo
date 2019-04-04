package com.wb.dao;

import com.wb.dto.LogInfoDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogInfoDao {

    int recordLogInfo(LogInfoDto logInfoDto);

    List<LogInfoDto> getLogList();

}
