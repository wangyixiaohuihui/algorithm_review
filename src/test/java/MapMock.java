import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author by wangyi
 * @classname MapMock
 * @description 多线程下 HashMap 同步处理
 * @date 2021/5/21 13:32
 */
public class MapMock {

    public static Map<String, List<String>> m = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        ThreadFactory threadFactory = new BasicThreadFactory.Builder().namingPattern("map-").build();
        ExecutorService executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                Runtime.getRuntime().availableProcessors() *2
                ,60L
        , TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100)
                ,threadFactory, new ThreadPoolExecutor.AbortPolicy());

        for (int i=0; i<100; i++) {
            executorService.submit(new MapInsert());
        }

        System.out.println(m.toString());
    }


}
class MapInsert implements Runnable {

    @Override
    public void run() {
        MapMock.m.computeIfAbsent("a", k -> new ArrayList<String>()).add(Thread.currentThread()+"22");
        System.out.println(MapMock.m.toString());
    }
}