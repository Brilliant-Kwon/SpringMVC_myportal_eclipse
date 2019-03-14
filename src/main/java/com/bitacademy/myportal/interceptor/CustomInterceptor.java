package com.bitacademy.myportal.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(CustomInterceptor.class);

    //컨트롤러가 호출되기 이전에 먼저 가로채기
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //리턴값이 false면 뒤쪽으로 제어를 넘기지 않음
        //리턴값이 true면 뒤쪽으로 요청과 응답 객체를 넘김
        logger.info("CustomInterceptor::preHandle");

        return true;
    }

    //컨트롤러 수행 후
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("CustomInterceptor::postHandle");
    }

    //컨트롤러 수행 후 뷰 작업까지 완료된 후
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info("CustomInterceptor::afterCompletion");
    }
}
