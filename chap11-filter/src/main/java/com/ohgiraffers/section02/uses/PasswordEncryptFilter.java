package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/member/*") // 멤버요청이 들어올때 두필터로 들어옴 아이디 이름 등등
                        //비밀번호만 암호화 암호화는 다른 클래스로 뺀다(역할분리)
                        //특정요청을 받고 가공해서 보내주는 역할
public class PasswordEncryptFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest hrequest = (HttpServletRequest) servletRequest;

        RequestWrapper wrapper = new RequestWrapper(hrequest);//RequestWrapper를 사용하면 기본 HttpServletRequest의
                                                                // 메서드를 오버라이드하여 요청의 데이터를 수정하거나 추가할 수 있습니다.

        filterChain.doFilter(wrapper, servletResponse);

    }
    @Override
    public void destroy() {

    }


}
