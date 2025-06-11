package executors;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

class ProducerConsumerCheck {

    Queue<Integer> buffer = new LinkedList<>();
    int capacity = 10;

    private final Lock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            try {
                lock.lock();
                while (buffer.size() == capacity) {
                    System.out.println("The Buffer is already full");
                    notFull.await();
                }
                buffer.offer(value++);
                System.out.println("Produced : " + value);
                notEmpty.signal();
                Thread.sleep(400);
            } finally {
                lock.unlock();
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            try {
                lock.lock();
                while (buffer.isEmpty()) {
                    System.out.println("The buffer is empty");
                    notEmpty.await();
                }
                int value = buffer.poll();
                System.out.println("Consumed : " + value);
                notFull.signal();
                Thread.sleep(300);
            } finally {
                lock.unlock();
            }
        }
    }

}

public class CheckProducerAndConsumer {

    public static void main(String[] args) {
        ProducerConsumerCheck pcc = new ProducerConsumerCheck();

        Runnable producer = new Thread(() -> {
            try {
                pcc.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Runnable consumer = new Thread(() -> {
            try {
                pcc.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        /*producer.start();
        consumer.start();*/

        ExecutorService producerService = Executors.newFixedThreadPool(2);
        ExecutorService consumerService = Executors.newFixedThreadPool(2);

        IntStream.range(0, 2).forEach(
                x -> producerService.submit(producer)
        );

        IntStream.range(0, 2).forEach(
                x -> consumerService.submit(consumer)
        );

        producerService.shutdown();
        consumerService.shutdown();


    }
}
