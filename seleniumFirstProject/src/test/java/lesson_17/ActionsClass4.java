package lesson_17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://demoqa.com/droppable";
        driver.get(url);

        WebElement dragMeElement = driver.findElement(By.id("draggable"));
        WebElement dropHereElement = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMeElement,dropHereElement).perform();
        Thread.sleep(2000);

        String expectedResult = "Dropped!";
        String actualResult = dropHereElement.getText();
        Thread.sleep(3000);
        if(expectedResult.equals(actualResult)){
            System.out.println("actualResult = " + actualResult);
            System.out.println("Test Passed ....");
        }
        driver.close();
    }
}
