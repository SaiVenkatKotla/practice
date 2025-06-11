package ThreadProblems;

import java.util.Scanner;

public class AlphabetPrinter {

    private static final Object lock = new Object();
    private static int turn = 0;


    public static void main(String[] args) {
        int n = 2;
        printAlphabetsInSeries(n);
    }

    private static void printAlphabetsInSeries(int n ){
        for(int i = 0;i< n; i++) {
            final int threadId = i;
            char c = (char) ('a' + i);
            new Thread(() -> printChar(c, threadId, n)).start();
        }
    }

    private static void printChar(char c, int threadId, int n){
        for(int i = 0; i< n;){
            synchronized (lock){
                if(turn % n == threadId){
                    System.out.print(c);
                    turn++;
                    i++;
                    lock.notifyAll();
                }else{
                    try{
                        lock.wait();
                    }catch (InterruptedException e){
                        System.out.println("Thread is interrupted");
                    }
                }
            }
        }
    }
}
