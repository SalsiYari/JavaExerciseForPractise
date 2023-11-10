package start.and.stop;

import javax.lang.model.type.UnionType;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.random.RandomGenerator;

import static java.lang.Thread.sleep;

public class ThreadPoolCopy {

    public static final int MAX_TASKS = 8;

    public static void main(String[] args) throws InterruptedException{

        Thread[] threads= new Thread[MAX_TASKS];
        RandomGenerator rnd= RandomGenerator.getDefault();



        for(int i=0;i<MAX_TASKS;i++){

             threads[i] = new Thread(() ->{

                 long timeStart= System.nanoTime();
                System.out.println("START->"+ Thread.currentThread().getName()+ " ,at time="+timeStart);
                try{
                    Thread.currentThread().sleep(rnd.nextInt(1000));
                }catch(InterruptedException ignored){       }
                    System.out.println("STOP thread->"+Thread.currentThread().getName() + "executing = "+ TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - timeStart)  );
            });
        }
        for(int i=0;i<MAX_TASKS;i++){
            threads[i].start();
        }
        for(int i=0;i<MAX_TASKS;i++){
            threads[i].join();
        }
    }
}
