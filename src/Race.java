import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

public class Race {
    public static final AtomicLong startRaceTime = new AtomicLong();

    public static void main(String[] args) throws InterruptedException {
        List<RaceCarRunnable> cars = List.of(
                new RaceCarRunnable("Car 1", 150, 1000, new CountDownLatch(1)),
                new RaceCarRunnable("Car 2", 180, 1000, new CountDownLatch(1)),
                new RaceCarRunnable("Car 3", 200, 1000, new CountDownLatch(1))
        );

        List<Thread> threads = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(cars.size());

        for (RaceCarRunnable car : cars) {
            threads.add(new Thread(car));
        }

        startRace(threads);

        latch.await();

        RaceCarRunnable winner = cars.stream()
                .min((c1, c2) -> Long.compare(c1.getFinishTime(), c2.getFinishTime()))
                .orElseThrow();

        System.out.printf("The winner is %s with a time of %s ms%n", winner.getName(), winner.getFinishTime());
    }

    public static void startRace(List<Thread> cars) {
        new Thread(() -> {
            try {
                for (int i = 3; i > 0; i--) {
                    System.out.println(i + "...");
                    Thread.sleep(500);
                }
                System.out.println("GO!!!");
                startRaceTime.set(System.currentTimeMillis());
                cars.forEach(Thread::start);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}