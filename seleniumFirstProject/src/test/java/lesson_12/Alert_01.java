package lesson_12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert_01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement alertButton1 = driver.findElement(By.xpath("//button [@onclick=\"jsAlert()\"]"));
        WebElement result = driver.findElement(By.id("result"));

        alertButton1.click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        //JS Alert de tamam butonuna tıklamak için accept() methodunu kullanırız.
        Thread.sleep(3000);
        String expectedResult = "You successfully clicked an alert";
        String actualResult= result.getText();

        if(actualResult.equals(expectedResult)) {
            System.out.println("Test 1 Passed");
        }
            Thread.sleep(3000);
        driver.close();
        }
    }
