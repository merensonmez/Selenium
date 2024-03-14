package lesson_23;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Locate_ScreenShot {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/tr");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Apple", Keys.ENTER);

        WebElement locateSS = driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"][1]"));

        String output = System.getProperty("user.dir") + "//Screenshot//locateSS.png"    ;
        File webElementSS = new File(output);

        File geciciResim = locateSS.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciResim, webElementSS);

        driver.quit();
    }
}
