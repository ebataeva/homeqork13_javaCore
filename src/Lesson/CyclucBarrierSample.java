package Lesson;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclucBarrierSample {
    public static void main(String[] args) {
        CyclicBarrier myBarrier = new CyclicBarrier(3);
        for (int i = 0; i < 5; i++) {
            final int w = i;
            new Thread(()->{

                try {
                    System.out.println("поток "+w+" начинает подготовку к чему-нибудь");
                    Thread.sleep(1000+new Random().nextInt(2000));
                    System.out.println("поток "+w+" закончил подготовку");

                    myBarrier.await();
                    System.out.println("поток "+w+" дождался остальных");

                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }
            ).start();

        }
    }
}
