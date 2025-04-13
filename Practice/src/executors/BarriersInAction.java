package executors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class BarriersInAction {

    public static void main(String[] args) {

        class Friends implements Callable<String> {

            private CyclicBarrier barrier;

            public Friends(CyclicBarrier barrier) {
                this.barrier = barrier;
            }

            @Override
            public String call() throws Exception {
                Random random = new Random();
                Thread.sleep((random.nextInt(20) * 100 + 100));
                System.out.println("I've just arrived, waiting for others...");
                barrier.await();
                System.out.println("Let's go to Cinema");
                return "Ok";
            }
        }

        ExecutorService service = Executors.newFixedThreadPool(4);

        CyclicBarrier barrier = new CyclicBarrier(4);
        List<Future<String>> futures = new ArrayList<>();

        try {
            for (int i = 0; i < 4; i++) {
                Friends friends = new Friends(barrier);
                futures.add(service.submit(friends));
            }

            futures.forEach(
                    x -> {
                        try {
                            x.get();
                        } catch (InterruptedException | ExecutionException e) {
                            System.out.println(e.getMessage());
                        }
                    });
        } finally {
            service.shutdown();
        }


    }
}
