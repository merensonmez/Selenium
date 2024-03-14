package lesson_3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverGetMethods {
    public static void main(String[]args){

        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","C:\\selenium\\seleniumFirstProject\\driver\\chromedriver.exe");

        driver.get("https://www.amazon.com"); //get : Belirtilen URL'e gider

        System.out.println("Amazon URL : "    + driver.getCurrentUrl()); // CurrentURL tarayıcıdaki o andaki URL'yi getirir.

        System.out.println("Amazon Title : " +driver.getTitle()); // Sayfanın title'ını getirir. Amazon.com. Spend less. Smile more.

        driver.getPageSource(); // Tüm HTML kodlarını getirir.

        System.out.println(driver.getWindowHandle()); //B9BF8F56BD7258559CB0231F5C18DEAA

        System.out.println("Driver Class Type : " + driver.getClass()); // org.openqa.selenium.chrome.ChromeDriver;
    }
}
