package com.llm.filter;

import com.llm.utils.CurrentHolder;
import com.llm.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //1.获取到请求路径
        String requestURI = request.getRequestURI();

        //2.判断是否是登陆请求
        if (requestURI.contains("/login")) {
            //如果是登陆请求,直接放行
            log.info("如果是登陆请求,直接放行");
            filterChain.doFilter(request, response);
            return;
        }

        //3.获取请求头中的token
        String token = request.getHeader("token");

        //4.判断token是否存在
        if (token == null || token.isEmpty()) {
            log.info("token为空,响应401状态码");
            response.setStatus(401);
            return;
        }

        //5.如果token存在,校验令牌,如果失败返回错误信息
        try {
            Claims claims = JwtUtils.parseJWT(token);
            Integer empId = Integer.valueOf(claims.get("id").toString());
            CurrentHolder.setCurrentId(empId);
        } catch (Exception e) {
            log.info("校验令牌失败,响应401状态码");
            response.setStatus(401);
            return;
        }

        //6.校验通过,放行
        filterChain.doFilter(request, response);

        CurrentHolder.remove();

    }
}
