package com.zqf.spring.cloud.alibaba.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created with IntelliJ IDEA.
 * Author: Qifan Zhao
 * Date: 2019/10/24
 * Time: 11:07
 * Description:   Feign 是一个声明式的伪 HTTP 客户端，它使得写 HTTP 客户端变得更简单。
 * 使用 Feign，只需要创一个接口并注建解。它具有可插拔的注解特性，可使用 Feign 注解和 JAX-RS 注解。
 * Feign 支持可插拔的编码器和解码器。Feign 默认集成了 Ribbon，Nacos 也很好的兼容了 Feign，默认实现了负载均衡的效果
 *
 *     Feign 采用的是基于接口的注解
 *     Feign 整合了 Ribbon
 *
 * @ Modified By：
 * @Version: $version$
 */
@FeignClient(value = "service-provider")
public interface EchoService {

    @GetMapping(value = "/echo/{string}")
    String echo(@PathVariable("string") String string);

    @GetMapping(value = "/lb")
    String lb();
}
