package Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class fluentWaitAndWindowHandle {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bing.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("sb_form_q")).sendKeys("Selenium wait");
        driver.findElement(By.id("sb_form_q")).sendKeys(Keys.RETURN);
        By element= By.xpath("//*[@id='b_results']/li[1]/h2/a");

        WebElement ele=fluentWaitGenericMethod(driver,element);
        System.out.println("Linked is clicked");
        ele.click();

        // Switch window concept
        Set<String> winIds=driver.getWindowHandles();

        // ------------------   iterator method   -----------------
        /*Iterator<String> Ids=winIds.iterator();
        String parentId= Ids.next();
        System.out.println("Parent Id is: "+parentId);
        String childId= Ids.next();
        System.out.println("Child Id is: "+childId);

        driver.switchTo().window(childId);
        String text=driver.findElement(By.xpath("//*[@class='td-content']/h1")).getText();
        System.out.println("New window text is: "+ text);*/

        // -------------------- List method ----------------------

        List<String> Ids= new ArrayList(winIds);
        String parentId = Ids.get(0);
        System.out.println("Parent Id is: "+parentId);
        String childId = Ids.get(1);
        System.out.println("Child Id is: "+childId);

        driver.switchTo().window(childId);
        String text=driver.findElement(By.xpath("//*[@class='td-content']/h1")).getText();
        System.out.println("New window text is: "+ text);


    }

    public static WebElement fluentWaitGenericMethod(WebDriver ldriver, By locator){

        Wait<WebDriver> myWait = new FluentWait<WebDriver>(ldriver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(NoSuchElementException.class);

        WebElement foo = myWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver ldriver) {
                return ldriver.findElement(locator);
            }

        });

        return foo;
    }

}
