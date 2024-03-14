package lesson_20;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileExists_2 {
    public static void main(String[] args) {

        // C:\selenium\seleniumFirstProject\pom.xml
        String dosyaYolu = System.getProperty("user.dir")+"\\pom.xml";
        Boolean result = Files.exists(Paths.get(dosyaYolu));
        if(result){
            System.out.println("Test Passed ...");
        }else{
            System.out.println("Test Failed ...");
        }
    }
}
