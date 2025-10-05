package Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

    public static void main(String[] args){


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.opencart.com/index.php?route=account/register");
        driver.manage().window().maximize();
        WebElement opt=driver.findElement(By.id("input-country"));
        Select drp=new Select(opt);
        drp.selectByVisibleText("India");
        drp.selectByValue("9");

    }
}
