package servlet_container;


import servlet_container.filter.HelloFilter;
import servlet_container.listener.HelloListener;
import servlet_container.service.HelloService;
import servlet_container.servlet.HelloServlet;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import javax.servlet.http.HttpServletRequest;
import java.util.EnumSet;
import java.util.Set;

/**
 * ProjectName: spring_mvc_annotation
 * Package: servlet_container
 * Description:
 *
 * @author a0909
 * @version v1.0
 * @create 2023/4/3 - 上午 10:36
 * @since JDK 1.8
 */
// 容器啟動的時候會獲得@HandlesTypes指定的子類
@HandlesTypes({HelloService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

    /*
    Web 啟動時會執行 onStartup
    ServletContext 為當前 Web 中的 ServletContext
    Set<Class<?>> 為 @HandlesTypes 註解內所有傳入的物件及其子類

    使用 ServletContext 註冊 Web 物件(Servlet、Filter、Listener)
     */
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        for (Class<?> claz: c) {
            System.out.println(claz);
        }

        // 註冊 servlet 物件
        ServletRegistration.Dynamic helloServlet = ctx.addServlet("HelloServlet", new HelloServlet());
        // 設定 servlet 請求路徑
        helloServlet.addMapping("/hello");

        // 註冊 listener 物件
        ctx.addListener(HelloListener.class);

        // 註冊 filter 物件
        FilterRegistration.Dynamic helloFilter = ctx.addFilter("HelloFilter", HelloFilter.class);
        // 設定 filter 攔截路徑
        helloFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }
}
