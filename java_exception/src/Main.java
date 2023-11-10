import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.sql.Time;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {
    private static Scanner s;

    public static void main(String[] args) {
        /*
        * Write a method receiving two doubles (a, b) and returning their division. If b == 0,
        *  the method throws IllegalArgumentException. Note well: IllegalArgumentException is an unchecked
        * exception so its declaration in the method signature is not required! */

        try{
            Scanner s=new Scanner(System.in );
            System.out.println("insert here two val:");
            System.out.println("\n->division:"+ division( new Scanner(System.in).nextDouble(), new Scanner(System.in).nextDouble()));
        }catch (IllegalArgumentException e){
            System.out.println("you cant't divide by 0");
        }
        /*Write a method receiving two integers (a, b) and returning their integer division squared
        ( i.e., (a / b) ^ 2).
        If b == 0, the method returns 0, instead of an exception.
        The implementation of this method must avoid the use of the if statement.

         */
        try{
            System.out.println("\n--\ninsert here 2 val:");
            System.out.println("\n->division:"+divisionSquared(new Scanner(System.in).nextInt(),new Scanner(System.in).nextInt()));
        }catch (IllegalArgumentException e){
            System.out.println("you cant't divide by 0");
        }
        //other version
        try{
            System.out.println("\n--\ninsert here 2 val:");
            System.out.println("\n->division:"+divisionSquaredTeacher(new Scanner(System.in).nextInt(),new Scanner(System.in).nextInt()));
        }catch (IllegalArgumentException e){
            System.out.println("you cant't divide by 0");
        }
        /*Write a method receiving two strings representing dates (i.e., yyyy-mm-dd)
         and returning true if the first date is before the second date (see java.time.LocalDate).
         Eventual exceptions must be delegated to the caller (Remember: not all exceptions are checked).
        * */
        try{
            System.out.println("date?->"+checkIntervalBetweenDates("2030-10-21","1211-2-12"));
        }catch (DateTimeParseException e ){
            System.out.println("ops");
        }
        /*
        * Write a method to check if a string representing a car licence plate respects the italian format
        * (i.e., LLDDDLL where L represents a letter while D a digit). If the string does not respect the format,
        *  the method throws IllegalArgumentException (see Character.isDigit() and Character.isLetter() methods).*/

        try{
            checkLicencePlate("1V102ZT");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        /* Write a method to check if a string is an alternating sequence of letters and numbers
        * (for example, a0b3h4z1r4). The method delegates ParseException for notifying the caller about
        * eventual malformations (see Character.isDigit() and Character.isLetter() methods).*/

        try{
            checkString("a7a7a7");
            checkString("4a7a7ao1");

        }catch (ParseException p){
            System.out.println(p.getMessage());
        }

        /*Using the checkString() method, write another method for filtering a List. The method returns
        a different List comprising only those strings which are an alternating
        sequence of letters and numbers (for example a0b3h4z1r4). The original list is not modified.*/
        System.out.println("\nlist\n->"+filterItems(new LinkedList<>(Arrays.asList("1m1m1m1","2t6t6t2","2b2b2b22","l0l0l0l1","r8r7r6r5r","1m2n3b44"))));


        /*Using the checkString() method, write another method for filtering a List<List>
        (a list of lists of strings). The method returns a List<List> comprising only those List containing
        ONLY alternating sequences of letters and numbers (for example a0b3h4z1r4). The original List should not be modified.*/

        List<String> ls=new ArrayList<>(List.of("ciao","1l1l11l","ql1l3l3l","lolo","l4l3l2l1l","b3b4b5b6b") );
        List<String> ls1=new ArrayList<>(List.of("2b4b4b2b","lillo","ql1l3l3l","lolo","l4l3l2l1l","b3b4b5b6b") );
        List<String> ls2=new ArrayList<>(List.of("n2n2m2m","1l1l11l","ql1l3l3l","3b2n5m63f","l4l3l2l1l","b3b4b5b6b") );
        List<String> ls3=new ArrayList<>(List.of("s","1l1l11l","ql1l3l3l","3b2n5m63f","l4l3l2l1l","b3b4b5b6b") );
        List<String> ls4=new ArrayList<>(List.of("n2n2m2m","1l1l1l","q9l1l3l3l","3b2n5m6i0i3f","x2x7x3x9x3x","b3b4b5b6b") );
        List<String> ls5=new ArrayList<>(List.of("l3b4","4b3b","2n2j","2n2n2n","3n2b2v","1n2h3") );



        List<List<String>> lls= new ArrayList<>(List.of(ls,ls1,ls2,ls3,ls4,ls5) );

        System.out.println("\n-..-.-.-.-.-.-.\n");

        for(List<String> lista: filterLists(lls)){
           System.out.println("\n->"+ lista);
        }
        /*
        * Write a method for reading the first line of a given file (see java.io.BufferedReader class).
        * In case of errors (IOException), the method applies a complete delegation model. Use the syntax
        * try-with-resources for guaranteeing the proper closing of the file under any circumstance. The method has
        * the following prototype:
         */

        try {
            String s = readLineCompleteDelegation("james-joyce-ulysses.txt");
            System.out.println("\n\n->linea->\n"+s);
        }catch (IOException e){
            System.out.println("file con errore");
        }
        /*Write a method for reading the first line of a given file (see java.io.BufferedReader class).
        In case of errors (IOException), the method applies a partial
        delegation model throwing an unchecked exception (RunTimeException) instead of IOException.
        The method has the following prototype:*/

        try {
            String s = readLinePartialDelegation("james-joyce-ulysses.txt");
            System.out.println("\n\n->linea->\n"+s);
        }catch (RuntimeException e){
            System.out.println("file con errore");
        }
        /*Write a method reading the first line of a given file (see java.io.BufferedReader class).
        In case of errors (IOException), the method applies a no-delegation model and returns null.
        The method has the following prototype:*/

        //---

    }


    //################################################################
    public static String readLineNoDelegation(String filename){
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
           return br.readLine();
        }catch (IOException e){
            return null;
        }

    }
    //################################################################
    public static String readLinePartialDelegation(String filename){
        try(BufferedReader br= new BufferedReader(new FileReader(filename))){
            return br.readLine();
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
    //################################################################
    public static String readLineCompleteDelegation(String filename) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            return reader.readLine();
        }
    }
    //################################################################
    public static List<List<String>> filterLists(List<List<String>> lists){
        List<List<String>> ls= new ArrayList<>();

        for(List<String> l: lists){

            try{
                for(String s:l){
                    checkString(s);
                }
                //this part only if not exception®
                ls.add(l);
            }
            catch (ParseException ignored){

            }
        }

        return ls;
    }
    //################################################################
    public static List<String> filterItems(List<String> strings){
        List<String> l= new LinkedList<>();
        for(String s : strings){

            try{
                checkString(s);
                l.add(s);
            }catch (ParseException p){
                continue;
            }
        }
        return l;
    }
    //################################################################
    public static void checkString(String s) throws ParseException {
        int i=0;
        if(Character.isLetter(s.charAt(i))){
            checkNum(i+1,s);
        }else{
            checkLetter(i+1,s);
        }
    }
    public static void checkNum(int i,String s) throws ParseException{
        if(i<s.length()){
            if(Character.isDigit(s.charAt(i)))
                checkLetter(i+1,s);
            else
                throw new ParseException("wrong character->"+s.charAt(i)+"in position->"+i , i);
        }
    }
    public static void checkLetter(int i, String s) throws ParseException{
        if(i<s.length()){
            if(Character.isLetter(s.charAt(i)) ){
                checkNum(i+1,s);
            }
            else
                throw new ParseException("wrong character->"+s.charAt(i)+"in position->"+i , i);
        }

    }
    //################################################################
    public static void checkLicencePlate(String licence){

        if (!Character.isDigit(licence.charAt(0)) && !Character.isDigit(licence.charAt(1)) || !Character.isLetter(licence.charAt(2)) || !Character.isLetter(licence.charAt(3))  ||   !Character.isLetter(licence.charAt(4)) || !Character.isLetter( licence.charAt(5))   ||   !Character.isDigit(licence.charAt(6)) || licence.length() != 7)
            throw new IllegalArgumentException("somethioing wrong");
    }
    //################################################################
    public static boolean checkIntervalBetweenDates(String begin, String end){
            return LocalDateTime.parse(begin).isBefore( LocalDateTime.parse(end));
    }
    //################################################################
    public static int divisionSquaredTeacher(int a, int b){
        try{return (a/b)*(a/b);}
        catch (ArithmeticException e){
            return 0;
        }
    }

    public static int divisionSquared(int a, int b){
        try{
            return (int) (division(a,b) * division(a,b));
        }catch (IllegalArgumentException e){
            return 0;
        }
    }
    //################################################################
    public static double division(double a, double b){
        if(Double.compare(b,0)==0){
            throw new IllegalArgumentException("");
        }
        return a/b;
    }
}