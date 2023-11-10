package start.and.stop.producer.consumer;

import java.sql.Array;
import java.util.*;

/*
* Write a program implementing two threads interacting via a producer-consumer communication scheme.
* The main thread, creates both producer and consumer, waits 100 ms, and gracefully terminates them (see Thread.interrupt() method).
* More specifically, the producer pushes integer objects on a shared queue, while the consumer fetches them. The consumer, before terminating, prints the total number of integers fetched from the queue (as represented below).
* Both producer and consumer must be manually synchronized on the shared queue before using it.*/

public class ProducerConsumerSafe extends Thread {
    //here i will start the producer
   // private List<Integer> sharedList = Collections.synchronizedList(new LinkedList<>());
    Deque<Integer> sharedList;
    public ProducerConsumerSafe(String name, Deque<Integer> sharedList){
        super(name);
        this.sharedList=sharedList;
    }

    @Override
    public void run() {
        System.out.println(">HOLA-> yo soy el consumidor\n");
        int count_elements=0;
        while(!interrupted()){
            synchronized(sharedList){
                sharedList.add((int) (Math.random()*10) );
                count_elements++;
            }
        }
        System.out.println(">Buenas, me voy , ya  esà terminado ->"+count_elements);
    }

    public static void main(String[] args) throws InterruptedException{
    //here  have the main thread
        System.out.println(">Hi! MAIN thread started!!\n");
        //creation of shared collection
        // List<Integer> sharedList=Collections.synchronizedList(new LinkedList<>());
        Deque<Integer> sharedList=new LinkedList<>();
        //starting the two thread
        Thread producer= new ProducerConsumerSafe("pippo",sharedList);
        Thread consumer= new Thread(new Consumer(sharedList));

        producer.start();
        consumer.start();

        try{
            sleep(100);
        }catch(InterruptedException ignored){}

        producer.interrupt();

        try{
            sleep(1000);
        }catch(InterruptedException ignored){}

        consumer.interrupt();

        producer.join();
        consumer.join();



    }
}
