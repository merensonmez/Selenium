package lesson_8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practise_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","C:\\selenium\\seleniumFirstProject\\driver\\chromedriver.exe");

        driver.manage().window().maximize();



        driver.get("https://www.amazon.com.tr/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Laptop");
        searchBox.submit();

        WebElement aramaSonucuElement = driver.findElement(By.xpath("(//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]/span)[1]"));
        System.out.println("Arama sonucu : "+aramaSonucuElement.getText());

        WebElement firstPicture = driver.findElement(By.xpath("(//img[@class=\"s-image\"])[1]"));
        firstPicture.click();

        Thread.sleep(2000);
        driver.quit();
    }
}
