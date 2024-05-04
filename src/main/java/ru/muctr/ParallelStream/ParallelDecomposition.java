package ru.muctr.ParallelStream;

import java.util.List;

/**
 * @author Evgenia Skichko
 */
public class ParallelDecomposition {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<Integer> list = List.of(1,2,3,4,5);
        System.out.println(Runtime.getRuntime().availableProcessors());

        //Последовательный стрим
//        System.out.println("Последовательный стрим");
//        list.stream()
//                .map(x -> doWork(x))
//                .forEach(System.out::println);
//
//        System.out.println(System.currentTimeMillis() - startTime);

        //Параллельный стрим
        System.out.println("Параллельный стрим");
        startTime = System.currentTimeMillis();
        list.parallelStream()
                .map(x -> doWork(x))
                .forEach(System.out::println);
        System.out.println(System.currentTimeMillis() - startTime);
    }

    private static Integer doWork(Integer x) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return x;
    }
}
