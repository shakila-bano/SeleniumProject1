package Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandleMultipleDropDown {
    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.orangehrm.com/en/30-day-free-trial");


        WebElement countrylist= driver.findElement(By.id("Form_getForm_Country"));
        selectDropDownOptions(countrylist,"Congo");

        WebElement language = driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul[2]/select"));
        selectDropDownOptions(language,"Spanish");


        // for selectByValue method in 2nd approach
       // selectDropDownOptions(language,"/es/30-day-free-trial");

        driver.close();

    }

    public static void selectDropDownOptions(WebElement ele,String value){

        Select drp=new Select(ele);

        // 1st approach:  using select class method
       //drp.selectByVisibleText(value); // 1st approach:  using select class method

        // 2nd approach: using select class method ByValue
       // drp.selectByValue(value);

        // 3rd approach using general method
        List<WebElement> options = drp.getOptions(); // Capture the webelements for the dropdown with select tag in the page
        for(WebElement opt:options){
            if (opt.getText().equals(value)){
                opt.click();
                break;
            }
        }

    }


}
