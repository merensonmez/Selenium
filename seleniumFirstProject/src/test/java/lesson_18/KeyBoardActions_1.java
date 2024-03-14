package lesson_18;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActions_1{
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();



        String url = "https://www.amazon.com/tr";
        driver.get(url);

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        Actions actions = new Actions(driver);
        //actions.click(searchBox).
               // keyDown(Keys.SHIFT).
                //sendKeys("s").
                //keyUp(Keys.SHIFT).
                //sendKeys("amsung").
                //sendKeys(Keys.SPACE).
                //sendKeys("A71").
                //sendKeys(Keys.ENTER).
                //perform();

        actions.click(searchBox).
                sendKeys("Samsung A71").
                sendKeys(Keys.ENTER).
                perform();

        String expectedResult = "\"Samsung A71\"";
        String actualResult = driver.findElement(By.xpath("//*[.='\"Samsung A71\"']")).getText();
        if(actualResult.equals(expectedResult)){
            System.out.println("Test Passed");
        }
        driver.close();
    }
}