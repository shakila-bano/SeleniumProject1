package Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitGenericMethod {
    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.get("https://www.bing.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("sb_form_q")).sendKeys("Selenium wait");
        driver.findElement(By.id("sb_form_q")).sendKeys(Keys.RETURN);
        By element= By.xpath("//*[@id='b_results']/li[1]/h2/a");
        WebElement webPage= explicitWaitMethod(driver, 10, element);
        webPage.click();

    }
    public static WebElement explicitWaitMethod(WebDriver edriver, int timeout, By locator){
        WebDriverWait myWait= new WebDriverWait(edriver, Duration.ofSeconds(timeout));
        WebElement ele= myWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return ele;

    }

}
