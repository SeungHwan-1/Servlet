package com.ohgiraffers.section01.filter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;


import java.io.IOException;

@WebFilter("/first/*") // first거처간 모든 것
public class FristFilter implements Filter {// 인터페이스상속

    public FristFilter() {
        System.out.println("firstfilter 인스턴스 생성");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 필터 인스턴스가 최초 생성될 때 호출 되는 메소드 서버생길때부터 생김
        System.out.println("First Filter init 호출");
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // servlet 으로 request가 전달되기 전에 요청을 가로채는 역할을 하는 메소드
        System.out.println("Filter doFilter 호출");

        //필터에서 처리할 코드를 작성하는 부분

        //처리 한 후 다음 필터 혹은 서블릿의 doGet/doPost 호출
        filterChain.doFilter(servletRequest,servletResponse);
        //서블릿에서 처리 후에 다시 수행할 내용이 있으면 작성
        System.out.println("Servlet 요청 수행 완료!");
    }
    @Override
    public void destroy() {
        //필터인스턴스가 소멸될 때 호출되는 메소드 ( = 톰켓 종료시)
        System.out.println("filter destroy 호출");
    }

}
