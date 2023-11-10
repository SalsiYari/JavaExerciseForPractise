package start.and.stop;

import java.lang.reflect.Executable;
import java.time.LocalTime;
import java.util.concurrent.*;

public class ScheduledExecutionWithExecutor {

    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(()->
                System.out.println(LocalTime.now()+": Hello!"),0,1000,TimeUnit.MILLISECONDS);

    }


}
