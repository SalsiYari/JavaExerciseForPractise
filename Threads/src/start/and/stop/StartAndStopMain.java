package start.and.stop;

import java.util.concurrent.TimeUnit;

public class StartAndStopMain extends Thread{

    public StartAndStopMain( String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println("->thread :"+ getName() +" is started !");
        long startTime = System.nanoTime();

        while( ! interrupted() ){
            System.out.println(getName() +"milliseconds -> "+ TimeUnit.MILLISECONDS.toMillis(System.nanoTime() - startTime));
        }

        System.out.println("thread "+getName()+ "terminated \n");
    }


    public static void main(String[] args) throws InterruptedException{

        StartAndStopMain t1= new StartAndStopMain("T1");
        StartAndStopMain t2= new StartAndStopMain("T2");


        t1.start();
        t2.start();

        Thread.sleep(100L);

        t1.interrupt();
        t2.interrupt();

        t1.join();
        t2.join();




    }


}
