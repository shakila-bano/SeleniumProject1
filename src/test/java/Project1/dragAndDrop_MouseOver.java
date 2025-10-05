package Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class dragAndDrop_MouseOver {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Static.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Creation of action class
        Actions act=new Actions(driver);

        WebElement targetArea= driver.findElement(By.id("droparea"));
        System.out.println("Target area-");

        WebElement sourceArea= driver.findElement(By.id("angular"));
        System.out.println("Source area-");

        // single item drag and drop
        act.dragAndDrop(sourceArea,targetArea).perform();
        System.out.println("Performed single item drag and drop");

        List<WebElement> sourceItem=driver.findElements(By.xpath("//*[@class='col-xs-10 col-xs-offset-2']"));

        //Drag and drop multiple items


        for (WebElement item:sourceItem){
            act.dragAndDrop(item,targetArea).perform();
        }
        System.out.println("click action By mouse hover");
        WebElement level1=driver.findElement(By.xpath("//a[text()='Video']")); //
        WebElement level2=driver.findElement(By.xpath("//a[text()='Youtube']")); //
        act.moveToElement(level1).moveToElement(level2).click().perform(); //click the option from mouse hover
        System.out.println("click action-");

        driver.close();
        System.out.println("browser close-");
    }
}
