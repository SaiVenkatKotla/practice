package concurrentcollections;

import java.util.ArrayList;
import java.util.Iterator;

public class ConcurrentModificationExceptionDemo extends Thread{

    private static ArrayList<String> fruits  = new ArrayList<>();
    public void run(){
        try {
            Thread.sleep(2000);
            fruits.add("Cherry");
        }catch (InterruptedException e){
            System.out.println("Thread Interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("papaya");
        ConcurrentModificationExceptionDemo d = new ConcurrentModificationExceptionDemo();
        d.start();
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()){
            String s1 = (String) iterator.next();
            System.out.println("Main Thread Iterating the array list and current object is " + s1);
            Thread.sleep(3000);
        }

        fruits.forEach(System.out::println);
    }
}
