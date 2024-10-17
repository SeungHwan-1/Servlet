package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class EncodingFilter implements Filter {

    private String encodingType;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encodingType = filterConfig.getInitParameter("encoding-type");
    }

    @Override
    public void destroy() {


    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse hresponse = (HttpServletResponse) servletResponse;
        //형변환 해주는 이유가머였지
        hresponse.setCharacterEncoding(encodingType);

          filterChain.doFilter(servletRequest, servletResponse);

        //처음에 다여기로 들어옴 왜냐면 인코딩 타입때문에
    }
}
