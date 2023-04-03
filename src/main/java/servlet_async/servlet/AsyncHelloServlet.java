package servlet_async.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ProjectName: spring_mvc_annotation
 * Package: spring_container.controller
 * Description:
 *
 * @author a0909
 * @version v1.0
 * @create 2023/4/3 - 下午 12:14
 * @since JDK 1.8
 */
@WebServlet(value = "/async_hello", asyncSupported = true) // 支持異步
public class AsyncHelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AsyncContext asyncContext = req.startAsync();
        System.out.println(Thread.currentThread().getName() + "main start ...");
        asyncContext.start(() -> {
            System.out.println(Thread.currentThread().getName() + "sub start ...");
            sayHello();
            asyncContext.complete();
            ServletResponse response = asyncContext.getResponse();
            try {
                response.getWriter().write("OK");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "sub end ...");
        });
        System.out.println(Thread.currentThread().getName() + "main end ...");
    }

    private void sayHello() {
        System.out.println(Thread.currentThread().getName() + "start ...");
        try {
            System.out.println(Thread.currentThread().getName() + "handle ...");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "end ...");
    }
}
