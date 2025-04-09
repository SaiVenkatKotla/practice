package ThreadsExample;

public class Thread1 {
    public static void main(String[] args) {
        Den d = new Den();

        Thread t1 = new Thread(() -> {
            d.enter();
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            d.exit();
        });
        t2.start();


        Thread t3 = new Thread(() -> {
            System.out.println("This is a thread");
        });
        t3.start();
        /*try {
            t3.join(); // Wait for t3 to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }
}
