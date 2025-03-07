package ThreadsExample;

import java.util.Scanner;

public class Den {
    final Object lock;
    Scanner sc;

    public Den() {
        this.lock = new Object();
        sc = new Scanner(System.in);
    }

    public synchronized void enter() {
        try {
            Thread.sleep(10000);
            System.out.println("Enter something");
            System.out.println(sc.next());
        } catch (Exception e) {
            System.out.println();
        }
    }

    public synchronized void exit() {
        try {
            Thread.sleep(10000);
            System.out.println("Exit something");
            System.out.println(sc.next());
        } catch (Exception e) {
            System.out.println();
        }
    }
}
