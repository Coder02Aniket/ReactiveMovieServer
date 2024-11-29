package com.project.interceptors;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNullApi;

import java.net.URI;

@Component

public class RedirectOutOfContextRequests implements WebFilter {


    Logger logger = LoggerFactory.getLogger(RedirectOutOfContextRequests.class);




    @Override

    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        logger.info("inside the filter {}", getClass());

        var request =  exchange.getRequest()  ; var response = exchange.getResponse();
        logger.info("{}",request.getURI().getPath());
        if(!request.getURI().getPath().startsWith("/movie") && !request.getURI().getPath().startsWith("/repo")){
            logger.info("WILL REDIRECT OUT OF CONTEXT REQUEST");

            response.setStatusCode(HttpStatusCode.valueOf(302));
            response.getHeaders().setLocation(URI.create("/movie"));

            return response.setComplete();

        }
        return chain.filter(exchange);


    }
}
