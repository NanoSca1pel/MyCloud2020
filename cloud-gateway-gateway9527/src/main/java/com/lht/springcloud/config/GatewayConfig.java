package com.lht.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这里配置的是静态路由，和配置文件application-static.yml选其中一种方式实现即可，功能一致
 * @author lhtao
 * @date 2020/9/14 17:21
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_lht", r -> r.path("/guonei").uri("http://news.baidu.com/guonei"));
        routes.route("path_route_lht2", r -> r.path("/guoji").uri("http://news.baidu.com/guoji"));
        return routes.build();
    }
}
