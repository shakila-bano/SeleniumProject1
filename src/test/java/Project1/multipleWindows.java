package Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class multipleWindows {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Static.html");
        System.out.println("Page title is: "+driver.getTitle());

        // Open the link in new tab
        String tab=Keys.chord(Keys.CONTROL,Keys.RETURN);
        driver.findElement(By.linkText("Practice Site")).sendKeys(tab);
        System.out.println("Page title is: "+driver.getTitle());

        // open the new URL in Tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.bing.com");

        //open the new URL in Window
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
}
