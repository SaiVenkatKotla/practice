package ThreadProblems;

import java.util.Scanner;

public class SyncNumberPrinting {

    private static final Object lock = new Object();
    private static int number = 0;

    public static void main(String[] args) {
        int n = 1;
        while (n == 1) {
            Scanner sc = new Scanner(System.in);
            int k = sc.nextInt();
            printNumbersInSequence(k);
            System.out.println("Press 1 to continue");
            n = sc.nextInt();
        }
    }

    private static void printNumbersInSequence(int k) {
        number = 0;
        for (int i = 0; i < 2; i++) {
            int finalI = i;
            new Thread(() -> printYourNumber(k, finalI)).start();
        }
    }

    private static void printYourNumber(int k, int even) {
        while (number < k) {
            synchronized (lock) {
                if(number % 2 == even) {
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;
                    lock.notifyAll();
                }else {
                    try {
                        lock.wait();
                    }catch (InterruptedException e){
                        System.out.println("Thread Interrupted"+Thread.currentThread().getName());
                    }
                }
            }
        }
        Thread.currentThread().interrupt();
    }
}
