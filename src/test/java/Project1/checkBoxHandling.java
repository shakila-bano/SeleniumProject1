package Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class checkBoxHandling {

    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Check 1 item from the checkbox

        /*WebElement check1= driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[0]")); //select 1st checkbox
        System.out.println("testing test123 -------");
        check1.click();*/

        System.out.println("testing test -------");
       // check1.clear();     clear the selection
        System.out.println("testing test 6786-------");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> multicheck = driver.findElements(By.xpath("//*[@id='checkboxes']/input"));
        System.out.println("testing test size-------"+multicheck.size());

        for(WebElement opt:multicheck){
            System.out.println("item is:"+opt.getText());
            opt.click();
        }
    }
}
