package Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AutoSuggestionDropDown {
    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.bing.com");
        driver.findElement(By.id("sb_form_q")).sendKeys("selenium");

       List<WebElement>listsuggest= driver.findElements(By.xpath("//li[contains(@class,'sa_blue_hv')]//span"));
        //List<WebElement>listsuggest= driver.findElements(By.xpath("//li[@class='sa_sg  sa_blue_hv   ')]//span"));
       // List<WebElement> listsuggest= driver.findElements(By.className("sa_blue_hv"));
        System.out.println("suggestion size: "+listsuggest.size());
        for (WebElement item:listsuggest){
            System.out.println("item is: "+item.getText());

            if(item.getText().contains("download")){
                System.out.println("item found");
                item.click();
                break;
            }

        }


    }


}
