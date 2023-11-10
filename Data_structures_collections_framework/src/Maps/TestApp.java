package Maps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class TestApp {
    public static void main(String[] args){
        /*Write a static method accepting a String, converting it to lowercase, and returning its Morse translation. The 26 lowercase letters of the english alphabet have to be supported.

         You have to use a Map<Characher, String> as a conversion table (dot='.', dash='_'). If the input String contains characters not supported by the conversion table, IllegalArgumentException have to be thrown.

         Examples:

         morseCode("hello") -> .... . ._.. ._.. ___
         morseCode("world") -> .__ ___ ._. ._.. _..
         morseCode("w0rld") -> IllegalArgumentException
         The method has the following prototype:

         public static String morseCode(String string);
         where:

         string is the string to be converted in Morse.
         */
        String s="hel0lo";
        try{

        System.out.println("the string is->"+s+"\nthe result is->"+morseCode(s));
        }catch (IllegalArgumentException e){
            System.out.println("exceprioin e");
        }
        /*Write a static method accepting a Map<String, String> and returning true if some values have been used as keys as well.

        The method has the following prototype:

        public static boolean valuesKeys(Map<String, String> map);
        where:

        map is the map to be checked.*/
        Map<String, String> map=new HashMap<String,String>();
        map.put("ciao","miao");
        map.put("bau","miao");
        map.put("nihao","raw");
        map.put("miao","sao");
        System.out.println("--> contiene valori=chiavi ? \n"+valuesKeys(map));

        /*Write a static method accepting a Map<Integer, String> and returning a Map<String, Integer> in which the original keys and values have been inverted. In case of repeated values (thus associated to multiple keys) you can select one of the keys.

        Examples:

        invertMap({1: "Hello", 3: "World"}) → {"Hello": 1, "World": 3}
        invertMap({1: "Hello", 3: "Hello"}) → {"Hello": 3}
        The method has the following prototype:

        public static Map<String, Integer> invertMap(Map<Integer, String> src);
        where:

        src is the map to be inverted.*/
        Map<Integer,String> map1=new HashMap<Integer,String>();
        map1.put(1,"Ciao");
        map1.put(2,"miai");
        map1.put(3,"miao");
        map1.put(4,"Ciao");
        System.out.println("the map is like->"+map1.toString()+"\nbut reversed is->"+invertMap(map1));
        /*Download the Ulysses, by James Joyce book. Write a method, reading all the lines of the file and returning a
        Map<String, Integer> having all the unique words of the book as keys, associated with the number of times they appeared.

        The method has the following prototype:

        public static Map<String, Integer> wordFrequency(String filename) throws IOException;
        where:

        filename is the filename of the book.
        */
        try{
            wordFrequency("james-joyce-ulysses.txt");
       // System.out.println("\nho ottenuto questa hashmap->"+wordFrequency("james-joyce-ulysses.txt"));
        }catch (IOException e){
            System.out.println("\nsiamo seri");
        }

        /*Add two methods to WordFrequency.java for returning a new Map<String, Integer> containing only the n most (or less) frequent words and their frequency.
         Entries within the returned Map, have to be sorted by value (i.e. frequency). For sorting, you can transform the Map<String, Integer> into a
         List<Map.Entry<String, Integer>> which can be sorted using a Comparator<Map.Entry<String, Integer>>.
        Remember also that LinkedHashMap is an implementation of Map maintaining the insertion order.
        The methods have the following prototype:

        public static Map<String, Integer> mostFrequent(Map<String, Integer> map, int limit);
        public static Map<String, Integer> lessFrequent(Map<String, Integer> map, int limit);
        where:

        map is the Map<String, Integer> to be processed.
        limit is the number of most (or less) frequent words to be returned*/

    }
    public static String morseCode(String string){
        String cmp= string.toLowerCase();
        StringBuilder sb=new StringBuilder();
        HashMap<Character, String> mappa= conversionMap();
        for(int i=0;i<cmp.length();i++){

            if(Character.isDigit(cmp.charAt(i))){
                throw new IllegalArgumentException();
            }
            sb.append(mappa.get(cmp.charAt(i)));
        }
        return sb.toString();
    }
    public static HashMap<Character, String> conversionMap() {
        HashMap<Character, String> conversionMap = new HashMap<>();
        conversionMap.put('a', "._");
        conversionMap.put('b', "_...");
        conversionMap.put('c', "_._.");
        conversionMap.put('d', "_..");
        conversionMap.put('e', ".");
        conversionMap.put('f', ".._.");
        conversionMap.put('g', "__.");
        conversionMap.put('h', "....");
        conversionMap.put('i', "..");
        conversionMap.put('j', ".___");
        conversionMap.put('k', "_._");
        conversionMap.put('l', "._..");
        conversionMap.put('m', "__");
        conversionMap.put('n', "_.");
        conversionMap.put('o', "___");
        conversionMap.put('p', ".__.");
        conversionMap.put('q', "__._");
        conversionMap.put('r', "._.");
        conversionMap.put('s', "...");
        conversionMap.put('t', "_");
        conversionMap.put('u', ".._");
        conversionMap.put('v', "..._");
        conversionMap.put('w', ".__");
        conversionMap.put('x', "_.._");
        conversionMap.put('y', "_.__");
        conversionMap.put('z', "__..");
        return conversionMap;
    }
    //----------------------------------------
    public static boolean valuesKeys(Map<String, String> map){
        for(String s :map.values() ){
            for(String s1: map.keySet()){
                if(s1.compareTo(s) == 0){
                    return true;
                }
            }
        }
        return false;
    }
    public static Map<String, Integer> invertMap(Map<Integer, String> src){

        Set<String> key=new LinkedHashSet<>(src.values());      //->new key without

        Map< String,Integer> ret=new HashMap< String,   Integer>();

        for(Integer i : src.keySet()){
            if(key.contains(src.get(i))){
                ret.put(src.get(i) ,i);
                key.remove(src.get(i));
            }
        }
        return ret;
    }

    public static Map<String, Integer> wordFrequency(String filename) throws IOException{
        Map<String,Integer> ret=new HashMap<>();
        /*List<String> lines=getLines("james-joyce-ulysses.txt");
        Set<String> keys=new HashSet<>();

        for(String s : lines){
            for(String s1: lineToWords(s)){
                if(!ret.containsKey(s1)){

                }
            }
        }

        for(String s : keys){
            int counter=0;

            for(String line : lines){
                for(String words: lineToWords(line)){
                    if(s.compareTo(words) ==0){
                        counter++;
                    }
                }
            }
            for(String key : ret.keySet()){
                ret.put(s,counter);
            }
        }
        return ret;*/

        for(String s:getLines(filename)){
            List<String> words=lineToWords(s);
            for(String word:words){
               if(ret.containsKey(word)){
                   ret.put(word,ret.get(word)+1);
               }else{
                   ret.put(word,1);
               }
            }
        }

        mostFrequent(ret,10);

        System.out.println("-->teacher->"+mostFrequentTeacher(ret,10).toString());
        return ret;
    }

    public static List<String> getLines(String filename) throws IOException {
        return Files.readAllLines(Path.of(filename));
    }
    public static List<String> lineToWords(String line) {
        return Arrays.asList(line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+"));
    }

    /*List<Map.Entry<String, Integer>> which can be sorted using a Comparator<Map.Entry<String, Integer>>.
    Remember also that LinkedHashMap is an implementation of Map maintaining the insertion order.*/
    public static Map<String, Integer> mostFrequent(Map<String, Integer> map, int limit){
        List<Map.Entry<String , Integer>> list= new LinkedList<>();
        list.addAll(map.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {            //from =1 to =maz
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

                if(o1.getValue() > o2.getValue() ){
                    return +1;
                }
                else if (o1.getValue() < o2.getValue() ){
                    return -1;
                }
                return 0;
            }
        });
        Map<String,Integer> ret= new LinkedHashMap<>();
        for(int i=0;i<limit;i++){
            ret.put(list.get(list.size()-1).getKey(),list.get(list.size()-1).getValue());
            list.remove(list.size()-1);
        }
        System.out.println("-->lista sort->"+ret.toString());

        return ret;

    }
    public static Map<String, Integer> lessFrequent(Map<String, Integer> map, int limit){
        return new HashMap<String,Integer>( );
    }


    public static Map<String, Integer> sortAndCut(Map<String, Integer> map, Comparator<Map.Entry<String, Integer>> comparator, int limit) {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(comparator);
        entries = new ArrayList<>(entries.subList(0, limit));

        Map<String, Integer> dst = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) {
            dst.put(entry.getKey(), entry.getValue());
        }
        return dst;
    }

    public static Map<String, Integer> mostFrequentTeacher(Map<String, Integer> map, int limit) {
        return sortAndCut(map, (e1, e2) -> e2.getValue() - e1.getValue(), limit);
    }

    public static Map<String, Integer> lessFrequentteacher(Map<String, Integer> map, int limit) {
        return sortAndCut(map, (e1, e2) -> e1.getValue() - e2.getValue(), limit);
    }


}
