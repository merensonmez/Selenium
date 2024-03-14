package lesson_16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(driver);
        WebElement ciziliAlan = driver.findElement(By.id("hot-spot"));
        actions.contextClick(ciziliAlan).perform();

        String expectedResult = "You selected a context menu";
        String actualResult = driver.switchTo().alert().getText();
        Thread.sleep(3000);
        if(expectedResult.equals(actualResult)){
            System.out.println("actualResult = " + actualResult);
            System.out.println("Test PASSED");
        }

        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        driver.close();

    }
}
