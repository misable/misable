//package com.misable.gateway.config;
//
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
///**
// * @ProjectName: misable
// * @Package: com.misable.gateway.config
// * @ClassName: AuthorizeFilter
// * @Author: wyc
// * @Description:
// * @Date: 2023/1/5 14:14
// * @Version: 1.0
// */
//@Order(-1)           //过滤器执行顺序
//@Component
//public class AuthorizeFilter implements GlobalFilter {
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        //1.获取请求参数
//        ServerHttpRequest request = exchange.getRequest();
//        MultiValueMap<String,String> params=request.getQueryParams();
//        //2.获取参数中的authorization
//        String auth =params.getFirst("authorization");
//        //3判断参数是否等于admin
//        if("admin".equals(auth)) {
//            //4是放行
//            return chain.filter(exchange);
//        }
//        //5否拦截
//        //5.1设置状态码
//        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//        //5.2拦截请求
//        return exchange.getResponse().setComplete();
//    }
//}
