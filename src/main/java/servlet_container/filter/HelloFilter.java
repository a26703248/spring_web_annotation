package servlet_container.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * ProjectName: spring_mvc_annotation
 * Package: servlet_container.filter
 * Description:
 *
 * @author a0909
 * @version v1.0
 * @create 2023/4/3 - 上午 11:01
 * @since JDK 1.8
 */
public class HelloFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("HelloFilter ... doFilter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
