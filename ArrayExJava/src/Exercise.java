import java.util.Scanner;

public class Exercise {

    public Exercise() {
    }

    ;

    public static boolean isEveryWhere(int[] v, int value) {
        boolean status = true;

        int dim = v.length / 2;      //num of couple
        int j = 1;                  //pointer of j_element

        for (int i = 0; i < dim; i++) {

            if (v[j - 1] != value && v[j] != value) {      //|| j >= v.length) always false, i'm taking only the "couples"
                status = false;
            }
            j += 2;
        }
        return status;
    }

    //strings exertcise
    public static String concatenate(String[] string) {
        StringBuilder ret = new StringBuilder();
        for (String s : string) {
            ret.append(s);
            ret.append(" ");
        }
        return ret.toString();
    }

    public static String reverse(String string) {
        StringBuilder ret = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            ret.append(string.charAt(i));
        }
        return ret.toString();
    }

    public static String removeFirstTwoChars(String string) {
        StringBuilder ret = new StringBuilder();
        if (string.length() < 2) {
            return null;
        }
        return ret.append(string.substring(2)).toString();
    }

    public static boolean goodAroundTheBeginning(String string) {
        return (string.startsWith("good") || string.startsWith("good", 1));
    }

    public static char[] duplicateChars(String string){
        /*
        StringBuilder str=new StringBuilder(string);
        StringBuilder save=new StringBuilder();
        int j=0;
        boolean find=false;

        for(j=0;j<str.length();j++){
            for(int i=j+1;i<str.length();i++){

                find=false;
                for(int k=0;k<save.length();k++){
                    if (Character.compare(str.charAt(i),save.charAt(k) ) == 0){
                        find=true;
                    }
                }

                if(Character.compare(str.charAt(j),str.charAt(i)) == 0  && !find ){
                    save.append(str.charAt(j));
                }
            }
        }

        System.out.println("-->"+save.toString());
        return save.toString().toCharArray();
    }
    */
        StringBuilder str=new StringBuilder();

        for(int i=0;i<string.length();i++){

            String tmp=String.valueOf(string.charAt(i));
            if( !str.toString().contains(tmp) ){
                str.append(string.charAt(i));
            }

        }
        String s1=str.toString();
        System.out.println("1-->"+s1);

        char[] result=s1.toCharArray();
        java.util.Arrays.sort(result);
        System.out.println("2-->"+ String.valueOf(result));

        //char[] result = str.toString().toCharArray();

        java.util.Arrays.sort(result);
        System.out.println("-->"+str.toString());

        return result;

    }

    public static int countYZ(String string) {
        int countYZ = 0;
        Scanner scanner = new Scanner(string);
        while (scanner.hasNext()) {
            String token = scanner.next().toLowerCase();
            char lastChar = token.charAt(token.length() - 1);
            if (lastChar == 'y' || lastChar == 'z') {
                countYZ++;
            }
        }
        return countYZ;
    }

    public static boolean equalIsNot(String string) {
        return countMatches(string, "is") == countMatches(string, "not");
    }


    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public static int countMatches(String text, String str) {
        if (isEmpty(text) || isEmpty(str)) {
            return 0;
        }
        int index = 0;
        int count = 0;
        while (true) {
            index = text.indexOf(str, index);
            if (index != -1) {
                count++;
                index += str.length();
            } else {
                break;
            }
        }
        return count;
    }


}