package Lists;

import javax.management.timer.Timer;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestApp {

    public static void main(String[] args){

        List<String> ls1=new ArrayList<String>(Arrays.asList("a","b","c","d","e","f","g")) ;
        downsize(ls1,3);
        stampa(ls1);
        //Sort Account
        Account a=new Account(12.31,12331.2, LocalDate.now());
        Account a2=new Account(132.31,1231.2, LocalDate.of(2021,1,1));
        Account a3=new Account(1332.31,121.2, LocalDate.now());
        List<Account> accounts= new ArrayList<>();
        accounts.add(a);
        accounts.add(a2);
        accounts.add(a3);
        stampa(accounts);
        sortByAmount(accounts);
        stampa(accounts);
        sortByDuePayment(accounts);
        stampa(accounts);
        sortByInterestRate(accounts);
        //timer arrayList linkedList
        List<String> al = new ArrayList<>();
        String item="no me enfada per me da coraje";
        List<String> ll=new LinkedList<>();
        long val1= insertBeginning(al,item,100000);
        long val2= insertBeginning(ll,item,100000);
        System.out.println("arrayList insert begginning ->"+ Long.toString(val1));
        System.out.println("linkedList insert begginning ->"+ val2);
        val1= insertEnd(al,item,100000);
        val2= insertEnd(ll,item,100000);
        System.out.println("arrayList insert end ->"+ Long.toString(val1));
        System.out.println("linkedList insert end ->"+ val2);
    }


    //just for printing the lists
    public static void stampa(List<?> list){
        System.out.println("-----------");
        for(Object elemento:list){
            System.out.println(elemento);
        }
    }


    /*
        * Write a method that removes every nth String from a List<String>.

        downSize(["A", "B", "C", "D", "E", "F"], 2) -> ["A", "C", "E"]
        downSize(["A", "B", "C", "D", "E", "F"], 3) -> ["A", "B", "D", "E"]
        The method has the following prototype:

        public static void downsize(List<String> list, int n);
        where:

        list is the list to be downsized
        n represents the intensity of the downsizing
*/
    public static void downsize(List<String> list, int n){
        int i=1;
        for(Iterator<String> k = list.iterator();k.hasNext();){
            k.next();
            if(i++ %n == 0){
                k.remove();
            }
        }
    }
    /*Given the following class Account:

    public static class Account {
        double amount;
        double interestRate;
        LocalDate duePayment;
        ...
    };
    Write three methods accepting a List<Account> and returning void. Each method sorts the list based on one criterion (i.e., one attribute).

    The methods have the following prototype:

    public static void sortByAmount(List<Account> accounts);
    public static void sortByInterestRate(List<Account> accounts);
    public static void sortByDuePayment(List<Account> accounts);
    where:

    accounts is the list of Account to be sorted.*/

    public static void sortByAmount(List<Account> accounts){
        accounts.sort((a1,a2) -> Double.compare(a1.getAmount(),a2.getAmount()));
    }
    public static void sortByInterestRate(List<Account> accounts){
        accounts.sort(new AccountComparator() );
    }
    public static void sortByDuePayment(List<Account> accounts){
        accounts.sort((a1,a2) -> a1.getDuePaymant().compareTo(a2.getDuePaymant()));
    }
    /* Demonstrate that the position is which elements are added to a List impacts performance in a significant way. Write two methods for inserting an element at the beginning (or end) of a List a certain number of times, returning the elapsed time. Then, write a test for showing that ArrayList is faster than LinkedList when adding elements at the end, while the opposite is true when inserting elements at the beginning (see System.nanoTime()).

    The methods have the following prototype:

    public static long insertBeginning(List<String> list, String item, int times);
    public static long insertEnd(List<String> list, String item, int times);
    where:

    list is the list used for adding elements.
    item is the item to be added.
    times is the number of times to repeat the add operation.*/
    public static long insertBeginning(List<String> list,String item, int times){
        //long startTime = System.currentTimeMillis();
        long begin= System.nanoTime();
        while(times >= 0){
            list.add(0,item);
            times--;
        }
        // long endTime=System.currentTimeMillis();
        long end=System.nanoTime();
        return begin-end;
    }
    static  long insertEnd(List<String> list,String item,int times){
        long start=System.nanoTime();
        for(int i=0;i<times;i++){
            list.add(list.size(),item);
        }
        long end=System.nanoTime();
        return end-start;
    }

}
