package Lesson;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockSample {
    public static void main(String[] args) {
        Lock myLock = new ReentrantLock();
        for (int i = 0; i < 5; i++) {
            final int w = i;
            new Thread(() -> {
                System.out.println("поток "+w+ " остановился перед блокировкой");
                myLock.lock();
                try {
                    Thread.sleep(1000);
                    System.out.println("поток "+w+ " прошел блокировку");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {

                    myLock.unlock();
                }
                System.out.println("поток "+w+ " вышел из блокировки");

            }

            ).start();
        }
    }
}
