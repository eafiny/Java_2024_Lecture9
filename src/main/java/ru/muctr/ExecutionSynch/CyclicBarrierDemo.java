package ru.muctr.ExecutionSynch;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        for (int i = 0; i < 3; i++){
            final int j = i;
            new Thread(()->{
                try{
                    System.out.println(j + "begin");
                    Thread.sleep(2000 * j);
                    System.out.println(j + " ready " + System.nanoTime());
                    cyclicBarrier.await();
                    System.out.println(j + " start " + System.nanoTime());
                    Thread.sleep(j * 4000);
                    System.out.println(j + " end");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
