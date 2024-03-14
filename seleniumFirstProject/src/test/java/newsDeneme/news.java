package newsDeneme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class news {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://www.haberler.com/";
        driver.get(url);

        WebElement searchheaderButton = driver.findElement(By.id("txtHeaderSearch"));
        searchheaderButton.click();
        searchheaderButton.sendKeys("Zonguldak");

        WebElement searchButton = driver.findElement(By.xpath("//div[@class='bgReda']"));
        searchButton.click();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);
        WebElement trueFalse = driver.findElement(By.xpath("//h1[@class='title']"));
        if (trueFalse.isEnabled()){
            System.out.println("This test passed");
        }else{
            System.out.println("This test failed!");
        }
        driver.close();

    }
}
