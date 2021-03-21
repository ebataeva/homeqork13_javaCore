import java.util.concurrent.*;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private CountDownLatch countDownToStart;
    private CountDownLatch countDownToFinish;


    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed,  CountDownLatch countDownToStart, CountDownLatch countDownToFinish) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.countDownToStart = countDownToStart;
        this.countDownToFinish = countDownToFinish;
    }

    public void getReadyToStart() {
        System.out.println(name + " готовится");
    }


    public void getReady() {
        System.out.println(name + " готов ");
    }


    @Override
    public void run() {
            try {
                System.out.println(this.name + " готовится");
                Thread.sleep(500 + (int)(Math.random() * 800));
                System.out.println(this.name + " готов");
                countDownToStart.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        try {
            countDownToStart.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
        countDownToFinish.countDown();
        }
    }


