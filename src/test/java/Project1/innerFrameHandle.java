package Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class innerFrameHandle {
    public static void main(String[] args){

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");

        driver.switchTo().frame("iframeResult");
        System.out.println("Inside the frame");
        WebElement innerframe= driver.findElement(By.xpath("//*[@src='https://www.w3schools.com']"));
        driver.switchTo().frame(innerframe);
        System.out.println("Inside the inner frame");
        WebElement ele = driver.findElement(By.xpath("//*[@id=\"subtopnav\"]/a[1]"));
        ele.click();
        System.out.println("HTML tab is clicked");

    }
}
