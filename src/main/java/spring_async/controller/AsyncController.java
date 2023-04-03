package spring_async.controller;

import jdk.nashorn.internal.codegen.CompilerConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import spring_async.queue.DeferredResultQueue;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * ProjectName: spring_mvc_annotation
 * Package: spring_async.controller
 * Description:
 *
 * @author a0909
 * @version v1.0
 * @create 2023/4/3 - 下午 12:42
 * @since JDK 1.8
 */
@Controller
public class AsyncController {


    /*
        1. 控制器返回 Callable
        2. Spring 異步處理將 Callable 提交到 TaskExecutor 使用子執行緒執行
        3. DispatcherServlet和所有的Filter 釋放執行緒，但 Response 還在子執行緒執行
        4. Callable 返回結果，Spring MVC 重新派發請求連線繼續處理
        5. Spring MVC 根據 Callable 依照返回結果繼續處理視圖流程
     */
    @ResponseBody
    @RequestMapping("/async1")
    public Callable<String> async1(){
        System.out.println("main thread start ...");
        Callable<String> callable = new Callable<String>(){
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                return "Callable<String> async1()";
            }
        };
                System.out.println("main thread end ...");
        return callable;
    }

    @RequestMapping("/create_order")
    @ResponseBody
    public DeferredResult<Object> createOrder(){
        DeferredResult<Object> deferredResult =
                new DeferredResult<>((long) 3000, "create fail");
        DeferredResultQueue.save(deferredResult);
        return deferredResult;
    }

    @ResponseBody
    @RequestMapping("/create")
    public String create(){
        String order = UUID.randomUUID().toString();
        DeferredResult<Object> deferredResult = DeferredResultQueue.get();
        deferredResult.setResult(order);
        return "success " + order;
    }

}
