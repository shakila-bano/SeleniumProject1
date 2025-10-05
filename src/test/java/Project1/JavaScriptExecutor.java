package Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class JavaScriptExecutor {

    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Static.html");
        driver.manage().window().maximize();

        //------------------Draw Border--------------------

        WebElement logo=driver.findElement(By.id("dragarea"));
        JavaScriptUtility.JavaScriptDrawBorder(logo,driver);

        //------------------Capture Screenshot--------------------

        TakesScreenshot ts= (TakesScreenshot) driver;
        File Src= ts.getScreenshotAs(OutputType.FILE);
        File trg= new File(".\\Screenshot\\JavaLogo.png");
        FileUtils.copyFile(Src,trg);

        //------------------Title Of Page--------------------
        String title= JavaScriptUtility.getTitleOfPage(driver);
        System.out.println("title name is: "+title);

        // -------------Click Element using JS ------------------
        WebElement WebTableElement= driver.findElement(By.linkText("WebTable"));
        JavaScriptUtility.clickElementByJS(driver,WebTableElement);

        //------------------Title Of Page--------------------

        title= JavaScriptUtility.getTitleOfPage(driver);
        System.out.println("title name is: "+title);

        //------------------Generate Alert--------------------

       JavaScriptUtility.generateAlert(driver,"This is Automation...");
       driver.switchTo().alert().accept();

        String tabAction=Keys.chord(Keys.CONTROL,Keys.RETURN);

        //------------------Page Refresh--------------------

        driver.findElement(By.partialLinkText("Practice")).sendKeys(tabAction);
        System.out.println("title name is: "+driver.getTitle());

        //Refresh the Web page
        JavaScriptUtility.refreshBrowserByJS(driver);
        System.out.println("Refresh is done: ");

        //------------------Scroll Down--------------------

        driver.findElement(By.linkText("Register")).click();
       // WebElement submitBtn= driver.findElement(By.id("submitbtn"));
        JavaScriptUtility.scrollDownByJS(driver);
        System.out.println("Page Scroll to Down: ");

        Thread.sleep(3000);

        //------------------Scroll UP--------------------
        //WebElement registerText= driver.findElement(By.xpath("//*[@id=\"section\"]/div/h2"));
        JavaScriptUtility.scrollUpByJS(driver);
        System.out.println("Page Scroll Up: ");

        //------------------Flash Element--------------------

        WebElement header=driver.findElement(By.xpath("//*[@id='section']/div/h2"));
        JavaScriptUtility.flashByJs(driver,header);
        System.out.println("Element flash: ");


    }


}
