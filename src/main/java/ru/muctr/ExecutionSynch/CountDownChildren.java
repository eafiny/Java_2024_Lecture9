package ru.muctr.ExecutionSynch;

import java.util.concurrent.CountDownLatch;

/**
 * @author Evgenia Skichko
 */
public class CountDownChildren {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);
        System.out.println("Собрать детей в школу");
        Thread son1 = new Thread(() ->{
            System.out.println(" 1 Вышел из дома");
            System.out.println("1  Едет на самокате");
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("1 Заходит в школу");
            latch.countDown();
            System.out.println("1 Сидит на уроках");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread son2 = new Thread(() ->{
            System.out.println("2 Вышел из дома");
            System.out.println("2 Идет");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("2 Заходит в школу");
            latch.countDown();
            System.out.println("2 Сидит на уроках");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        son1.start();
        son2.start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Проверять отчеты");
        System.out.println("Писать код");
    }
}
