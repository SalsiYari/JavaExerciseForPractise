import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*Write a set of methods accepting a String representing a file
name and returning various attributes of the file
(see java.nio.file.Files, java.nio.file.Paths).

*/
public class FileMethods {

    public static void main(String[] args){

    }
    //----<-<-<-<-<-<-<--<-<--<---->--->------>----->--->--
    public static boolean exists(String filename){
       return Files.exists(Paths.get(filename));
    }

    public static boolean isReadable(String filename){
        return Files.isReadable(Paths.get(filename));
    }
    public static boolean isWritable(String filename){
        return Files.isWritable(Paths.get(filename));
    }
    public static boolean isExecutable(String filename){
        return Files.isExecutable(Paths.get(filename));
    }
    public static boolean isRegularFile(String filename){
        Files.isRegularFile(Paths.get(filename));
    }
    public static boolean isDirectory(String filename){
        Files.isDirectory(Paths.get(filename));
    }
    public static long size(String filename) throws IOException{
        return Files.size(Paths.get(filename));
    }
    /*Write two methods accepting two strings representing a source and a
         destination paths for respectively copying and moving the source to the destination
          (see java.nio.file.Files, java.nio.file.Paths).
         */
    public static void fileCopy(String src, String dst) throws IOException{
        Files.copy(Paths.get(src),Paths.get(dst), StandardCopyOption.REPLACE_EXISTING);
    }
    public static void fileMove(String src, String dst) throws IOException{
        Files.move(Paths.get(src),Paths.get(src),StandardCopyOption.REPLACE_EXISTING);
    }
    /*Write two methods accepting a string representing a path for, respectively, creating
    an empty file and deleting it (see java.nio.file.Files, java.nio.file.Paths)
     */
    public static void createFile(String src) throws IOException{
        Files.createFile(Paths.get(src));
    }
    public static void deleteFile(String src) throws IOException{
        Files.deleteIfExists(Paths.get(src));
    }
    /*Write a method accepting a string representing
    a directory path returning a Set<String> representing the names of the files
    (not directories!) contained within (see java.nio.file.Files, java.nio.file.Paths)
     */
    public static Set<String> fileList(String src) throws IOException{
        if(Files.isDirectory(Paths.get(src))){
            Stream<Path> s = Files.list(Paths.get(src));
            s.filter(f-> ! Files.isDirectory(Paths.get(src)) )
                    .map(m-> m.getFileName())
                    .map(m->m.toString())
                    .collect(Collectors.toList())   ;
        }else{
            throw new IOException();
        }
    }
}
