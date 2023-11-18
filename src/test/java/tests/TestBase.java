package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;
import java.time.temporal.ChronoUnit;


public class TestBase {
    public static WebDriver driver;


    @BeforeClass
    @Parameters({"browser"})
    public  void startDriver(@Optional("chrome") String browserName){

        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.of(120, ChronoUnit.SECONDS));
        driver.get("https://demo.nopcommerce.com/");
    }

    @AfterClass
    public void stopDriver(){
        driver.quit();
    }
}
