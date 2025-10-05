package Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class screenShotCapture {
    public static void main(String[] args) throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Register.html");

        // Type 1: Capture a webelement screenshot
        WebElement logo= driver.findElement(By.xpath("//img[@src='original.png']"));
        File scr_logo= logo.getScreenshotAs(OutputType.FILE);
        File trg_logo= new File(".\\Screenshot\\logo.png");
        FileUtils.copyFile(scr_logo,trg_logo);

        // Type 2: Capture full page
        TakesScreenshot ts= (TakesScreenshot) driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File trg= new File(".\\Screenshot\\fullpage.jpg");
        FileUtils.copyFile(src,trg);

        // Some portion of a page
        WebElement portion= driver.findElement(By.xpath("//*[@id=\"section\"]/div/div/div[3]"));
        src=portion.getScreenshotAs(OutputType.FILE);
        trg=new File(".\\Screenshot\\portionPage.jpg");
        FileUtils.copyFile(src,trg);

        driver.close();


    }
}