package lesson_20;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileExists_1 {
    public static void main(String[] args) {

       // System.out.println(System.getProperty("user.dir")); //  C:\selenium\seleniumFirstProject
        // System.out.println(System.getProperty("user.home")); // C:\Users\LENOVO

        //C:\Users\LENOVO\Desktop\test\deneme.txt
        String dosyaYolu = System.getProperty("user.home")+"\\Desktop\\test\\deneme.txt";
        Boolean result = Files.exists(Paths.get(dosyaYolu));
        if(result){
            System.out.println("Test PASSED ...");
        }else{
            System.out.println("Test FAILED ...");
        }

    }
}
