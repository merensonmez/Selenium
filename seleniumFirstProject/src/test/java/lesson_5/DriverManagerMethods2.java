package lesson_5;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManagerMethods2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","C:\\selenium\\seleniumFirstProject\\driver\\chromedriver.exe");

        // 1. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.youtube.com");
        // 2. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Sayfanın Konumu : "+driver.manage().window().getPosition());
        System.out.println("Sayfanın Boyutları : "+driver.manage().window().getSize());

        // 3. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin

        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1080,720));

        // 4. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        int xKoor = driver.manage().window().getPosition().getX();
        int yKoor = driver.manage().window().getPosition().getY();
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();

        System.out.println("Son Sayfanın Konumu : "+driver.manage().window().getPosition());
        System.out.println("Son Sayfanın Boyutları : "+driver.manage().window().getSize());
        Thread.sleep(3000);

        if(xKoor == 0 && yKoor == 0 && width == 1080 && height == 720 ){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }

        // 5. Sayfayi kapatin
        driver.close();
    }
}
