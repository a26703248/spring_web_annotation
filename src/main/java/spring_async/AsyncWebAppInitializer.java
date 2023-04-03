package spring_async;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import spring_async.config.AsyncAppConfig;
import spring_async.config.AsyncRootConfig;
import spring_container.config.RootConfig;

/**
 * ProjectName: spring_mvc_annotation
 * Package: spring_container
 * Description:
 *
 * @author a0909
 * @version v1.0
 * @create 2023/4/3 - 上午 11:36
 * @since JDK 1.8
 */
public class AsyncWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // 獲得 root 容器設定類
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AsyncRootConfig.class};
    }

    // 獲得 web 容器設定類
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AsyncAppConfig.class};
    }

    // 獲得所有 DispatcherServlet 路徑攔截
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
