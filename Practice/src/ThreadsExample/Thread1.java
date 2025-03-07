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
    }
}
