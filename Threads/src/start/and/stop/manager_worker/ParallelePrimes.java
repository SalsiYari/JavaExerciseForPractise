package start.and.stop.manager_worker;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*write a program searching prime numbers on a fixed number of parallel threads
(see java.util.concurrent.ExecutorService). Each thread, receiving a range to be searched
 e.g. [0, 1000], [1000, 2000]..., returns a List containing the prime numbers found.
 The main thread starts the parallel child threads using ExecutorService.invokeAll() and receives a
List<Future<List<Integer>>> for fetching the results (see java.util.concurrent.Future<V>).*/
public class ParallelePrimes {
    public static final int FIXED_THREAD= 4;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor= Executors.newFixedThreadPool(FIXED_THREAD);
        List<Callable<List<Integer>>> collectionOfCallable = new LinkedList<>();
        collectionOfCallable.add(new PrimeEngine(0,100));
        collectionOfCallable.add(new PrimeEngine(100,200));
        collectionOfCallable.add(new PrimeEngine(200,500));
        collectionOfCallable.add(new PrimeEngine(500,1000));
        collectionOfCallable.add(new PrimeEngine(1000,10000));


        List<Future<List<Integer>>> ret = executor.invokeAll(collectionOfCallable);

        Thread.sleep(1000);

        for(Future<List<Integer>> i: ret){
            System.out.println(i.get());
        }

        executor.shutdown();
    }
}
