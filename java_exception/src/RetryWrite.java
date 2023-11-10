import java.io.IOException;

public class RetryWrite {

        public static void main(String[] args) {
            try {
                writeWithTries(3);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        public static void writeWithTries(int maxTries) {
                try{
                    write("ciao");
                    //if good not catch
                }catch (IOException e){
                    for(int i=0;i<maxTries;i++){
                        try{
                            write("ciao");
                            break;
                        }catch (IOException e1){

                        }
                        //not finisched

                    }
                }



        }

        public static void write(String message) throws IOException {
            throw new IOException("Unable to send: " + message);
        }

}
 /*The following RetryWrite class contains a write() method for writing a message over a network connection
        which might fail (in this example it always throws an IOException). Because network
        connections sometimes fail unexpectedly, we do not want to call it directly from the main() method.
         Instead, we use an intermediate writeWithTries() which, if write() fails, calls it again until
         the specified number of retries (maxTries) has been reached.
         Complete the writeWithTries() method to make the code below work.*/
