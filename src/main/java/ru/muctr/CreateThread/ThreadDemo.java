package ru.muctr.CreateThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Evgenia Skichko
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        System.out.println(Runtime.getRuntime().availableProcessors());

        //Runnable Task
//        RunnableTask task = new RunnableTask();
//        Thread thread1 = new Thread(task);

//        Thread thread2 = new Thread(()->{
//            System.out.println(Thread.currentThread().getName());
//        });
//        thread2.start();
//
//        try {
//            thread2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Метод main working");

        //Callable Task
        CallableTask task = new CallableTask();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> result = executor.submit(new CallableTask());
        try {
            System.out.println(result.get());
            System.out.println("Результат получен");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
