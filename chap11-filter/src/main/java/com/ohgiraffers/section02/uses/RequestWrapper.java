package com.ohgiraffers.section02.uses;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RequestWrapper extends HttpServletRequestWrapper {


    //이걸 가공해서 정보수정?httpservletrequest상속받고있고 지금만든건 자식의자식
    // 인터페이스는 수정이안된다 정보수정 아니면 확장하는 것들
    /*
    * HttpServeltRequestWratter 클래스는 HttpServletRequest 인터페이스를
    * 구현해놓은 클래스이다..
    * 이클래스는 request 객체의 요청 정보를 수정하거나 확장하는 용도로 사용한다..
    * 특정 파라미터의 값을 변경하거나 새로운 파라미터를 추가할 수있다.
     */
    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }
    @Override
    public String getParameter(String name) {

        String value = " ";
        //비밀번호 파라미터로 쓸때 패스워드
        if("password".equals(name)){

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            value = encoder.encode(super.getParameter(name)); //암호화해서 보내줌

        }else{
            value = super.getParameter(name);
        }

        return value;
    }

    //외부암호화를 쓴건데 그래들에 추가해줘야함
}
