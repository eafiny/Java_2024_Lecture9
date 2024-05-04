package ru.muctr.ExecutionSynch;

/**
 * @author Evgenia Skichko
 */
public class JoinDemo {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println("Working...");
        });
        t.start();
        Thread t2 = new Thread(()->{
            System.out.println("Working...");
        });
        t2.start();
        Thread t3 = new Thread(()->{
            System.out.println("Working...");
        });
        t3.start();


        try {
            t.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("After all threads main thread continues working");
    }
}
