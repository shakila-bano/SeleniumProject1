package Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class datePickerDropDown {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.automationtesting.in/Datepicker.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.findElement(By.id("datepicker2")).click();

        WebElement yr= driver.findElement(By.xpath("//*[@class='datepick-month-header']/select[2]"));
        Select yr_drop= new Select(yr);
        yr_drop.selectByVisibleText("2015");
        System.out.println("Yr is selected");
        //yr_drop.selectByValue("2019");


        WebElement mon= driver.findElement(By.xpath("//*[@class='datepick-month-header']/select[1]"));
        Select mon_drop= new Select(mon);
        mon_drop.selectByVisibleText("May");
        System.out.println("Month is selected");



        String date="24";
        List<WebElement> dates_opt= driver.findElements(By.xpath("//td/a[@href='javascript:void(0)']"));
        for (WebElement dates:dates_opt){

            if (dates.getText().equals(date)){
                dates.click();
                break;
            }
        }
        System.out.println("Date is: "+ driver.findElement(By.id("datepicker2")).getText());

        driver.close();

    }
}
