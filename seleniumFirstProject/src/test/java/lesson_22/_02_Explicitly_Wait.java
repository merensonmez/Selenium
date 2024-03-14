package lesson_22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _02_Explicitly_Wait {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();


        driver.get("https://www.amazon.com/s?k=iphone&ref=nb_sb_noss");

        WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
        element.sendKeys(" iphone 11");

        //WebElement button = driver.findElement(By.id("nav-search-submit-butto"));;

        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(15))
               .until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button")));

        button.click();
    }
}
