package ru.muctr.ParallelStream;

import java.util.List;

/**
 * @author Evgenia Skichko
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(List.of(1, 2, 3, 4)
                .parallelStream()
                .findAny()
                .get());

        List.of(1,2,3,4,5,6,7,8)
                .parallelStream()
                .skip(3)
                .limit(3)
                .forEach(System.out::println);
    }
}
