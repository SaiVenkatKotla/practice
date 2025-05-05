package executors;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ProducerConsumer {
    private Queue<Integer> buffer = new LinkedList<>();
    private int capacity = 10;

    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            lock.lock();
            try {
                while (buffer.size() == capacity) {
                    System.out.println("Buffer is full. Producer waiting...");
                    notFull.await();
                }
                System.out.println("Producing: " + value);
                buffer.offer(value++);
                notEmpty.signal(); // Signal that buffer is not empty
                Thread.sleep(1000); // Simulating production time
            } finally {
                lock.unlock();
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (buffer.isEmpty()) {
                    System.out.println("Buffer is empty. Consumer waiting...");
                    notEmpty.await();
                }
                int value = buffer.poll();
                System.out.println("Consuming: " + value);
                notFull.signal(); // Signal that buffer is not full
                Thread.sleep(1000); // Simulating consumption time
            } finally {
                lock.unlock();
            }
        }
    }
}

public class ProducerConsumerWithLocks {
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();

        Thread producerThread = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        consumerThread.start();
        producerThread.start();
    }
}
