import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;
/*
1. https://www.amazon.com/ adresine gidin
2. softassert kullanarak amazon websitesine gittiginizi dogrulayin
3. kategori dropdown'indan Books kategorisini secin
    arama kutusuna history yazdirip aratin
4. cikan kitaplardan 2. ve 5. kitabin isminde History kelimesinin gectigini dogrulayin
5. cikan sonuc sayisinin 50000'den buyuk oldugunu dogrulayin
 */
public class AmazonHomeWork {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void test(){
        //1. https://www.amazon.com/ adresine gidin
        driver.get("https://amazon.com");

        //2. softassert kullanarak amazon websitesine gittiginizi dogrulayin
        SoftAssert softAssert = new SoftAssert();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com/";
            softAssert.assertEquals(actualUrl, expectedUrl, "Site amazon.com degildir");

        //3. kategori dropdown'indan Books kategorisini secin
        Select dropDown = new Select(driver.findElement(By.xpath("//select[@id='searchDropdownBox']")));
        dropDown.selectByVisibleText("Books");
        //    arama kutusuna history yazdirip aratin
        String arananKelime = "history";
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(arananKelime + Keys.ENTER);

        //4. cikan kitaplardan 2. ve 5. kitabin isminde History kelimesinin gectigini dogrulayin
        String ikinciKitap = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]")).getText();
        String besinciKitap = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[5]")).getText();
        String expectedWord = "History";
        softAssert.assertTrue(ikinciKitap.contains(expectedWord) && besinciKitap.contains(expectedWord));

        //5. cikan sonuc sayisinin 50000'den buyuk oldugunu dogrulayin
        String result = driver.findElement(By.xpath("//span[@dir='auto']")).getText();

        String resultExceptLetters = result.substring(6);
        System.out.println(resultExceptLetters);
        resultExceptLetters = resultExceptLetters.replaceAll("\\D", "");
            int actualResult = Integer.parseInt(resultExceptLetters);
            softAssert.assertTrue(actualResult>50000, "XD");

            softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(){
        //driver.close();
    }
}
