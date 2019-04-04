package com.wb.filter;

import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.alibaba.fastjson.JSONObject;
import com.wb.service.ILogInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Activate
public class ServiceFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceFilter.class);

    //使用setter方法注入，service上要标明beanName
    private ILogInfoService logInfoService;
    public void setLogInfoService(ILogInfoService logInfoService) {
        this.logInfoService = logInfoService;
    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        //打印入参日志
        ServiceRequest serviceRequest = new ServiceRequest();
        serviceRequest.setInterfaceName(invocation.getInvoker().getInterface().getName());
        serviceRequest.setMethodName(invocation.getMethodName());
        serviceRequest.setArgs(invocation.getArguments());
        LOGGER.info("dubbo服务接口入参: " + JSONObject.toJSONString(serviceRequest));
        //访问IP
        String clientIp = RpcContext.getContext().getRemoteHost();
        LOGGER.info("dubbo服务访问IP为{}", clientIp);
        //开始时间
        long startTime = System.currentTimeMillis();
        //执行接口调用逻辑
        Result result = invoker.invoke(invocation);
        //调用耗时
        long elapsed = System.currentTimeMillis() - startTime;
        //如果发生异常 则打印异常日志
        if (result.hasException() && invoker.getInterface() != GenericService.class) {
            LOGGER.error("dubbo执行异常: ", result.getException());
        } else {
            //打印响应日志
            ServiceResponse serviceResponse = new ServiceResponse();
            serviceResponse.setMethodName(invocation.getMethodName());
            serviceResponse.setInterfaceName(invocation.getInvoker().getInterface().getName());
            serviceResponse.setArgs(invocation.getArguments());
            serviceResponse.setResult(new Object[]{result.getValue()});
            serviceResponse.setSpendTime(elapsed);

            logInfoService.recordLog(serviceResponse);

            LOGGER.info("dubbo服务响应成功,返回数据: " + JSONObject.toJSONString(serviceResponse));
        }
        //返回结果响应结果
        return result;
    }
}
