


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!, some exercises on arrays in java");
        Exercise ex=new Exercise();
        //IsEveryWhere
        /*[IsEverywhere.java] We'll say that a value is "everywhere" in an array if for every pair of adjacent elements
        in the array,at least one of the pair is that value. Return true if the given value is everywhere in the array.

        Examples:

        isEverywhere([1, 2, 1, 3], 1) → true
        isEverywhere([1, 2, 1, 3], 2) → false
        isEverywhere([1, 2, 1, 3, 4], 1) → false
        The method has the following prototype:

        public static boolean isEverywhere(int[] v, int value);
        where:

        v is the int[] array to be processed.
        value is the value to be verified (if it is everywhere).*/
        int[] v = {1,2,3,1,5,1,6};
        System.out.println("\n1)the result is -> " +  ex.isEveryWhere(v,1));

        /*[Concatenate.java] Write a method accepting a String[] returning a single string representing the concatenation
        of all strings of the array (see StringBuilder class).

        Examples:

        concatenate(["Hello", " ", "World!"]) → "Hello World!"
        concatenate(["H", "e", "llo", " ", "World!"]) → "Hello World!"
        concatenate(["Hello World", "!"]) → "Hello World!"
        The method has the following prototype:

        public static String concatenate(String[] strings);
        where:

        strings is the String array to be concatenated
*/
        String[] phrase={"ciao","is","hello","for","italians"};
        System.out.println("\n2) The Phrase is -> "+ ex.concatenate(phrase));

        /*[Reverse.java] Write a method accepting a string and returning the reversed string (see String.charAt() method).

        Examples:

        reverse("String test") → "tset gnirtS"
        reverse("John Doe") → "eoD nhoJ"
        reverse("Hello World!") → "!dlroW olleH"
        The method has the following prototype:

         public static String reverse(String string);
        where:

        string is the string to be reversed*/

        String s="Hello world!";
        String s1="Hola Mundo";
        System.out.println("\n3) reverse -> " + ex.reverse(s1) );

        /*[RemoveFirstTwoChars.java] Write a method accepting a string and returning the same string without the first two characters (see StringBuilder class).

        Examples:

        removeFirstTwoChars("Hello World!") → "llo World!"
        removeFirstTwoChars("No") → ""
        removeFirstTwoChars("Y") → ""
        The method has the following prototype:

        public static String removeFirstTwoChars(String string);
        where:

        string is the string to be processed*/
        System.out.println("\n4) deleting first two characters ->"+ ex.removeFirstTwoChars(s1));

        /*[GoodAroundTheBeginning.java] Write a method accepting a string and returning true if "good" appears either at index 0 or 1 of the given string (see String.startsWith() method).

        Examples:

        goodAroundTheBeginning("good Sweet") → true
        goodAroundTheBeginning("_good Sweet") → true
        goodAroundTheBeginning("__good Sweet") → false
        goodAroundTheBeginning("goo") → false
        The method has the following prototype:

        public static boolean goodAroundTheBeginning(String string);
        where:

        string is the string to be processed
*/
        System.out.println("\n5) starts with good? ->"+ ex.goodAroundTheBeginning("_good means mi piace y me gusta tambìen  "));

        /*[DuplicateChars.java] Write a method accepting a string and returning all recurring characters
        contained into the string as a char[]. More specifically, recurring characters have to be returned
        in alphabetical order (see String.valueOf(), String.contains(), String.toCharArray()).
        For example: headmistressship -> [e,h,i,s].

        Examples:

        duplicateChars("whistleblower") → [e, l, w]
        duplicateChars("ss") → [s]
        duplicateChars("s") → []
        duplicateChars("") → []
        The method has the following prototype:

        public static char[] duplicateChars(String string);
        where:

        string is the string to be processed*/

        //hola, soy yo que ablo de ti, hace tiempo no te veo por ahì

        String tmp="feel_feel_ lollo_and_so_on";
        char[] tmp1= ex.duplicateChars(tmp);
        System.out.println("\n6) how many times? -> "+ tmp1.toString() );

        /*
        [CountYZ.java] Write a method accepting a string, and counting the number of words ending in 'y' or 'z' so the 'y' in "heavy" and the 'z' in "fez" count, but not the 'y' in "yellow" (not case sensitive) (see Scanner class).

        Examples:

        countYZ("fez day") → 2
        countYZ("day fez") → 2
        countYZ("day fyyyz") → 2
        The method has the following prototype:

        public static int countYZ(String string)
         */

        System.out.println("\n7) number -> "+ ex.countYZ("so, hy , firstovall i need to be loyal with you: oz is a wizard and iray is not my name ") );

        /**
         * [EqualIsNot.java] Write a method accepting a string, and returning true if the number of appearances of "is" anywhere in the string is equal to the number of appearances of "not" anywhere in the string (case sensitive) (See String.indexOf()).
         *
         * Examples:
         *
         * equalIsNot("This is not") → false
         * equalIsNot("This is notnot") → true
         * equalIsNot("noisxxnotyynotxisi") → true
         * The method has the following prototype:
         *
         * public static boolean equalIsNot(String string);
         * where:
         *
         * string is the string to be processed
         */

        System.out.println("\n7) -->" + ex.equalIsNot("noisxxnotyynotxisi"));

    }
}
