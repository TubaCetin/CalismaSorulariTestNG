import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*
Our use-case would follow the steps below-

Launch the browser.
Open “https://demoqa.com/select-menu.”
Select the Old Style Select Menu using the element id.
Print all the options of the dropdown.
Select ‘Purple’ using the index.
After that, select ‘Magenta’ using visible text.
Select an option using value.
Close the browser
 */
public class DemoQADropDown {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void test() throws InterruptedException {
        //go https://demoqa.com/select-menu.
        driver.get("https://demoqa.com/select-menu");

        //Select the Old Style Select Menu using the element id.
        Select oldSelectMenu = new Select(driver.findElement(By.id("oldSelectMenu")));

        //Print all the options of the dropdown.
        List<WebElement> allListElements = oldSelectMenu.getOptions();
            for(WebElement w: allListElements){
                System.out.println(w.getText());
            }

            //Select ‘Purple’ using the index.
        oldSelectMenu.selectByIndex(4);
            Thread.sleep(4000);

        //After that, select ‘Magenta’ using visible text.
        oldSelectMenu.selectByVisibleText("Magenta");

        //Select an option using value.
        oldSelectMenu.selectByValue("10");

        //MultiSelect drop down


    }

    @AfterMethod
    public void tearDown(){
        //driver.close();
    }

}
