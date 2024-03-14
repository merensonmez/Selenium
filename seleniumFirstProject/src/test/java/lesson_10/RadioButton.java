package lesson_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton{
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","C:\\project\\chromeDriver\\chromedriver.exe");
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");

        String url = "https://www.facebook.com";
        driver.get(url);

        WebElement yeniHesapOlustur_Button = driver.findElement(By.xpath("//a[.='Yeni hesap oluştur']"));
        yeniHesapOlustur_Button.click();
        Thread.sleep(2000);
        WebElement erkek_RadioButton = driver.findElement(By.xpath("//input[@value=\"2\"]"));

        if(!erkek_RadioButton.isSelected()){
            Thread.sleep(2000);
            erkek_RadioButton.click();
            Thread.sleep(2000);
        }
        driver.close();
    }
}