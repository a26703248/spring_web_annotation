package spring_async.queue;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * ProjectName: spring_mvc_annotation
 * Package: spring_async.entity
 * Description:
 *
 * @author a0909
 * @version v1.0
 * @create 2023/4/3 - 下午 01:10
 * @since JDK 1.8
 */
public class DeferredResultQueue {

    private static Queue<DeferredResult<Object>> queue =
            new ConcurrentLinkedQueue<>();
    public static void save(DeferredResult<Object> deferredResult){
        queue.add(deferredResult);
    }

    public static DeferredResult<Object> get(){
        return queue.poll();
    }

}
