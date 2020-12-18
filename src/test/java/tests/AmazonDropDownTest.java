package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AmazonDropDownTest {
    /*

    1- "https://www.amazon.com/" adresine gidin
    2- 0. indexi alin ve yazdirin
    2- Search box a "Playstation 4" yazin
    3- "Sort by Featured" dropdown a tiklayin
    4- 1. indexi alin ve yazdirin
    5-

     */

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
    }
    @Test
    public void AmazonDropDown(){

        Select dropdownlist=new Select(driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']")));
        dropdownlist.selectByIndex(0);
        System.out.println(dropdownlist.getFirstSelectedOption().getText());
       driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Playstation 4"+ Keys.ENTER);
        Select dropdownlist2=new Select(driver.findElement(By.xpath("//select[@id='s-result-sort-select']")));
        dropdownlist2.selectByIndex(1);
        System.out.println(dropdownlist2.getFirstSelectedOption().getText());
        WebElement yazi= driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'][1]"));
        Assert.assertTrue(yazi.isDisplayed());




    }

    @AfterMethod
    public void tearDown(){
        driver.close();


    }




}
