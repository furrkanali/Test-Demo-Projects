package org.epias.Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class EpiasWebPage {
    public WebDriver driver;

    public EpiasWebPage (WebDriver driver){
        this.driver = driver;
    }

    public void getConsumePage(){
        driver.navigate().back();
        driver.findElement(By.xpath("//a[contains(text(),'ELEKTRİK TÜKETİM')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Gerçekleşen Tüketim')]")).click();
        driver.findElement(By.cssSelector("a[href='/transparency/tuketim/gerceklesen-tuketim/gercek-zamanli-tuketim.xhtml']")).click();
    }

    public void getEpiasPage(){
        driver.get("https://seffaflik.epias.com.tr/transparency/");
        driver.manage().window().maximize();
    }
    public String isPageDisplayed(){
        return driver.getTitle();
    }


    public void getProductPage(){
        driver.findElement(By.xpath("//a[contains(text(),'ELEKTRİK ÜRETİM')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Gerçekleşen Üretim')]")).click();
        driver.findElement(By.cssSelector("a[href='/transparency/uretim/gerceklesen-uretim/gercek-zamanli-uretim.xhtml']")).click();
    }

    public  void setDate(int year,int month,int day) {
        WebElement monthSelector = driver.findElement(By.className("ui-datepicker-month"));
        Select monthDropdown = new Select(monthSelector);
        monthDropdown.selectByIndex(month-1);

        WebElement yearSelector = driver.findElement(By.className("ui-datepicker-year"));
        Select yearDropdown = new Select(yearSelector);
        yearDropdown.selectByIndex(year-2012);

        int count = driver.findElements(By.xpath("(//td[@data-handler='selectDay'])")).size();
        for(int i=0; i<count; i++) {
            String text = driver.findElements(By.xpath("(//td[@data-handler='selectDay'])")).get(i).getText();
            if(text.equalsIgnoreCase(day+"")) {
                driver.findElements(By.xpath("(//td[@data-handler='selectDay'])")).get(i).click();
                break;
            }
        }}


    public Double [] getTableValues(int day, int month, int year){


        WebDriverWait w = new WebDriverWait(driver,10);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[5]/form/div[1]/div/div/div[1]/div[2]/span/input")).click();

        setDate(year,month,day);
        driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        int count1 = driver.findElements(By.xpath("//table/tbody/tr")).size();
        System.out.println("Number Of Rows = "+count1);
        String first_part = "//table/tbody/tr[";
        String second_part = "]/td[3]";

        Double[] values = new Double[24];

        for (int j=0; j<count1; j++){
            String finalXpath = first_part+(j+1)+second_part;
            String value=driver.findElement(By.xpath(finalXpath)).getText();
            value=value.replace(".","");
            value=value.replace(',', '.');

            values [j] = Double.parseDouble(value);
        }

        return values;

    }


    public void checkNuance(Double arr1[], Double arr2[]){
        for(int i = 0; i<arr1.length; i++){
            System.out.println(arr2[i] - arr1[i]);
        }
    }










}
