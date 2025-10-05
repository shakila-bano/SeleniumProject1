package Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class datePicker {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.get("https://demo.automationtesting.in/Datepicker.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebElement dateField=driver.findElement(By.id("datepicker1"));
        dateField.click();
        String year="2024";
        String month="November";
        String date="12";
        String yr, mon;
        int flag=0;

        while (true){
           yr= driver.findElement(By.xpath("//*[@class='ui-datepicker-title']/span[2]")).getText();
           while (yr.equals(year)){
               mon =driver.findElement(By.xpath("//*[@class='ui-datepicker-title']/span[1]")).getText();
               if (mon.equalsIgnoreCase(month)){
                   System.out.println("Month: "+mon+" year: "+yr);
                   flag=1;
                   break;
               }
               else
                   driver.findElement(By.xpath("//*[@class='ui-datepicker-prev ui-corner-all']/span")).click();
           }
           if(flag==1)
               break;
           //By prevIcon= By.xpath("//*[@class='ui-datepicker-prev ui-corner-all']/span");
          // WebElement prev= explicitWaitMethod(driver,100,prevIcon);
           driver.findElement(By.xpath("//*[@class='ui-datepicker-prev ui-corner-all']/span")).click();
           //prev.click();
           System.out.println("Year is: "+yr);
          // Thread.sleep(3000);
        }
        List<WebElement> dates=driver.findElements(By.xpath("//*[@data-handler='selectDay']/a"));

        for(WebElement ele: dates){
            if(ele.getText().equals(date)) {
                ele.click();
                break;
            }

        }
        Thread.sleep(5000);
        System.out.println("Date is: "+dateField.getText());

        driver.close();
    }

    public static WebElement explicitWaitMethod(WebDriver edriver, int timeout, By locator){
        WebDriverWait myWait= new WebDriverWait(edriver, Duration.ofSeconds(timeout));
        WebElement ele= myWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return ele;

    }
}
