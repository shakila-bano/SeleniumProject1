import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementVsFindEelments {

    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver  = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        //findElement()
        driver.findElement(By.id("small-searchterms")).sendKeys("Phone");

        WebElement ele=driver.findElement(By.xpath("//div[@class=\"footer-upper\"]//a"));
        System.out.println("Test is: "+ele.getText());

        // Multiple element

        List<WebElement> links = driver.findElements(By.xpath("//div[@class=\"footer-upper\"]//a"));
        for (int i=0;i<links.size();i++)
            System.out.println("Elements "+i+" is: "+links.get(i).getText());

        for(WebElement elements:links)
            System.out.println("2nd Approach: "+elements.getText());


    }

}
