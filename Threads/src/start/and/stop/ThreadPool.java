package start.and.stop;

import java.util.concurrent.TimeUnit;

public class ThreadPool extends Thread{
    @Override
    public void run() {

        System.out.println("START->"+getName());

        try{
            Thread.sleep(TimeUnit.SECONDS.toMillis( Long.parseLong(String.valueOf(Math.random())) ));
        }catch (InterruptedException ignored){
           //ignored
        }
        System.out.println("STOP->"+getName());
    }

    public static void main(String[] args) throws InterruptedException{

        Thread[] tp=new Thread[8];

        for(int i=0;i<7;i++){
            tp[i]= new ThreadPool();
            tp[i].setName("thread_"+i);
            tp[i].start();
        }
        System.out.println("\n");
        tp[0].join();
        tp[1].join();
        tp[2].join();
        tp[3].join();
        tp[4].join();
        tp[5].join();
        tp[6].join();
        tp[7].join();

    }

}
