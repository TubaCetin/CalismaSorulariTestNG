import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Kanal7iFrameTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void kanalYedi(){
        driver.get("https://translate.google.com/");

        driver.findElement(By.xpath("//a[@aria-label='Google apps']")).click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@role='presentation']")));

        driver.findElement(By.xpath("//span[@pid='36']")).click();



    }

    @AfterClass
    public void tearDown(){
        //driver.close();
    }
}
