package concurrentcollections;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class PlayWithConcurrentCollection extends Thread {

    static ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) throws InterruptedException {
        concurrentLinkedQueue.add("Venkat");
        concurrentLinkedQueue.add("Sandeep");
        concurrentLinkedQueue.add("Krishna");
        concurrentLinkedQueue.add("Vinutha");
        PlayWithConcurrentCollection thread = new PlayWithConcurrentCollection();
        thread.start();
        for (String s : concurrentLinkedQueue){
            System.out.println(s);
            Thread.sleep(1000);
        }

    }

    public void run() {
        try {
            concurrentLinkedQueue.add("Blue");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Thread Interrupted");
        }
    }

}
