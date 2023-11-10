package Sets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TestApp {
    public static void main(String[] args){
        /* Write a method returning the intersection of two given sets of Integers (without using the Set.retainAll() method).

        Examples:

        intersection([1,2,3], [4,5,6]) → []
        intersection([1,2,3], [3,4,5]) → [3]
        The method has the following prototype:

        public static Set<Integer> intersection(Set<Integer> first, Set<Integer> second);
        where:

        first is the first Set.
        second is the second Set.*/
        Set<Integer> first=new LinkedHashSet<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        Set<Integer> second=new LinkedHashSet<Integer>(Arrays.asList(2,4,6,7,8,9,10));
        Set<Integer> set1=intersection(first,second);
        System.out.println("->"+set1.toString());

        /*
        * rite a method accepting a string and returning a set comprising all recurring characters of the string.
        Examples:

        recurringChars("Ciao") → []
        recurringChars("Hello") → ['l']
        recurringChars("Hello World!") → ['l', 'o']
        The method has the following prototype:

        public static Set<Character> recurringChars(String string);
        where:

        string is the string to be processed.*/

        System.out.println("it was -->hii , string full of character repetitttionnss\nnow is-->"+recurringChars("hii , string full of character repetitttionnss"));

        /*Implement the sieve of Eratosthenes: a method for computing prime numbers, known to the ancient Greeks.
        This method will compute all prime numbers up to n. Choose an n. First insert all numbers from 1 to n into a set.
         Then erase all multiples of 2 (except 2); that is, 4, 6, 8, 10, 12, . . . . Erase all multiples of 3; that is, 6, 9, 12, 15, . . . . Go up to sqrt(n). Then return the set.

        The method has the following prototype:

        public static Set<Integer> eratosthenes(int n);
        where:

        [1, n] is the range in which searching for primes.
        */

        System.out.println("->prime number of: "+40+"\nare -->"+eratosthenes(40).toString());
        /*
        Download the Ulysses, by James Joyce book. Write a method, reading all the unique words of the book (all words have to be converted in lowercase), and sorting them in alphabetical order. Given a word, the method returns the next word (in alphabetical order) contained within the book (See TreeSet.tailSet()).

        The method has the following prototype:

        public static String wordAfterWord(String filename, String word) throws IOException;
        where:

        filename is the filename of the book.
        string is the word to be searched.*/
       try{
           String searched="stephen";
           System.out.println("the word sherched is ->"+searched+"\n the next word is->"+wordAfterWord("james-joyce-ulysses.txt",searched));
       } catch (IOException e) {
           throw new RuntimeException(e);
       }

        try{
            String searched="stephen";
            System.out.println("the word sherched by the teacher\nis ->"+searched+"\n the next word is->"+wordAfterWordTeacher("james-joyce-ulysses.txt",searched));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public static Set<Integer> intersection(Set<Integer> first, Set<Integer>  second){
        Set<Integer> ret=new LinkedHashSet<Integer>();

        for(Integer j : first){
            if(second.contains(j)){
                ret.add(j);
            }
        }return ret;
    }
    public static Set<Character> recurringChars(String string){
        Set<Character> ret= new LinkedHashSet<Character>();
        for(int i=0;i<string.length();i++){
            ret.add(string.charAt(i));
        }
        return ret;
    }
    public static Set<Integer> eratosthenes(int n){
        Set<Integer> first= new LinkedHashSet<Integer>();

        for(int i=1;i<=n;i++){
            first.add(i);
        }

        for(int i=2;i<Math.sqrt(n) ;i++){       //for all value between 2->sqr(n)
            for(int k=i+1;k<=n;k++){               //for all elements except i
                if((k % i) == 0){                   //if i find it as a multiple of "i"
                    if(first.contains(k)){
                        first.remove(k);
                    }
                }
            }
        }
        return first;
    }

    public static String wordAfterWord(String filename, String word) throws IOException {
        List<String> lines;
        /*                                                  ->to understand where path is
            int i=0;
            String fn="result.csv";
            Path pathToFile = Paths.get(fn);
            System.out.println(pathToFile.toAbsolutePath());

         */


        try {
            lines=getLines(filename);
            Set<String> words=new TreeSet<String>();

            for(String s : lines){           //for all lines
                Set<String> removeDup=new LinkedHashSet<String>(lineToWords(s));

                for(String str:removeDup){
                    words.add(str.toLowerCase());
                }
            }
            //now i have theoretically words in order, without duplicate in "words"
            boolean find=false;
            for(String s:words){
                if(find)
                    return s;
                if(s.compareTo(word) == 0){
                    find=true;
                }
            }

        }catch (IOException e){
            throw new RuntimeException(e);        }
        return null;
    }
    public static String wordAfterWordTeacher(String filename, String word) throws IOException {
        TreeSet<String> words = new TreeSet<>();
        for (String line : getLines(filename)) {
            words.addAll(lineToWords(line));
        }
        return words.tailSet(word, false).first();
    }



    public static List<String> getLines(String filename) throws IOException {
        return Files.readAllLines(Path.of(filename));

    }
    public static List<String> lineToWords(String line) {
        return Arrays.asList(line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+"));
    }


}
