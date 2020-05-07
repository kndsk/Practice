package Thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * ExecutorService和ThreadPoolExecutor的使用
 */
public class TestThread {

    public static void main(String[] args) {
        //ExecutorService测试方法
        //创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);//指定个数

        for (int i = 0; i < 5; i++) {
            Thread t = new MyThread();
            pool.execute(t);
        }
        pool.shutdown();//关闭线程池




        //ThreadPoolExecutor测试方法
//        System.out.println("ThreadPoolExecutor线程池");
//        ThreadPoolExecutor tpe = new ThreadPoolExecutor(5, 10, 10, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(10));
//        for (int i = 0; i < 5; i++) {
//            Thread t1 = new MyThread();
//            tpe.execute(t1);
//        }
//        tpe.shutdown();//关闭线程池

    }






    public static Map<String,Object> testTask(){
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            result.put("name",Thread.currentThread().getName());
            result.put("time",(System.currentTimeMillis()/1000));
            System.out.println(result.get("name"));
            Thread.sleep(2000); //模拟打印一次日志需要1秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }


}
