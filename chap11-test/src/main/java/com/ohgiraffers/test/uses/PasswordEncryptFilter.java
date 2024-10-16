package com.ohgiraffers.test.uses;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/member/*")
public class PasswordEncryptFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hrequest = (HttpServletRequest) servletRequest;

        RequestWrapper wrapper = new RequestWrapper(hrequest);//RequestWrapper를 사용하면 기본 HttpServletRequest의
        // 메서드를 오버라이드하여 요청의 데이터를 수정하거나 추가할 수 있습니다.

        filterChain.doFilter(wrapper, servletResponse);


    }
}
