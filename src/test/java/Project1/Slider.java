package Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {
    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Register.html");

        Actions act= new Actions(driver);
        /*act.moveToElement(driver.findElement(By.xpath("//a[text()='Widgets']"))).click().perform();
        act.moveToElement(driver.findElement(By.xpath("//a[text()=' Slider ']"))).click().perform();
        */
        // Alternate way of above logic to  move to slider page
        WebElement widget= driver.findElement(By.xpath("//a[text()='Widgets']"));
        WebElement slider=driver.findElement(By.xpath("//a[text()=' Slider ']"));
        act.moveToElement(widget).moveToElement(slider).click().perform();

        WebElement slide= driver.findElement(By.xpath("//*[@id='slider']/a"));
        System.out.println("Location is : "+slide.getLocation()); //(414, 282)
        System.out.println("Size is : "+slide.getSize()); //(18, 39)

        act.dragAndDropBy(slide,100,100).perform();
        System.out.println("Location is : "+slide.getLocation()); //(414, 282)
        System.out.println("Size is : "+slide.getSize()); //(18, 39)

       //act.keyDown()
    }

}
