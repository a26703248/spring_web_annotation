package spring_async.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * ProjectName: spring_mvc_annotation
 * Package: spring_async.config
 * Description:
 *
 * @author a0909
 * @version v1.0
 * @create 2023/4/3 - 下午 12:46
 * @since JDK 1.8
 */
@ComponentScan(value = "spring_async", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {
                Controller.class
        })
}, useDefaultFilters = false)
public class AsyncAppConfig {
}
