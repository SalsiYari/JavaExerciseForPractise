import java.util.*;

public class Main {
    public static void main(String[] args) {

        /*Write a generic static method returning a string representing all the elements of an object implementing the Iterable interface.
        The elements should be separated by commas.
        Examples:

        iterableToString([1, 2, 3]) → "1, 2, 3, "
        iterableToString(["a", "b", "c"]) → "a, b, c, "
        The method has the following prototype:

        public static <E> String iterableToString(Iterable<E> src);
        where:*/
        Set<String> s1=new HashSet<>();
        s1.add("ciao");
        s1.add("miao");
        s1.add("finish");
        List<Integer> l1=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        System.out.println("here the result of \n->"+iterableToString(s1)+"\n->"+iterableToString(l1));

        /*Write a generic static method returning the floating point division of any two numbers regardless of their specific type e.g. int, double, etc..
        (see java.lang.Number class).
        Examples:

        divide(4, 2) → 2.0
        divide(4.0, 2) → 2.0
        divide(4, 2.0) → 2.0
        The method has the following prototype:

        public static <T extends Number> double divide(T a, T b);
        */
        System.out.println("the value is->"+divide(1212,212.1));
        /*
        * Write a generic static method that appends the elements of one list to another list of the same type.

        Examples:

        append([], [1, 2]) → [1, 2]
        append([1, 2], [3, 4]) → [1, 2, 3, 4]
        append(["a", "c"], ["c", "d"]) → ["a", "c", "c", "d"]
        The method has the following prototype:*/
        List<String> l2=new ArrayList<>(Arrays.asList("ciao","questa ","è","una stringa"));
        List<String> l3=new ArrayList<>(Arrays.asList("hi","this ","is","one string"));
        append(l2,l3);
        System.out.println("->"+l2);
        /*Modify the exercise Append.java so that src can contain elements of a subclass. For example,
        if people is a list of Person objects and students is a list of Student objects,
        then append(people, students) should compile but append(students, people) should not.
        The prototype is not reported because it is the answer.*/

        //append 2 not tested here!

        /*
        [CountOccurrences] Write a generic static method counting all occurrences of a specific item of type T within a T[].
        It the passed item is null, the method should return the number of null values within the array.

        Examples:

        countOccurrences([1, 2, 2, 2], 2) → 3
        countOccurrences([null, null, 3, 4], null) → 2
        countOccurrences(["hello", "world", null, null], "hello") → 1
        The method has the following prototype:

        public static <T> int countOccurrences(T[] src, T item);
        where:

        src is the array to be searched within.
        item is the item to be searched.*/

        String[] s=new String[3];
        s[0]="ciao";
        s[1]="miao";
        s[2]="ciao";
        String[] s_1= {"ciao","null",null,"ciao","null",null,"ciao"};
        Integer[] vettore={1,2,null,null,null,1,2,2,1,8};
        System.out.println("number of occ  is-> "+countOccurrences(vettore,null));
        System.out.println("number of occ  is-> "+countOccurrences(s_1,null));

        /*
        * Define a generic class Pair<K,V> representing a generic pair of objects with different types.
        * The class must have two internal attributes named first and second of type K and V, respectively.
        * Constructor, getters, and setters are also required.*/

        Pair<Integer,String> pair1=new Pair<>(3,"ciao");

        /*
        * Modify the Pair class (see Pair.java) so that both values have the same type.
        * Furthermore, add a method void swap() that swaps the first and second elements of the pair.*/

        PairEqual<Boolean> pe=new PairEqual<>(true,false);
        System.out.println("classe ha i seguenti valori->"+pe.getFirst()+"---"+pe.getSecond()   );
        pe.swap();
        System.out.println("classe ha i seguenti valori->"+pe.getFirst()+"---"+pe.getSecond());

        /*Write a generic static method whose argument is a Pair object.
        The method returns a new pair, with the first and second element swapped.
        The method has the following prototype:*/

        System.out.println("- . -. -. -. -. ");
        System.out.println("classe ha i seguenti valori->"+pair1.getFirst()+"---"+pair1.getSecond()   );
        Pair<String ,Integer> pair2=swap(pair1);
        System.out.println("classe ha i seguenti valori->"+pair2.getFirst()+"---"+pair2.getSecond()   );

        /*Write a generic static method that, given a Map<K, V>,
        returns a List<Pair<K, V>> of the key/value pairs in the map (see Map.entrySet()).
        */

        Map<String,Integer> mappa=new LinkedHashMap<>();
        mappa.put("ciao",2);
        mappa.put("rome",1);
        mappa.put("bao",4);
        mappa.put("trestevere",2);
        mappa.put("paris",5);
        List <Pair<String,Integer>> listaP= mapToPairs(mappa);

        /*
        * Transform the Measurer interface (reported below) into a generic interface.
        * Additionally, implement two static generic methods returning the maximum and minimum values of an array (see prototype below),
        *  using a Measurer object as the sorting criterion.
        * Note well: The measure() method of the Measurer interface associates every object to an easy to sort double value!*/

        Integer[] v1= {1,2,3,4,5,4,3,2};
        String[] string1={"lollo","lillo","lolle","trattore","love"};
        String ret1=max(string1, new Measurer<String>() {
            @Override
            public double measure(String obj) {
                return (double) obj.length();
            }
        });
        System.out.println(ret1);
        /*
        * Write two generic static methods returning the maximum and minimum values of a generic list.
        * An instance of Comparator (see java.util.Comparator) is used as a sorting criterion.
        * The methods have the following prototype:*/


        Pair<String,String> pp1=new Pair<>("hola","ciao");
        Pair<String,String> pp2=new Pair<>("q tal","come stai");
        Pair<String,String> pp3=new Pair<>("hola","hi");
        Pair<String,String> pp4=new Pair<>("buenas","'giornata");
        List<Pair<String,String>> lp=new ArrayList<>(Arrays.asList(pp1,pp2,pp3,pp4));

        Pair<String,String> o= max(lp, new Comparator<Pair<String, String>>() {
            @Override
            public int compare(Pair<String, String> o1, Pair<String, String> o2) {
                int a=o1.getFirst().length() + o1.getSecond().length();
                int b=o2.getFirst().length() + o2.getSecond().length();
                return a-b;
            }
        });
        System.out.println("ritorna->"+o.toString());
        Pair<String,String> o1= min(lp, new Comparator<Pair<String, String>>() {
            @Override
            public int compare(Pair<String, String> o1, Pair<String, String> o2) {
                int a=o1.getFirst().length() + o1.getSecond().length();
                int b=o2.getFirst().length() + o2.getSecond().length();
                return a-b;
            }
        });
        System.out.println("ritorna->"+o1.toString());
    }


