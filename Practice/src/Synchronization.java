import java.util.function.Function;

public class Synchronization {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++)
                counter.increment();
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++)
                counter.increment();
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Final Count " + counter.getCount());

    }
}

class Counter {
    private int counter;

    public  void increment() {
        synchronized (this) {
            counter++;
        }
    }

    public int getCount() {
        return counter;
    }
}