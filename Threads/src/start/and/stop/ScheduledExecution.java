package start.and.stop;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class ScheduledExecution extends Thread{

    @Override
    public void run() {
        System.out.println("START thread ->"+getName());

        while(!isInterrupted()){
            try {
                sleep(TimeUnit.SECONDS.toMillis(1));
            } catch (InterruptedException ignored) {
                break;
            }
            System.out.println(LocalDateTime.now().toString() +": Hello!");
        }
    }

    public static void main(String[] args) throws InterruptedException{

        ScheduledExecution ThreadTermiantor=new ScheduledExecution();

        ThreadTermiantor.start();
        try {
            sleep(TimeUnit.SECONDS.toMillis(8));
        } catch (InterruptedException ignored) {
        }
        ThreadTermiantor.interrupt();

        //ThreadTermiantor.join();
    }
}
