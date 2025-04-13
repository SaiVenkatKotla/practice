package executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AtomicCounter {

    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {

        class Incremental implements Runnable {

            @Override
            public void run() {
                counter.incrementAndGet();
            }
        }

        class Decremental implements Runnable {
            @Override
            public void run() {
                counter.decrementAndGet();
            }
        }
        ExecutorService service = Executors.newFixedThreadPool(4);
        List<Future<?>> futures = new ArrayList<>();

        try {


            IntStream.range(0, 4).forEach(x -> service.submit(new Incremental()));
            IntStream.range(0, 4).forEach(x -> service.submit(new Decremental()));

            futures.forEach(
                    future -> {
                        try {
                            future.get();
                        } catch (ExecutionException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );

            System.out.println("Counter = " + counter);
        } finally {
            service.shutdown();
        }
    }
}
