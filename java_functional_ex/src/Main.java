import javax.xml.stream.StreamFilter;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("functional!\n\n");

        /*Write two static generic methods receiving, respectively,
        a generic List and a generic Map and printing to standard output their content
        following the template below. Both methods must be 1 line long (see List.forEach(), Map.forEach()).

        Examples:

        justPrintList(["Marco", "Matteo", "Luca", "Giovanni"]) → void*/

        List<String> l=List.of("lo","lo");
        justPrintList(List.of("Marco", "Matteo", "Luca", "Giovanni"));
        justPrintMap(Map.of(1, "nicola", 2, "agata", 3, "darma", 4, "marzia"));


        justPrintList(List.of("Marco", "Matteo", "Luca", "Giovanni"), s -> System.out.println("Hello " + s + "!"));

        justPrintMap(Map.of(1, "nicola", 2, "agata", 3, "darma", 4, "marzia"), (k, v) -> System.out.println("k:" + k + ", v:" + v));

        /*Write a (one-line!) method for adding (or removing) a price delta to all numbers of a certain family (see Map.replaceAll()).

        Examples:

        payMore(fees, "333", +0.5) -> adds 50 cents of monthly fee to all "333" numbers.
        payMore(fees, "347", -1.0) -> removes 1 euro of monthly fee to all "347" numbers.*/

        Map<String,Double> map1=Map.of("34745...", 11.75,"33367...", 9.75,"34833...",7.75,"33188..." , 7.75, "33112..." , 7.95);

        Map<String,Double> map=new LinkedHashMap<>();
        map.put("33367",9.0 );
        map.put("33167",9.0 );
        map.put("33117",9.0 );
        payMore(map,"331",2);
        justPrintMap(map);

        /*Given a list of integers, return a list of those numbers,
        omitting any that are between 13 and 19 inclusive (see Stream.filter(), Stream.collect()).

        Examples:

        noTeen([12, 13, 19, 20]) → [12, 20]
        noTeen([1, 14, 1]) → [1, 1]
        noTeen([15]) → []
        */

        justPrintList(noTeen(List.of(12,212,2,1,2,12,15,15,41,16,19)));

        /*Given a list of integers, return a list where each integer is added to 1 and the result is multiplied by 10.

        Examples:
        oneTen([1, 2, 3]) → [20, 30, 40]
        oneTen([6, 8, 6, 8, 1]) → [70, 90, 70, 90, 20]
        oneTen([10]) → [110]
*/
        justPrintList(oneTen(Arrays.asList(1,2,3,4)), n->System.out.println("\n->"+n));

        /*Given a list of non-negative integers, return a list of those numbers multiplied by 2,
        omitting any of the resulting numbers that end in 2 (
        see Stream.map(), Stream.filter(), Stream.collect()).
        Examples:
        twoTwo([1, 2, 3]) → [4, 6]
        twoTwo([2, 6, 11]) → [4]
        twoTwo([0]) → [0]*/
        System.out.println("\n---");
        justPrintList(twoTwo(Arrays.asList(2,11,2,1,111,1,2,3,4)), n->System.out.println("->"+n));

        /*Given a list of integers, square those numbers, add 10, omit any of the resulting numbers that end in 5, and return their number.

        Examples:

        squareFive([3, 1, 4]) → 3 ([19, 11, 26])
        squareFive([1]) → 1 ([11])
        squareFive([5]) → 0 ([])
*/
        System.out.println("\n->"+squareFive(Arrays.asList(5,2)));
        /*
        * Given a list of strings, return true if all strings are palindrome.

        allPalindrome(["kayak", "deed", "noon"]) → true
        allPalindrome(["kayak", "hello"]) → false
        allPalindrome(["hello", "world"]) → false*/
        System.out.println("\n->"+allPalindrome(List.of("treert","laal","anna")));

        /*Given a list of strings, return a list where each string has "y" added at its end, omitting any resulting strings that contain "yy" as a substring anywhere.

        Examples:

        noYY(["a", "b", "c"]) → ["ay", "by", "cy"]
        noYY(["a", "b", "cy"]) → ["ay", "by"]
        noYY(["xx", "ya", "zz"]) → ["xxy", "yay", "zzy"]
        The method has the following prototype:
        */
        justPrintList(noYY(List.of("a","b","d","y","a","y")), n->System.out.println("->"+n));

        /*Given a list of strings, return a list where each string has "y" added at its end, omitting any resulting strings that contain "yy" as a substring anywhere. Nevertheless, each string starting with "z" has to printed to standard output. (see Stream.peek())

        Examples:

        noYYZ(["a", "b", "c"]) → ["ay", "by", "cy"]
        noYYZ(["a", "b", "cy"]) → ["ay", "by"]
        noYYZ(["xx", "ya", "zz"]) → ["xxy", "yay", "zzy"] (prints "zzy")
        */
        justPrintList(noYYZ(List.of("a","b","d","y","a","y","zz")), n->System.out.println("->"+n));
        /*Download the Ulysses, by James Joyce book. Write two methods,
        reading all the lines of the file and returning respectively:
        (a) how many lines contain a specific substring,
        (b) how many times a specific word appears in an isolated form (not as a substring).*/

        try {
            System.out.println("num of lines = "+howManyLines("james-joyce-ulysses.txt","grey searching eyes" )+"\nby teacher->"+howManyLinesTeacher("james-joyce-ulysses.txt","grey searching eyes" ));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("num of words = "+howManyTimes("james-joyce-ulysses.txt","he" )+ "\nby teacher->"+howManyTimesteacher("james-joyce-ulysses.txt","he" ));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        /*
        * Write a method turning a Stream into a comma-separated list of its first n elements (see Collectors.joining())*/

        System.out.println("lo stream to list-> "+ toString( List.of(12,212,2,1,2,12,15,15,41).stream() , 4 ) );
        /*Write a method for:
        (a) filtering all the accounts whose duePayment is expired,
        (b) apply interests (amount += amount * interestRate), (c) sort them based their on amount,
        (d) return a List of the filtered accounts.*/

        Account a =new Account(500,5,LocalDateTime.of(2023, Month.NOVEMBER,10,10,10));
        Account b =new Account(6000,5,LocalDateTime.of(2023, Month.NOVEMBER,10,10,10));
        Account c =new Account(7000,5,LocalDateTime.of(2023, Month.OCTOBER,10,10,10));

        List<Account> aL = new ArrayList<>(List.of(a,b,c));
        System.out.println( "-->"+applyInterest(aL).toString());
        /*Write a method returning a Map<String, Double> having as keys the families of
        numbers (e.g., "347", "333", "348", etc) and as values the average subscription fee for
         that family (see this guide, and Collectors.groupingBy()).
        Examples:
        payOnAverage(fees) -> {"347" : 11.75, "333" : 9.75, "348" : 7.75, "331" : 7.85}*/


    }
    //--------------------------------------------------------------
    public static Map<String, Double> payOnAverage(Map<String, Double> fees){
        return fees.entrySet()
                .stream()
                .collect(Collectors
                        .groupingBy(
                                entryK ->entryK.getKey().substring(0,3) ,
                                Collectors.averagingDouble(entry-> entry.getValue())));
    }
    //--------------------------------------------------------------
    public static List<Account> applyInterest(List<Account> accounts){
       // return accounts.stream().filter(a->(a.getDuePayment().compareTo(LocalDateTime.now()) < 0)).peek(x-> x.setAmount(x.getAmount()+ x.getInterestRate())).sorted().collect(Collectors.toList());
        return  accounts.stream().filter(a->(LocalDateTime.now().isBefore(a.getDuePayment()))).peek(x-> x.setAmount(x.getAmount()+ x.getInterestRate())).sorted(new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                //return  Integer.parseInt(o1.getAmount() - o2.getAmount());
                return (int)(o1.getAmount() - o2.getAmount()) ;
            }
        }).collect(Collectors.toList()  );

    }
    /*public static List<Account> applyInterest(List<Account> accounts) {
        return accounts.stream()
                .filter(a -> a.getDuePayment().isBefore(LocalDateTime.now()))
                .peek(Account::applyInterest)
                .sorted((o1, o2) -> (int)o2.getAmount() - (int)o1.getAmount())
                .collect(Collectors.toList());
    }*/ // --> teacher
    //--------------------------------------------------------------
    public static <T> String toString(Stream<T> stream, int n){
        return stream.limit(n).map(Object::toString).collect(Collectors.joining(","));
    }
    //--------------------------------------------------------------
    public static long howManyLines(String filename, String subString) throws Exception{
        return getLines(filename).stream().filter(a->a.contains(subString)).count();
    }
    public static long howManyTimes(String filename, String word) throws Exception{
        return lineToWords( getLines(filename).stream().collect(Collectors.toList()).toString() ).stream().filter( e-> e.equals(word) ).count();
    }
    public static List<String> getLines(String filename) throws IOException {
        return Files.readAllLines(Path.of(filename));
    }
    public static List<String> lineToWords(String line) {
        return Arrays.asList(line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+"));
    }
    public static long howManyTimesteacher(String filename, String word) throws IOException {
        List<String> book = getLines(filename);
        return book.stream().flatMap(line -> Arrays.stream(line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+"))).filter(w -> w.equals(word)).count();
    }
    public static long howManyLinesTeacher(String filename, String subString) throws IOException {
        List<String> book = getLines(filename);
        return book.stream().filter(line -> line.contains(subString)).count();
    }


    //--------------------------------------------------------------
    public static List<String> noYYZ(List<String> strings){
        return strings.stream().map(n -> n + "y")
                .filter(a-> !a.contains("yy"))
                .peek(p->{
                    if(p.startsWith("z270975")){
                        System.out.println(p);
                    }
                }
                ).collect(Collectors.toList());
    }
    //--------------------------------------------------------------
    public static List<String> noYY(List<String> strings) {
        return strings.stream().map(n -> n + "y").filter((a) -> (a.compareTo("yy") != 0)).collect(Collectors.toList());
        //return strings.stream().map(s -> s + "y").filter(s -> !s.contains("yy")).collect(Collectors.toList());
    }
    //--------------------------------------------------------------
    public static boolean allPalindrome(List<String> strings){
        return strings.stream().allMatch(Main::isPalindrome);
    }

    public static boolean isPalindrome(String s){
        return ( new StringBuilder(s).reverse().compareTo(new StringBuilder(s)) ==0);
    }
    //--------------------------------------------------------------
    public static long squareFive(List<Integer> nums){
        return nums.stream().map((n)->n * n + 10).filter((n) -> (n%10) != 5).count();
    }

    public static List<Integer> twoTwo(List<Integer> nums){
        //return nums.stream().map(n -> n*2).filter((a)->((a-2)%10 == 0).collect();
        return nums.stream().filter((a)-> !a.toString().endsWith("1")).map(n -> n*2).collect(Collectors.toList());
    }
    //--------------------------------------------------------------
    public static List<Integer> oneTen(List<Integer> nums){

        return nums.stream().map((n) -> (n+1)*10).collect(Collectors.toList());

    }
    //--------------------------------------------------------------
    public static List<Integer> noTeen(List<Integer> nums){
        return nums.stream().filter((a)-> a<13 || a> 19).collect(Collectors.toList());
    }
    //------------------------------------------------------------
    public static void payMore(Map<String, Double> fees, String numberFamily, double costDelta){
        fees.replaceAll((k,v)-> k.startsWith(numberFamily) ? v + costDelta : v );            ;
    }
    //-------------------------------------------------------------
    public static <T> void justPrintList(List<T> strings, Consumer<? super T> consumer) {
        strings.forEach(consumer);
    }
    public static <K,V> void justPrintMap(Map<K, V> map, BiConsumer<? super K, ? super V> biConsumer) {
        map.forEach(biConsumer);
    }
    //--------------------------------------------------------------
    public static <T> void justPrintList(List<T> list){
        list.forEach((a)->System.out.println("Hello "+a+"!"));
    }
    public static <K,V> void justPrintMap(Map<K, V> map){
        map.forEach((a,u)->System.out.println("k:"+a+" v:"+u));

    }


}