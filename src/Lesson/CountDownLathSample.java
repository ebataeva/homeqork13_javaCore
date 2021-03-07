package Lesson;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLathSample {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 3;
        CountDownLatch myLatch = new CountDownLatch(threadCount);
        for (int i = 0; i <threadCount ; i++) {
            final int w = i;
            new Thread(() -> {
                try{

                    Thread.sleep(1000+ new Random().nextInt(2000));
                    System.out.println("поток "+w+" завершил работу");
                    myLatch.countDown();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }


            }).start();

        }
        boolean result = myLatch.await(5, TimeUnit.SECONDS);
        if(result){
            System.out.println("все потоки завершены ");
        }else {
            System.out.println("не все потоки завершены ");

        }

    }
}
