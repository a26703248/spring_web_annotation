package spring_container.service;

import org.springframework.stereotype.Service;

/**
 * ProjectName: spring_mvc_annotation
 * Package: spring_container.service
 * Description:
 *
 * @author a0909
 * @version v1.0
 * @create 2023/4/3 - 上午 11:47
 * @since JDK 1.8
 */
@Service
public class HelloService {

    public String sayHello(String str){
        return str + " hello ...";
    }

}
