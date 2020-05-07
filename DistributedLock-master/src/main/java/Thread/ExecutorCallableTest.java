package Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorCallableTest {
    public static void main(String[] args) {
        List<Integer> res = new ArrayList<Integer>();
        //创建一个线程池
        ExecutorService pools = Executors.newFixedThreadPool(4);
        List<Future<Integer>> list = new ArrayList<Future<Integer>>();
        //创建多个有返回值的任务
        for(int i = 0 ; i <= 8 ; i++){
            Future<Integer> futures = pools.submit(new Task(i));
            list.add(futures);
        }
        System.out.println("主线程提前来到这里，就一直等着她。。。");
        for(Future<Integer> f : list){
            try {
                //get方法是阻塞的，即：线程无返回结果，get方法会一直等待
                res.add(f.get());
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("result======= "+res);
        System.out.println("end================================end");
        pools.shutdown();
    }
}


class Task implements Callable<Integer>{
    private Integer taskID;
    public Task(Integer taskID) {
        this.taskID = taskID;
    }
    public Integer call() throws Exception {
            Thread.sleep(2000);
        System.out.println("任务["+taskID+"]执行完毕");
        return taskID;
    }
}

