package lesson_15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowHandle {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        String url= "https://the-internet.herokuapp.com/windows";
        driver.get(url);
        String windowHandle1 = driver.getWindowHandle();

        Thread.sleep(3000);
        WebElement clickHereButton = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHereButton.click();
        Set<String> handleDegerleriSet = driver.getWindowHandles();
        System.out.println("handleDegerleriSet = "+handleDegerleriSet);
        String windowHandle2 = "";
        for(String each : handleDegerleriSet){
            if (!each.equals(windowHandle1)){
                windowHandle2 = each;
            }
        }
        driver.switchTo().window(windowHandle2);
        Thread.sleep(3000);
        if(driver.getTitle().equals("New Window")){
            System.out.println(driver.getTitle());
        }
        driver.switchTo().window(windowHandle1);
        if(driver.getTitle().equals("The Internet")){
            System.out.println(driver.getTitle());
        }
        Thread.sleep(3000);
        WebElement elementalSeleniumButton = driver.findElement(By.xpath("//a[.='Elemental Selenium']"));
        elementalSeleniumButton.click();
        Set<String> handleDegerleriSet2 = driver.getWindowHandles();
        System.out.println("handleDegerleriSet2 = " + handleDegerleriSet2);
        String windowHandle3 = "";
        for(String each : handleDegerleriSet2) {
            if((!each.equals(windowHandle1)) && (!each.equals(windowHandle2))){
                windowHandle3 = each;
            }
        }
        driver.switchTo().window(windowHandle3);
        Thread.sleep(3000);
        if(driver.getTitle().contains("Elemental Selenium")){
            System.out.println(driver.getTitle());
        }
        driver.switchTo().window(windowHandle1);
        if(driver.getTitle().equals("The Internet")){
            System.out.println(driver.getTitle());
        }
        Thread.sleep(3000);
        driver.quit();
        //driver.close();
    }
}
