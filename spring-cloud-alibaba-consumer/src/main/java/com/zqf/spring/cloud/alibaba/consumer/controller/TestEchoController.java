package com.zqf.spring.cloud.alibaba.consumer.controller;

import com.zqf.spring.cloud.alibaba.consumer.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Author: Qifan Zhao
 * Date: 2019/10/24
 * Time: 11:07
 * Description: Feign实例
 *
 * @ Modified By：
 * @Version: $version$
 */
@RestController
//@RefreshScope//动态刷新配置
public class TestEchoController {

    @Autowired
    EchoService echoService;

    @GetMapping(value = "/feign/echo/{string}")
    public String echo(@PathVariable String string){
        return echoService.echo(string);
    }

    @GetMapping(value = "/lb")
    public String lb(){
        return echoService.lb();
    }

    /**
     * 开始在nacos客户端上写配置
     *//*
    @Value("${user.name}")
    private String username;

    @GetMapping(value = "/config")
    public String config(){
        return echoService.echo(username);
    }*/
}
