import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 * <p>
 * 一个简单的代码参考：
 */
public class Homework03_BlockingQueue {
    
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        // 异步执行 下面方法
        Homework03_BlockingQueue homework03 = new Homework03_BlockingQueue();
        Thread t = new Thread(() -> {
            try {
                queue.put(homework03.sum());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + queue.take());

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    private int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }
}
