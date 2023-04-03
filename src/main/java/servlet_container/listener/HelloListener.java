package servlet_container.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ProjectName: spring_mvc_annotation
 * Package: servlet_container.listener
 * Description:
 *
 * @author a0909
 * @version v1.0
 * @create 2023/4/3 - 上午 11:03
 * @since JDK 1.8
 */
public class HelloListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("context listener start ...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("context listener end ...");
    }
}
