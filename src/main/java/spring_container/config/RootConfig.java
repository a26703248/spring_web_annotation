package spring_container.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

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
// 不包含 Controller 交由 WebApp 註冊
@ComponentScan(value = {"spring_container"}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {
                Controller.class
        })
})
public class RootConfig {
}
