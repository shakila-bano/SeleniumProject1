package Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class alertBoxHandle {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.manage().window().maximize();
        Thread.sleep(5000);

        System.out.println("Ready to click");
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        System.out.println("Button clicked");
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        System.out.println("Alert accepeted");

        // Ok & CAncel button
        System.out.println("Ready to click");
        driver.findElement(By.xpath("//a[@href='#CancelTab']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();

        // Alert with text

        System.out.println("ready to click");
       // driver.findElement(By.linkText("Alert with Textbox ")).click();
        driver.findElement(By.xpath("//a[@href='#Textbox']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        Alert alertKey= driver.switchTo().alert();
       // Thread.sleep(5000);
        alertKey.sendKeys("Hi, I am Testing Alert");
        Thread.sleep(3000);
        alertKey.accept();


    }

}
