package org.epias.Web;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class WebTestBase {
    public static WebDriver driver;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @AfterTest
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

}
