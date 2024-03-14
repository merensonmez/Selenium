 package loginDeneme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginDeneme {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);

        WebElement userName = driver.findElement(By.id("username"));
        userName.click();
        userName.sendKeys("tomsmith");
        Thread.sleep(3000);

        WebElement passWord= driver.findElement(By.id("password"));
        passWord.click();
        passWord.sendKeys("SuperSecretPassword!");

        WebElement loginClass = driver.findElement(By.xpath("//button[.=' Login']"));
        loginClass.click();
        Thread.sleep(3000);
        WebElement secureArea = driver.findElement(By.xpath("//h2[.=' Secure Area']"));
        if(secureArea.isEnabled()){
            System.out.println("Test Başarılı");
        }else{
            System.out.println("Test Başarısız");
        }
        Thread.sleep(3000);
        driver.close();
    }
}
