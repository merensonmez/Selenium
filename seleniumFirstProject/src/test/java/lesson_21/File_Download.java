package lesson_21;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Files;
import java.nio.file.Paths;

public class File_Download {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://the-internet.herokuapp.com/download";
        driver.get(url);
        Thread.sleep(3000);
        WebElement testElement = driver.findElement(By.xpath("//a [.='test.txt']"));
        testElement.click();
        // C:\Users\LENOVO\Downloads\text.txt
        Thread.sleep(3000);
        String dosyaYolu = System.getProperty("user.home")+"\\Downloads\\test.txt";
        Boolean result = Files.exists(Paths.get(dosyaYolu));

        if(result){
            System.out.println("Test Passed ...");
        }else {
            System.out.println("Test Failed ...");
        }
        driver.close();
    }
}
