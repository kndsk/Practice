package Thread;

/**
 * @title: MyThread
 * @description: TODO
 * @author Administrator
 * @date 2020/5/7 000714:38
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "(自定义)正在执行。。。");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+"== 执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
