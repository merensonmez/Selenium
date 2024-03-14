package lesson_8;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practise_1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","C:\\selenium\\seleniumFirstProject\\driver\\chromedriver.exe");
        driver.get("https://www.amazon.com.tr");



        driver.findElement(By.name("field-keywords")).sendKeys("iPhone 11", Keys.ENTER);

        driver.findElement(By.id("sp-cc-accept")).click();

        String aramaSonucuText =
         driver.findElement(By.xpath("(//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]/span)[1]")).getText()+
        driver.findElement(By.xpath("(//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]/span)[3   ]")).getText();
        System.out.println("Arama sonucu : "+aramaSonucuText);

        if(aramaSonucuText.contains("iPhone 11")){
            System.out.println("Arama sonucu iPhone 11 içeriyor");
        }else{
            System.out.println("Arama sonucu iphone 11 içermiyor");
        }

        System.out.println("İlk ürün fiyatı:" + driver.findElement(By.xpath("//span[@class=\"a-price-whole\"][1]")).getText());

        Thread.sleep(2000);
        driver.quit();


    }
}
