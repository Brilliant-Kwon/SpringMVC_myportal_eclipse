package com.bitacademy.myportal.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bitacademy.myportal.vo.UserVo;

public class AuthInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("AuthInterceptor::preHandle");
        //세션 가로채기
        HttpSession session = request.getSession();
        UserVo authUser = null;

        if (session != null) {//세션이 되면 어스유저 가져옴
            authUser = (UserVo) session.getAttribute("authUser");
        }
        logger.debug("authUser:" + authUser);

        if (authUser == null) {//로그인 하지 않은 사용자
            //홈페이지로 리다이렉트
            response.sendRedirect(request.getContextPath()+"/users/login");
            return false;
        }

        return true;
    }
}
