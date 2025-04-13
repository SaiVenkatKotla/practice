package executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ConcurrencyWithProducerConsumer {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(50);

        class Consumer implements Callable<String> {

            @Override
            public String call() throws Exception {
                int count = 0;
                while (count++ < 50) {
                    queue.take();
                }
                return "Consumed:" + (count - 1);
            }
        }

        class Producer implements Callable<String> {

            @Override
            public String call() throws Exception {
                int count = 0;
                while (count++ < 50) {
                    queue.put(Integer.toString(count));
                }
                return "Produced:" + (count - 1);
            }
        }

        List<Callable<String>> producerAndConsumer = new ArrayList<>();

        IntStream.range(0, 2).forEach(x -> producerAndConsumer.add(new Producer()));
        IntStream.range(0, 2).forEach(x -> producerAndConsumer.add(new Consumer()));
        System.out.println("Producer and Consumer Launched");
        ExecutorService executorService = Executors.newFixedThreadPool(4);


        try {
            List<Future<String>> futures = executorService.invokeAll(producerAndConsumer);
            futures.forEach(
                    future -> {
                        try {
                            System.out.println(future.get());
                        } catch (ExecutionException | InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                    }
            );
        } finally {
            executorService.shutdown();
        }


    }
}
