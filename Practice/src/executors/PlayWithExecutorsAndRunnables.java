package executors;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class PlayWithExecutorsAndRunnables {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable task = () -> System.out.println("I'm in a runnable thread" + Thread.currentThread().getName());
        ExecutorService service = Executors.newFixedThreadPool(4);
        ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
        IntStream.range(0, 10).forEach(p -> service.submit(task));

        Callable<String> callableTask = () -> {
            return "I'm in Callable Thread " + Thread.currentThread().getName();
        };
        service.shutdown();

        ExecutorService callableService = Executors.newFixedThreadPool(4);
        IntStream.range(0,10).forEach(p-> {
            try {
                System.out.println(callableService.submit(callableTask).get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        callableService.shutdown();

    }

}
