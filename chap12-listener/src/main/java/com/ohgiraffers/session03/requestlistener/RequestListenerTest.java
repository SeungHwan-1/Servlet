package com.ohgiraffers.session03.requestlistener;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;

@WebListener
public class RequestListenerTest implements ServletRequestListener , ServletRequestAttributeListener {

    public RequestListenerTest() {
        /*  context가 로드될 떄 생성자 호출하여 인스턴스는 생성된다. */
        System.out.println("request listener 인스턴스 생성");
    }

    public void requestDestroyed(ServletRequestEvent sre)  {
        /* request가 소멸될 때 호출된다. */
        System.out.println("request destoryed!!");
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae)  {
        /* request에 attribute가 제거될 때 호출된다. */
        System.out.println("request attribute removed!!");
    }

    public void requestInitialized(ServletRequestEvent sre)  {

        System.out.println("request init!!");
    }

    public void attributeAdded(ServletRequestAttributeEvent srae)  {

        System.out.println("request attribute added!!");
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae)  {

        System.out.println("request attribute replaced!!");
        System.out.println(srae.getName() + ", " + srae.getValue());
    }

}
