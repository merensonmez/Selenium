package trendyolproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class trendyolProjectsignup {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.trendyol.com/");

        WebElement acceptCookies = driver.findElement(By.xpath("//button[@id=\"onetrust-accept-btn-handler\"]"));
        acceptCookies.click();
        Thread.sleep(1000);
        WebElement login = driver.findElement(By.xpath("//p[contains(text(),'Giriş Yap')]"));
        login.click();
        Thread.sleep(1000);
        WebElement signup = driver.findElement(By.xpath("(//span[contains(text(),'Üye Ol')])[1]"));
        signup.click();
        Thread.sleep(1000);
        WebElement emailAddress = driver.findElement(By.id("register-email"));
        emailAddress.sendKeys("erensonmezerrrr@gmail.com");
        Thread.sleep(1000);
        WebElement password = driver.findElement(By.id("register-password-input"));
        password.sendKeys("123456789Ee");
        Thread.sleep(1000);
        WebElement gender = driver.findElement(By.xpath("//span[normalize-space()='Erkek']"));
        gender.click();
        Thread.sleep(1000);
        WebElement checkbox = driver.findElement(By.xpath("//div[contains(text(),'Tarafıma avantajlı tekliflerin sunulabilmesi amacı')]"));
        checkbox.click();
        Thread.sleep(1000);
        WebElement checkbox1 = driver.findElement(By.xpath("(//div[contains(@class,'ty-display-flex ty-mgt-1')])[2]"));
        checkbox1.click();
        Thread.sleep(1000);

        WebElement iframe = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
        driver.switchTo().frame(iframe);
        iframe.click();
        Thread.sleep(1000);
        WebElement lastSignupButton = driver.findElement(By.xpath("//button[@type='submit']"));
        lastSignupButton.click();
        Thread.sleep(1000);
    }
}
