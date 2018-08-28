package Thread;

import org.apache.log4j.Logger;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestThread {

    public static void main(String[] args) {
       //16次任务，每个任务完成需要2s，如何保证4完成
        try {
            //首先启一个线程池,由于搜索压力大，这里暂时取4个线程
            ExecutorService executorService = Executors.newFixedThreadPool(4);
            //创建存储任务的容器
            List<Callable<Map<String, Object>>> tasks = new ArrayList<Callable<Map<String, Object>>>();
            System.out.println("暂时的分开，主线程与她约定在某一天汇合。。。");
            for (int i =0;i<16;i++) {
                Callable<Map<String, Object>> task = new Callable<Map<String, Object>>() {
                    @Override
                    public Map<String, Object> call() throws Exception {
                        //===================================================
                     /*   Map<String, Object> result = new HashMap<String, Object>();
                        try {
                            result.put("name",Thread.currentThread().getName());
                            result.put("time",(System.currentTimeMillis()/1000));
                           System.out.println(result.get("name"));
                           Thread.sleep(2000); //没隔2秒打印一次线程名称
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return result;
                        */
                     //==============================================
                        return testTask();
                    }

                };

              // executorService.submit(task);
                // 将task添加进任务队列
                tasks.add(task);
            }

            System.out.println("主线程提前来到这里，就一直等着她。。。");
            //获取任务的返回结果（会重新执行一遍所有的任务）
            List<Future<Map<String, Object>>> results = executorService.invokeAll(tasks);
            System.out.println("主线程与她终于汇合，在一起。。。");
            executorService.shutdown();

            //获取输出结果
            for (int i = 0; i < results.size(); i++) {
                //获取包含返回结果的future对象
                Future<Map<String, Object>> future = results.get(i);
                //取出执行结果
                Map<String, Object> result = future.get();
               // System.out.println(result.get("name"));
            }
            System.out.println("end================================end");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
