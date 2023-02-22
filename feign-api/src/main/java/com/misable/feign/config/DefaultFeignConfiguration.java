package com.misable.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @ProjectName: misable
 * @Package: com.misable.feign.config
 * @ClassName: DefaultFeignConfiguration
 * @Author: wyc
 * @Description:
 * @Date: 2023/2/22 11:41
 * @Version: 1.0
 */
public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level logLevel(){
        return Logger.Level.BASIC;
    }
    @Bean
    public UserClientFallbackFactory userClientFallbackFactory(){
        return new UserClientFallbackFactory();
    }
}
