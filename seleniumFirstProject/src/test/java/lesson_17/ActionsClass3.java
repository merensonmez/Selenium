package lesson_17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://selenium08.blogspot.com/2020/01/click-and-hold.html";
        driver.get(url);

        WebElement titleC = driver.findElement(By.xpath("//li[@name='C']"));
        WebElement titleD = driver.findElement(By.xpath("//li[@name='D']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(titleC).moveToElement(titleD).perform();
        Thread.sleep(3000);
        driver.close();
        System.out.println("Test PASSED!!");
    }
}
