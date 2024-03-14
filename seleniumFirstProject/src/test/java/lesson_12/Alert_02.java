package lesson_12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert_02 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement alertButton2 = driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]"));
        WebElement result = driver.findElement(By.id("result"));
        Thread.sleep(3000);
        alertButton2.click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        // JS ALERT isleminde Cancel tusuna basmak istiyorsak dismiss() methodunu kullanmamız gerekiyor.
        Thread.sleep(3000);
        String expectedResult = "You clicked: Cancel";
        String actualResult= result.getText();
        Thread.sleep(3000);
        if(actualResult.equals(expectedResult)) {
            System.out.println("Test 2 Passed");
        }
        Thread.sleep(3000);
        driver.close();

    }
}
