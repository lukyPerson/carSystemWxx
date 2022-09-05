import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

public class ThreadTest {
    private volatile static int count = 0;
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(2);

        String lock = "11";
        System.out.println("=========");
        // 启动线程A
        Thread threadA = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                ThreadTest test = new ThreadTest();
                String l = new String("3");
                test.print(l,"a");
                countDownLatch.countDown();
            }
        });
        // 启动线程B
        Thread threadB = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                ThreadTest test = new ThreadTest();
                String l = new String("3");
                test.print(l,"b");
                countDownLatch.countDown();
            }
        });
        threadA.start();
        threadB.start();

        // main线程等待线程A和B计算完毕
        countDownLatch.await();
    }
    public void print(String a,String b) throws InterruptedException {
        synchronized (a.intern()){
            System.out.printf("这个方法被调用了：%s,调用者：%s\n",a,b);
            Thread.sleep(2000);
        }

    }
}
