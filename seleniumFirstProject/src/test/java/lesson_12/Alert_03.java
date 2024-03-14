package lesson_12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert_03 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement alertButton3 = driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));
        WebElement result = driver.findElement(By.id("result"));

        alertButton3.click();
        Thread.sleep(2000);

        driver.switchTo().alert().sendKeys("Eren Sönmez");
        Thread.sleep(2000);

        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        String expectedResult= "You entered: Eren Sönmez";
        String actualResult = result.getText();

        if(actualResult.equals(expectedResult)) {
            System.out.println("Test 3 Passed");
        }
        driver.close();

    }
}
