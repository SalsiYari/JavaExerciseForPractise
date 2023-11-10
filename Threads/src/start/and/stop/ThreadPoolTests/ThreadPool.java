package start.and.stop.ThreadPoolTests;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.random.RandomGenerator;

import static java.lang.Thread.sleep;

public class ThreadPool implements Runnable {
    public static final int DIM_TASKS=4;



    public static void main(String[] args) throws InterruptedException{

        Thread[] vector=new Thread[DIM_TASKS];
        for(int i=0;i<DIM_TASKS; i++){
            vector[i]=new Thread(new ThreadPool());
            vector[i].start();
        }
        for(int i=0; i< DIM_TASKS; i++) {
            vector[i].join();
        }


    }

    @Override
    public void run() {

        long startTime=System.nanoTime();
        RandomGenerator rng= RandomGenerator.getDefault();

        System.out.println("START thread-"+ Thread.currentThread().getName() );
        try {
            sleep(rng.nextInt(1000));
        } catch (InterruptedException ignored) {
        }
        long stopTime=System.nanoTime();
        System.out.println("STOP thread-"+ Thread.currentThread().getName() +"-executed: "+ TimeUnit.NANOSECONDS.toMillis(stopTime-startTime));

    }
}
