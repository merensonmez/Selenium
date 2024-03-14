package lesson_14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://the-internet.herokuapp.com/iframe";
        driver.get(url);

        WebElement baslikText = driver.findElement(By.xpath("//div//h3"));
        String expectedResult = "An iFrame containing the TinyMCE WYSIWYG Editor";
        String actualResult = baslikText.getText();

        if(actualResult.equals(expectedResult)){
            System.out.println("Baslık Testi : Passed");
            System.out.println(actualResult);
        }
        Thread.sleep(3000);
        WebElement iframe = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframe);
        Thread.sleep(3000);
        WebElement textElement = driver.findElement(By.tagName("p"));
        Thread.sleep(3000);
        textElement.clear();
        Thread.sleep(3000);
        textElement.sendKeys("Merhaba Dunya!");

        driver.switchTo().parentFrame(); // --> 1 üst seviyedeki frame çıkarır.
        //driver.switchTo().defaultContent(); // --> En üst frame gider.

        driver.close();
    }
}