    //--------------- -------------- -------------------  -------------------
    public static <E> String iterableToString(Iterable<E> src){
        StringBuilder str=new StringBuilder();
        for (E e : src) {
            str.append(e).append(", ");
        }
        return str.toString();
    }
    public static <T extends Number> double divide(T a, T b ){
        return a.doubleValue()/ b.doubleValue();
    }
    public static <T> void append(List<T> dst, List<T> src){
        dst.addAll(src);
    }
    public static <T> void append2(List<T> dst, List<? extends T> src) {
        dst.addAll(src);
    }

    // Alternative version
    //public static <T, S extends T> void append(List<T> dst, List<S> src) {
    //    dst.addAll(src);
    //}
    public static <T> int countOccurrences(T[] src, T item){
        int counter=0;
        for(T i:src){

            if(item == null){
                if(i==null){
                    counter++;
                }
            }
            else{
                if(item == i){
                    counter ++;
                }
            }

        }
        return counter;
    }
    public static <K, V> Pair<V, K> swap(Pair<K, V> src){
        return  new Pair<>(src.second,src.first);
    }

    /*Write a generic static method that, given a Map<K, V>,
        returns a List<Pair<K, V>> of the key/value pairs in the map (see Map.entrySet()).
        */

    public static <K, V> List<Pair<K, V>> mapToPairs(Map<K, V> src){

        List<Pair<K,V>> lista=new LinkedList<>();

        for(Map.Entry<K,V> i: src.entrySet()){

            lista.add(new Pair<>(i.getKey(),i.getValue()));
        }

        return lista;
    }
    public static <T> T max(T[] array, Measurer<T> measurer){
        T ret=array[1];
        for(T i: array){
           if( Double.compare( measurer.measure(i),measurer.measure(ret)) >0){
               ret=i;
           }
        }
        return ret;
    }
    public static <T> T min(T[] array, Measurer<T> measurer){
        T ret=array[1];
        for(T i: array){
            if( Double.compare( measurer.measure(i),measurer.measure(ret)) < 0){
                ret=i;
            }
        }
        return ret;
    }

    public static <T> T max(List<T> list, Comparator<? super T> cmp){
        T ret= list.get(0);
        for (T i : list){
            if(cmp.compare(i,ret) > 0){
                ret=i;
            }
        }
        return ret;
    }
    public static <T> T min(List<T> list, Comparator<? super T> cmp){
        T ret= list.get(0);
        for (T i : list){
            if(cmp.compare(i,ret) < 0){
                ret=i;
            }
        }
        return ret;
    }
}