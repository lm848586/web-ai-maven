/*package com.llm.interceptor;

import com.llm.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

*//**
 * 令牌校验的拦截器
 *//*
@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //return HandlerInterceptor.super.preHandle(request, response, handler);
        //1.获取到请求路径
        String requestURI = request.getRequestURI();

        //2.判断是否是登陆请求
        if (requestURI.contains("/login")) {
            //如果是登陆请求,直接放行
            log.info("如果是登陆请求,直接放行");
            //filterChain.doFilter(request, response);
            return true;
        }

        //3.获取请求头中的token
        String token = request.getHeader("token");

        //4.判断token是否存在
        if (token == null || token.isEmpty()) {
            log.info("token为空,响应401状态码");
            response.setStatus(401);
            return false;
        }

        //5.如果token存在,校验令牌,如果失败返回错误信息
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            log.info("校验令牌失败,响应401状态码");
            response.setStatus(401);
            return false;
        }

        //6.校验通过,放行
        return true;

    }
}*/
