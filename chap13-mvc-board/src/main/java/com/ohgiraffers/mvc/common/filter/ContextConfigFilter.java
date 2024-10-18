package com.ohgiraffers.mvc.common.filter;

import com.ohgiraffers.mvc.common.config.ConfigLocation;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/*")  //모든 요청 받게끔 맨처음에
public class ContextConfigFilter implements Filter {
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

        //DB 접속 설정 정보 파일의 경로가 비어 있는 경우에 초기화 해준다.
        // 최초 요청 시 DB 접속 경로와 매퍼 파일 경로 설정해준다..
        if (ConfigLocation.CONNECTION_CONFIG_LOCATION == null) {
            // 경로를 알려줄것 저거어디있는지
            String root = servletRequest.getServletContext().getRealPath("/");
            //실제존재하는 디랙토리 경로
            //c:path/to/wepapp 에 저장되어있느면 그렇게나옴
            String connectionInfoPath =
                    servletRequest.getServletContext().getInitParameter("connection-info");

            ConfigLocation.CONNECTION_CONFIG_LOCATION = root + "/" + connectionInfoPath;
            System.out.println("DB 접속경로 설정 완료");

        }
        if (ConfigLocation.MAPPER_LOCATION == null) {
            String root = servletRequest.getServletContext().getRealPath("/");

            String mapperLocation =
                    servletRequest.getServletContext().getInitParameter("mapper-location");

            ConfigLocation.MAPPER_LOCATION = root + "/" + mapperLocation;
            System.out.println("매퍼 설정 완료");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
