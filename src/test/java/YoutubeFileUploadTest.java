import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class YoutubeFileUploadTest extends Utilities{


    @Test
    public void test() throws InterruptedException {
        Actions actions = new Actions(driver);
        // youtube.com'a gidin
        driver.get("https://youtube.com");

        // sign-in butonuna basin
        driver.findElement(By.xpath("(//paper-button[@id='button'])[2]")).click();

        //email text box'ina mail adresinizi yazin
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("esahinjira@gmail.com" + Keys.ENTER);
        Thread.sleep(3000);

        //pw text box'ina sifresnizi giriniz
        WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordBox.sendKeys("Bekoabe05" + Keys.ENTER);


        //kanal olustura gelin ve tiklaiyn
        WebElement kanalOlustur = driver.findElement(By.xpath("(//yt-icon[@class=\"style-scope ytd-topbar-menu-button-renderer\"])[1]"));
        kanalOlustur.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//yt-formatted-string[@id='label'])[1]")).click();
        Thread.sleep(3000);

        String homePath = System.getProperty("user.home");
        String filePath = homePath + "\\Desktop\\fyasar.mp4";
        WebElement videoUpload = driver.findElement(By.xpath("(//div[@class=\"label style-scope ytcp-button\"])[13] "));
        Thread.sleep(3000);
        videoUpload.sendKeys(filePath);




    }
}
