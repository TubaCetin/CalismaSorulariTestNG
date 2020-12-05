import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*
        1. https://ebay.com'a gidin
        2. ebay'de oldugunuzu dogrulayin
        3. kategori menusunden Cell Phones'u secin
        4. arama kutusuna iphone 12 yazdirin
        5. search butonuna basin
        Test2
        -> birinci test basarili ise;
        1.shipping to menusunden Netherlands - NLD'yi secin
        2. zip code bolumune 9405 yaziniz
        3. go tusuna basiniz
        Test3
        -> ikinci test basarili ise
        1. best match menusunden highest first secenegini secini
        2. renk seceneklerinden "black" seciniz
        3. hafiza seceneklerinden "256 GB" seciniz
        4. ilk urunu secin
        5. color menusunden "black" secin
        6. fiyatini ekrana yazdirin

     */
public class SelectsizSecmeTest_COK_ZOR {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test01() {
        //1. https://ebay.com'a gidin
        driver.get("https://ebay.com");

        //2. ebay'de oldugunuzu dogrulayin
        String expectedUrl = "https://www.ebay.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        //3. kategori menusunden Cell Phones'u secin
        Select categories = new Select(driver.findElement(By.xpath("//select[@class='gh-sb ']")));
        categories.selectByValue("15032");

        //4. arama kutusuna iphone 12 yazdirin
        String arananKelime = "iphone 12";
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(arananKelime);

        // 5. search butonuna basin
        driver.findElement(By.xpath("//input[@type='submit']")).click();

    }

    @Test(dependsOnMethods = "test01")
    public void test02() throws InterruptedException {
        Thread.sleep(3000);
        //1.shipping to menusunden Netherlands - NLD'yi secin
        driver.findElement(By.xpath("(//button[@type='button'])[25]")).click();

        Select locationMenu = new Select(driver.findElement(By.xpath("(//select)[2]")));
        locationMenu.selectByValue("146");

        //2. zip code bolumune 9405 yaziniz
        driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("9405");

        //3. go tusuna basiniz
        driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();

    }

    @Test(dependsOnMethods = "test02")
    public void test03() throws InterruptedException {
        Thread.sleep(3000);
        // 1. best match menusunden highest first secenegini secini

        WebElement buttons = driver.findElement(By.xpath("(//span[@class='expand-btn__cell'])[4]"));
            buttons.click();
        WebElement options = driver.findElement(By.xpath("(//a[@class='fake-menu-button__item'])[5]"));
            options.click();

       /*               Bu sekildede calisabilir
       List<WebElement> buttons = driver.findElements(By.xpath("//span[@class='expand-btn__cell']"));
            buttons.get(3).click();
       List<WebElement> options = driver.findElements(By.xpath("//a[@class='fake-menu-button__item']"));
            options.get(4).click();
        */


    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
