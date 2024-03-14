package lesson_24;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JSExecuter_02 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/tr");



        JavascriptExecutor jse = (JavascriptExecutor)  driver;
        WebElement sellElement = driver.findElement(By.xpath("//*[.='Sell products on Amazon']"));
        jse.executeScript("arguments[0].scrollIntoView(true);",sellElement);
        Thread.sleep(3000);
        jse.executeScript("arguments[0].click();",sellElement);

        WebElement controlElement = driver.findElement(By.xpath("//*[contains(text(),'$50,000 in branded sales.')]"));
        if (controlElement.isEnabled()){
            System.out.println("Test Passed!!!");
        }
        driver.quit();
    }
    }

