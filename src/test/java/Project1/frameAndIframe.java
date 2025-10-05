package Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class frameAndIframe {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://demo.automationtesting.in/Frames.html");
        driver.manage().window().maximize();

        Thread.sleep(3000);

        System.out.println("Ready to switch frame-");
        driver.switchTo().frame("SingleFrame");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hello Selenium");
        System.out.println("Driver switch to frame-");

        driver.switchTo().defaultContent();
        System.out.println("Switch to default content:");

        driver.findElement(By.linkText("Iframe with in an Iframe")).click();
        System.out.println("Inner Frame link clicked");

        WebElement firstFrame = driver.findElement(By.xpath("//*[@src='MultipleFrames.html']"));
        driver.switchTo().frame(firstFrame);
        WebElement innerFrame = driver.findElement(By.xpath("//*[@src='SingleFrame.html']"));
        driver.switchTo().frame(innerFrame);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Selenium in Automation");

        driver.switchTo().parentFrame(); // switched to parent frame
        System.out.println("Driver is inside Nested frame: ");
        String text= driver.findElement(By.xpath("/html/body/section/div/div/h5")).getText();
        System.out.println("Text in the frame is: "+ text);




    }
}
