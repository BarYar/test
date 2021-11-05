import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class SeleniumTest {
    public static void main(String[] args) {
// TODO Auto-generated method stub

//setting the driver executable
        System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");

//Initiating your chromedriver
        WebDriver driver=new ChromeDriver();

//maximize window
        driver.manage().window().maximize();

//open browser with desried URL
        driver.get("https://www.google.com");

//closing the browser
        driver.close();
    }
}
