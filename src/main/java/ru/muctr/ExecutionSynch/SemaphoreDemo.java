package ru.muctr.ExecutionSynch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++){
            final int j = i;
            service.execute(()->{
                try{
                    System.out.println(j + "ready");
                    semaphore.acquire();
                    System.out.println(j + "START");
                    Thread.sleep(4000);
                    System.out.println(j + "end");

                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            });
        }
        service.shutdown();
    }
}
