package spring_container.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring_container.service.HelloService;

/**
 * ProjectName: spring_mvc_annotation
 * Package: spring_container.controller
 * Description:
 *
 * @author a0909
 * @version v1.0
 * @create 2023/4/3 - 上午 11:46
 * @since JDK 1.8
 */
@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;


    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        String hello = helloService.sayHello("tomcat");

        return hello;
    }



}
