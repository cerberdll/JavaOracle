import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.CountDownLatch;

public class RaceCarRunnable extends Car implements Runnable {
    private int passed;
    private final int distance;
    private boolean isFinish;
    private final CountDownLatch latch;
    private long finishTime;

    public RaceCarRunnable(String name, int maxSpeed, int distance, CountDownLatch latch) {
        super(name, maxSpeed);
        this.distance = distance;
        this.latch = latch;
        this.passed = 0;
        this.isFinish = false;
    }

    private int getRandomSpeed() {
        int minSpeed = getMaxSpeed() / 2;
        return ThreadLocalRandom.current().nextInt(minSpeed, getMaxSpeed() + 1);
    }

    @Override
    public void run() {
        while (!isFinish) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            int speed = getRandomSpeed();
            passed += speed;
            System.out.printf("%s => speed: %d; progress: %d/%d%n", getName(), speed, passed, distance);

            if (passed >= distance) {
                isFinish = true;
                finishTime = System.currentTimeMillis() - Race.startRaceTime.get();
                System.out.printf("%s FINISHED! Time: %d ms%n", getName(), finishTime);
                latch.countDown();
            }
        }
    }

    public long getFinishTime() {
        return finishTime;
    }
}