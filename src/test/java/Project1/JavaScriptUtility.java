package Project1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility {

    public static void JavaScriptDrawBorder(WebElement element, WebDriver ldriver){
        JavascriptExecutor js= (JavascriptExecutor) ldriver;
        js.executeScript("arguments[0].style.border='3px solid green'",element);
    }

    public static String getTitleOfPage(WebDriver ldriver){
        JavascriptExecutor js= (JavascriptExecutor) ldriver;
        String pageName=js.executeScript("return document.title;").toString();
        return pageName;
    }

    public static void clickElementByJS(WebDriver ldriver, WebElement ele){
        JavascriptExecutor js=(JavascriptExecutor) ldriver;
        js.executeScript("arguments[0].click();",ele);
    }
    public static void generateAlert(WebDriver ldriver, String msg){
        JavascriptExecutor js=(JavascriptExecutor) ldriver;
        js.executeScript("alert('" + msg+ "')");
    }

    public static void refreshBrowserByJS(WebDriver ldriver){
        JavascriptExecutor js=(JavascriptExecutor) ldriver;
        js.executeScript("history.go(0)");
    }
    public static void scrollDownByJS(WebDriver ldriver){
        JavascriptExecutor js= (JavascriptExecutor) ldriver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public static void scrollUpByJS(WebDriver ldriver){
        JavascriptExecutor js= (JavascriptExecutor) ldriver;
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
    }

    public static void zoomPage(WebDriver ldriver){
        JavascriptExecutor js=(JavascriptExecutor) ldriver;
        js.executeScript("document.body.style.zoom='150%'");
    }

    public static void flashByJs(WebDriver ldriver, WebElement ele){
      //  JavascriptExecutor js=(JavascriptExecutor) ldriver;
        String bgcolor= ele.getCssValue("backgroundColor");
        for(int i=0; i<10;i++){
            colourChange("#000000",ldriver,ele);
            colourChange(bgcolor,ldriver,ele);
        }
    }

    public static void colourChange(String color, WebDriver rdriver,WebElement elements){
        JavascriptExecutor js=(JavascriptExecutor) rdriver;
        js.executeScript("arguments[0].style.backgroundColor='"+ color +"'", elements);

    }

}
