package lesson_16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/tr");
        Actions actions = new Actions(driver);
        WebElement helloTextElement = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        actions.moveToElement(helloTextElement).perform();

        Thread.sleep(3000);

        WebElement createAListText = driver.findElement(By.xpath("//span[.=\"Create a List\"]"));
        actions.click(createAListText).perform();

        String expectedResult = "https://www.amazon.com/hz/wishlist/intro";
        String actualResult = driver.getCurrentUrl();

        if (expectedResult.equals(actualResult)){
            System.out.println("Test Passed");
        }
        Thread.sleep(3000);
        driver.quit();
    }
}
