package org.epias.Mobile;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.epias.Mobile.TestBase.MobileTestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.logging.Level;

public class MobileTest  extends MobileTestBase {


    @Test
    public void checkPtfTest() throws MessagingException {
        driver.findElement(By.xpath("//*[@id='fragmentHome_imageView_menu']")).click();
        driver.findElement(By.xpath("//*[@text='Piyasalar']")).click();
        driver.findElement(By.xpath("//*[@text='Piyasa Takas Fiyatı']")).click();
        new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='layoutEpiasTopSelectionView_imageViewDate']")));
        driver.findElement(By.xpath("//*[@id='layoutEpiasTopSelectionView_imageViewDate']")).click();
        new TouchAction(driver).press(PointOption.point(185,627)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(328))).moveTo(PointOption.point(208,1100)).release().perform();
        // new TouchAction(driver).press(180, 591).waitAction(Duration.ofMillis(280)).moveTo(176, 736).release().perform();
        // new TouchAction(driver).press(180, 644).waitAction(Duration.ofMillis(261)).moveTo(180, 685).release().perform();
        new TouchAction(driver).press(PointOption.point(378,744)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(192))).moveTo(PointOption.point(368,653)).release().perform();
        new TouchAction(driver).press(PointOption.point(542,646)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(274))).moveTo(PointOption.point(538,731)).release().perform();
        driver.findElement(By.xpath("//*[@text='Tamam']")).click();

        String ptfAvarage = driver.findElement(By.xpath("//*[@text='50,47']")).getText();


    }


}