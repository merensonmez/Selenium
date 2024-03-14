package lesson_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstTest_Class  {


    public static void main(String[]args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","C:\\selenium\\seleniumFirstProject\\driver\\chromedriver.exe");

        driver.get("https:\\www.youtube.com");
        Thread.sleep(2);






    }
}
