package Lesson;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Semaphore mySemaphore = new Semaphore(2);
        for (int i = 0; i <5 ; i++) {
            final int w = i;
            new Thread(() -> {
                System.out.println("поток "+w+" остановился перед семафоров");
                try{
                    Thread.sleep(2000);
                    mySemaphore.acquire();
                    Thread.sleep(5000);
                    System.out.println("поток "+w+" занял семафор");
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    mySemaphore.release();
                };

            }).start();

        }
    }

    }
