package Queue;

import java.util.*;

public class TestApp {

    public static void main(String[] args){

        /*Write a method reversing the order of words in a sentence (represented as a List<String>)
        using an ArrayDeque as a stack (see .addLast() and .pollLast() methods). Each word has to be pushed to the stack and fetched later.
        If the stack is behaving correctly, the order is reversed.

        Examples:

        reverse(["Hello", "World!"]) → ["World!", "Hello"]
        reverse(["I", "am"]) → ["am", "I"]
        The method has the following prototype:

        public static List<String> reverse(List<String> sentence);
        where:

        sentence is the list of words to be reversed.*/


        List<String> lista= new ArrayList<String>(Arrays.asList("ciao","in","italian","means","good","luck","XD"));
        lista=reverse(lista);
        System.out.println("list to be reversed->"+lista.toString());
        System.out.println("reversed lis->"+lista.toString());
    }

    public static List<String> reverse(List<String> sentence){
        ArrayDeque<String> ret= new ArrayDeque<String>();
        for(String str : sentence){
            ret.addFirst(str);
        }
        return ret.stream().toList();
    }
}
