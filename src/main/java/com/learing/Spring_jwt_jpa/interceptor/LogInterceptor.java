package com.learing.Spring_jwt_jpa.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class LogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle
            (HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.info("============================================================");
        log.info("RequestURL: " + request.getRequestURL());
        log.info("Method: " + request.getMethod());
        log.info("===========================================================");

        return true;
    }
}
