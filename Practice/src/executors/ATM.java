package executors;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ATM {

    private final ReentrantLock lock = new ReentrantLock();

    public void useATM(String name) {
        System.out.println(name + "is trying to access the ATM");
        lock.lock();

        try {
            System.out.println(name + " has accessed the ATM");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted ");
        } finally {
            System.out.println(name + " is done using the ATM");
            lock.unlock();
        }
    }

    public void tryUseATMWithTimeout(String name) {
        System.out.println(name + " is trying to access the ATM");

        try {
            if (lock.tryLock(2, TimeUnit.SECONDS)) {
                try {
                    System.out.println(name + " has accessed the ATM");
                    Thread.sleep(3000);
                } finally {
                    System.out.println(name + " is done using the ATM");
                    lock.unlock();
                }
            } else {
                System.out.println(name + " could not access the ATM (timeout)");
            }
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted");
        }
    }

    public void useATMInterruptibly(String name) {
        System.out.println(name + " is trying to access the ATM interruptibly...");

        try {
            lock.lockInterruptibly();
            try {
                System.out.println(name + " has accessed the ATM interruptibly.");
                Thread.sleep(3000);
            } finally {
                System.out.println(name + " is done using the ATM.");
                lock.unlock();
            }
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted while waiting (interruptibly).");
        }
    }

    public void checkLockStatus(String name) {
        System.out.println("Is ATM locked? " + lock.isLocked());
        System.out.println("Is it locked by " + name + "? " + lock.isHeldByCurrentThread());
    }

    public static void main(String[] args) throws InterruptedException {
        ATM atm = new ATM();

        Thread t1 = new Thread(() -> atm.useATM("Customer1"));
        Thread t2 = new Thread(() -> atm.tryUseATMWithTimeout("Customer2"));
        Thread t3 = new Thread(() -> atm.useATMInterruptibly("Customer3"));

        t1.start();
        Thread.sleep(100); // Make sure t1 gets the lock first
        t2.start();
        Thread.sleep(100);
        t3.start();

        // Interrupt t3 after a second to demonstrate interruptibility
        Thread.sleep(1000);
        t3.interrupt();

        t1.join();
        t2.join();
        t3.join();

        atm.checkLockStatus("MainThread");
    }

}
