import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class N11Test {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        driver.get("https://www.n11.com/");

        // Close Adboard //
        driver.findElement(By.xpath("//div[@class=\"btn btnPrimary btnBlack-loc-info\"]")).click();
        Thread.sleep(1000);

        WebElement electronic =  driver.findElement(By.xpath("//img[@src=\"https://n11scdn.akamaized.net/a1/30/22/08/01/53/46/97/55/78/81/00/58/49/31961828233979739225.png\"]"));
        electronic.click();
        Thread.sleep(1000);

        WebElement specialProduct = driver.findElement(By.xpath("//a[@data-banner-name=\"Fırsat Ürünleri\"]"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(100);",specialProduct);
        Thread.sleep(2000);
        if (specialProduct.isDisplayed()) {
            System.out.println("Special product is displayed successfully");
            jse.executeScript("arguments[0].click();", specialProduct);
        }else {
            System.out.println("Test failed!!!");
        }
        jse.executeScript("window.scrollBy(0 , 1000)");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@title=\"Bilgisayar&Konsol \"]")).click();
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0 , 1000)");
        Thread.sleep(1000);
        WebElement selection = driver.findElement(By.xpath("//i[@class=\"iconSortBy\"]"));
        selection.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@data-value=\"PRICE_HIGH\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder=\"Ara\"]")).sendKeys("monster");
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0,100)");
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("Screenshots/test.png"));
        System.out.println("Screenshot is captured!!!");
        Thread.sleep(1000);
        WebElement expectedMessage = driver.findElement(By.xpath("//input[@placeholder=\"Ara\"]"));
        expectedMessage.getText();

        if (expectedMessage.isDisplayed()){
            System.out.println("Test passed!!!" + expectedMessage.getText());
        }else {
            System.out.println("Test failed!!! Please try to test again");
        }
        driver.close();
    }
}
