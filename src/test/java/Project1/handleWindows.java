package Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class handleWindows {

    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();

        Set<String> winId=driver.getWindowHandles();
        List<String> winIdList=new ArrayList (winId);

        for (String wins:winIdList){
            System.out.println("window id is: "+wins);
            String title= driver.switchTo().window(wins).getTitle();//use to swtich from 1 window to another
            //

            System.out.println("Title is: "+title);
        }


    }






}
