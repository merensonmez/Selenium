package lesson_11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;


public class Dropdown extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.amazon.com/tr");



        // 1. islem Dropdown locate islemi yapılır
        WebElement dropdownElement = driver.findElement(By.id("searchDropdownBox"));

        // 2.islem Select classından bir parametreli(dropdownElementi olacak) obje olustruyorum
        Select select = new Select(dropdownElement);

        // 1.yontem
        select.selectByIndex(3);
        System.out.println("3.indexteki Eleman : " + select.getFirstSelectedOption().getText()); // Baby
        Thread.sleep(2000);

        //2.yontem
        select.selectByValue("search-alias=stripbooks-intl-ship");
        System.out.println("Value : " + select.getFirstSelectedOption().getText()); // Books
        Thread.sleep(2000);

        //3.yontem
        select.selectByVisibleText("Digital Music");
        System.out.println("VisibleText : " + select.getFirstSelectedOption().getText());//Digital Music
        Thread.sleep(2000);

        // Tum option getirmek istiyorum
        List<WebElement> optionList = select.getOptions();
        int sayac = 0;
        System.out.println("\nTUM LISTE\n");

        for(WebElement w : optionList){
            System.out.println(sayac+" : " + w.getText());
            sayac++;
        }

        driver.close();


    }
}