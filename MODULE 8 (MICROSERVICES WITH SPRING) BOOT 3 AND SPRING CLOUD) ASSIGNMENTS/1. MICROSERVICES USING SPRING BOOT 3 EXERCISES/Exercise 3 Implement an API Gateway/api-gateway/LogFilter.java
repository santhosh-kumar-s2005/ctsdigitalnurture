package com.example.apigateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LogFilter implements GlobalFilter {

    private final Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("====>Request URL: {}", exchange.getRequest().getURI());
        logger.info("====>Request Method: {}", exchange.getRequest().getMethod());
        return chain.filter(exchange).then(Mono.fromRunnable(() ->
                logger.info("====>Response Status: {}", exchange.getResponse().getStatusCode())));
    }
}
