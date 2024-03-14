package lesson_100;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class deneme {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);

        WebElement usernameLogin = driver.findElement(By.id("username"));
        usernameLogin.click();
        Thread.sleep(3000);
        usernameLogin.sendKeys("tomsmith");

        WebElement passwordLogin = driver.findElement(By.id("password"));
        passwordLogin.click();
        Thread.sleep(3000);
        passwordLogin.sendKeys("SuperSecretPassword!");


        WebElement login = driver.findElement(By.xpath("//button[@class='radius']"));
        login.click();

        

    }
}
