package servlet_async;


import servlet_async.servlet.AsyncHelloServlet;
import servlet_container.filter.HelloFilter;
import servlet_container.listener.HelloListener;
import servlet_container.service.HelloService;
import servlet_container.servlet.HelloServlet;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
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
public class AsyncServletContainerInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        ServletRegistration.Dynamic async = ctx.addServlet("AsyncHelloServlet", new AsyncHelloServlet());
        async.addMapping("/async_hello");
    }

}
