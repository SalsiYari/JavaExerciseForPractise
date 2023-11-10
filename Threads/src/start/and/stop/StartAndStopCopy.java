package start.and.stop;

import java.util.concurrent.TimeUnit;

public class StartAndStopCopy extends Thread{
    public StartAndStopCopy(String name){
        super(name);
    }

    @Override
    public void run() {
        long time= System.nanoTime();
        while(!interrupted()){
            System.out.println("thread named"+getName()+"says->"+ TimeUnit.MILLISECONDS.toMillis(System.nanoTime()-time));
        }
        System.out.println("thread finished->"+getName());
    }

    public static void main(String[] args) throws InterruptedException{

        StartAndStopCopy t1 = new StartAndStopCopy("t1");
        StartAndStopCopy t2 = new StartAndStopCopy("t2");

        t1.start();
        t2.start();


        sleep(100);
            t1.interrupt();
            t2.interrupt();

        t1.join();
        t2.join();
    }

}
