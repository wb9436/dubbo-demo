package com.wb.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wb.dao.LogInfoDao;
import com.wb.dto.LogInfoDto;
import com.wb.filter.ServiceResponse;
import com.wb.service.ILogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("logInfoService")
public class LogInfoServiceImpl implements ILogInfoService {

    @Autowired
    private LogInfoDao logInfoDao;

    @Override
    public void recordLog(ServiceResponse response) {
        LogInfoDto logInfoDto = new LogInfoDto();
        logInfoDto.setInterfaceName(response.getInterfaceName());
        logInfoDto.setMethod(response.getMethodName());
        logInfoDto.setArgs(JSONObject.toJSONString(response.getArgs()));
        logInfoDto.setResult(JSONObject.toJSONString(response.getResult()));
        logInfoDto.setCreateTime(new Date());
        logInfoDao.recordLogInfo(logInfoDto);
    }
}
