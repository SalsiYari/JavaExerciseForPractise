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


        for(int i=0;i<maxTries;i++){
            try{
                write("questo è il messaggio");
                break;
            }catch(IOException ignored){

            }
        }
        throw new RuntimeException(">"+maxTries+"tentativi falliti ");

    }

    public static void write(String message) throws IOException {
        throw new IOException("Unable to send: " + message);
    }
}
