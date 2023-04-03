package spring_container.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.*;
import spring_container.interceptors.MyInterceptors;

import java.util.List;

/**
 * ProjectName: spring_mvc_annotation
 * Package: spring_container.config
 * Description:
 *
 * @author a0909
 * @version v1.0
 * @create 2023/4/3 - 上午 11:42
 * @since JDK 1.8
 */
// 只包含 Controller 其他業務邏輯交由 Root 註冊
@ComponentScan(value = "spring_container", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {
                Controller.class
        })
}, useDefaultFilters = false)
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {



    // 視圖解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // 預設所有的jsp都從 WEB-INF 下尋找
        registry.jsp("/WEB-INF/views", ".jsp");
    }

    // 靜態資源訪問
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptors()).addPathPatterns("/**");
    }
}
