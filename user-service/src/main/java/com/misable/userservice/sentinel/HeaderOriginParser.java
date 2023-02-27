package com.misable.userservice.sentinel;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: misable
 * @Package: com.misable.userservice.sentinel
 * @ClassName: HeaderOriginParser
 * @Author: wyc
 * @Description:尝试从Request中获取一个名为origin的请求头,作为origin的值
 * @Date: 2023/2/23 9:13
 * @Version: 1.0
 */
@Component
public class HeaderOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        //获取请求头
        String origin =httpServletRequest.getHeader("origin");
        System.out.println(origin);
        //非空判断
        if (StringUtils.isEmpty(origin)){
            origin = "blank";
        }
        return origin;
    }
}
