package lesson_21;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class File_Upload {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://the-internet.herokuapp.com/upload";
        driver.get(url);

        WebElement fileSecButton = driver.findElement(By.id("file-upload"));
        Thread.sleep(3000);
        String dosyaYolu = System.getProperty("user.home")+"\\Downloads\\test.txt";
        fileSecButton.sendKeys(dosyaYolu);
        Thread.sleep(3000);

        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        Thread.sleep(3000);

        WebElement fileUploadedText = driver.findElement(By.xpath("//h3[.='File Uploaded!']"));
        if(fileUploadedText.isEnabled()){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
        driver.close();
    }

}
