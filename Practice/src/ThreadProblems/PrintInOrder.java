package ThreadProblems;

import java.util.concurrent.CountDownLatch;

public class PrintInOrder {

    public static void main(String[] args) {
        Foo foo = new Foo();
        Thread t1 = new Thread( () -> {
            try{
                foo.first(() -> System.out.println("first"));
            }catch (InterruptedException e){
                System.out.println("Thread Interrupted");
            }
        });

        Thread t2 = new Thread( () -> {
            try{
                foo.second(()-> System.out.println("Second"));
            }catch (InterruptedException e){
                System.out.println("Thread Interrupted");
            }
        });

        Thread t3 = new Thread( () -> {
            try{
                foo.third(() -> System.out.println("Third"));
            }catch (InterruptedException e){
                System.out.println("Thread Interrupted");
            }
        });

        t1.start();
        t3.start();
        t2.start();
    }
}

class Foo{
    private final CountDownLatch firstDone = new CountDownLatch(1);
    private final CountDownLatch secondDone = new CountDownLatch(1);

    public Foo(){

    }

    public void first(Runnable printFirst) throws InterruptedException{
        printFirst.run();
        firstDone.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException{
        firstDone.await();
        printSecond.run();
        secondDone.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException{
        firstDone.await();
        secondDone.await();
        printThird.run();
    }

}