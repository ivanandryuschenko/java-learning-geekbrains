import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static AtomicInteger finishedCount = new AtomicInteger();
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier cb;
    private CountDownLatch cdlBegin;
    private CountDownLatch cdlEnd;
    private int place;

    public int getPlace() {
        return place;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier cb, CountDownLatch cdlBegin, CountDownLatch cdlEnd) {
        this.race = race;
        this.speed = speed;
        this.cb = cb;
        this.cdlBegin = cdlBegin;
        this.cdlEnd = cdlEnd;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cdlBegin.countDown();
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        place = finishedCount.incrementAndGet();
        if (place == 1) {
            System.out.println(name + " - WIN!");
        }
        cdlEnd.countDown();
    }
}
