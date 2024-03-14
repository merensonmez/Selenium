package lesson_19;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Practise_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://html.com/tags/iframe/";
        driver.get("https://html.com/tags/iframe/");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).
        sendKeys(Keys.PAGE_DOWN).
        sendKeys(Keys.ARROW_UP).
                perform();

        WebElement iFrame = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iFrame);
        Thread.sleep(2000);
        WebElement playElement = driver.findElement(By.xpath("//button[@aria-label='Oynat']"));
        playElement.click();

        WebElement duraklatElement = driver.findElement(By.xpath("//button[@title='Duraklat (k)']"));

        if (duraklatElement.isEnabled()){
            System.out.println("Video oynatılıyor ...");

        }
        Thread.sleep(2000);
        duraklatElement.click();
        Thread.sleep(2000);
        driver.close();

    }
}
