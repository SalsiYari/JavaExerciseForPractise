package start.and.stop.producer.consumer;

import java.util.*;

public class Consumer implements Runnable{

    // List<Integer> sharedList= Collections.synchronizedList(new LinkedList<>());
    Deque<Integer> sharedList;
    public Consumer(Deque<Integer> sharedList){
        //super(name); doesn'nt work
        this.sharedList=sharedList;
    }
    @Override
    public void run() {
        System.out.println(">Hi! consumer started\n");
        int count_elements=0;

        while(!Thread.interrupted()){
            synchronized (sharedList){
                try{

                    System.out.println("-->pop ="+ sharedList.getFirst() );
                    count_elements++;

                }catch (Exception ignored){
                    Thread.yield();
                }

            }
        }
        System.out.println(">Bye consumer thread ended (find"+count_elements+" elements) ");
    }
}
