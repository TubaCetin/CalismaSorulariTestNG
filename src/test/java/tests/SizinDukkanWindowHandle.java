package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class SizinDukkanWindowHandle extends TestBase {

    @Test
    public void test() throws InterruptedException {
        // https://www.sizindukkan.com/genc-bebek-odasi/dark-point-genc-odasi sitesine gidin
        driver.get("https://www.sizindukkan.com/genc-bebek-odasi/dark-point-genc-odasi");

        Actions action = new Actions(driver);

        //yukaridaki facebook logosuna tiklayin
        driver.findElement(By.xpath("//li[@class='menu-item top-menu-item top-menu-item-4 icon-only']")).click();

        //ilk sekmenin handle'ini alalim
        String firstWindowHandle = driver.getWindowHandle();
        String secondWindowHandle = "";
        String thirdWindowHandle = "";
        //Tum sekmelerin handle'larini alalim
        Set<String> allHandles = driver.getWindowHandles();
        for (String w: allHandles) {
            if(!w.equals(firstWindowHandle)){
                secondWindowHandle = w;
            }
        }

        driver.switchTo().window(secondWindowHandle);
        String secondTitle = driver.getTitle();
        System.out.println(secondTitle);


        driver.findElement(By.xpath("(//span[@title])[2]")).click();

        Set<String> allHandles2 = driver.getWindowHandles();
        for(String w : allHandles2){
            if(!w.equals(firstWindowHandle) && !w.equals(secondWindowHandle)){
                thirdWindowHandle = w;
            }
        }
        driver.switchTo().window(thirdWindowHandle);

        driver.switchTo().window(thirdWindowHandle);
        String title = driver.getTitle();
        System.out.println(title);

        //driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@frameborder='0'])[1]")));
        driver.switchTo().frame(0);

        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@aria-label='Play']")).click();
        Thread.sleep(10000);
        driver.switchTo().defaultContent();

        driver.switchTo().window(firstWindowHandle);
        String firstTitle = driver.getTitle();
        System.out.println(firstTitle);







    }
}
/*
Actions action = new Actions(driver);

        action.moveToElement(driver.findElement(By.xpath("(//span[@class='links-text'])[10]"))).clickAndHold();
        Thread.sleep(5000);
 */