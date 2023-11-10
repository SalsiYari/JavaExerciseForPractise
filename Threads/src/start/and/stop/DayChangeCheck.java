package start.and.stop;
/*Write a program in which the main thread starts a child thread which,
 every 15 minutes, checks if the day of the month has changed and eventually
 prints a message (see Thread.sleep(), java.time.LocalDate). The main thread do not wait,
 but terminates immediately after starting the child thread
 (bad practice! the main thread should always wait for its children).*/

import java.io.IOException;
import java.sql.Time;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class DayChangeCheck extends Thread{

    public DayChangeCheck(String name){
        super(name);
    }

    @Override
    public void run() {
        LocalDate ora = LocalDate.now();

        while (!interrupted()) {
            try{
                sleep(Duration.ofMinutes(15).toMillis());
                Thread.sleep(TimeUnit.MINUTES.toMillis(15));

            }catch (InterruptedException ignored) {
            }
            if (ora.getDayOfMonth() != LocalDate.now().getDayOfMonth() ) {
                ora=LocalDate.now();
                System.out.println(getName()+ " the day is changed");
            }
        }
        System.out.println("thread ->"+getName()+interrupted());
    }

    public static void main(String[] args) throws InterruptedException{
        DayChangeCheck d= new DayChangeCheck("thread_1");
        d.start();
    }
}
