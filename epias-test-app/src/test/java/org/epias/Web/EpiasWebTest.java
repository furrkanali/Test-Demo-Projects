package org.epias.Web;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EpiasWebTest extends WebTestBase{
    EpiasWebPage epiasWebPage;
    @Test
    public void epiasTest(){
        epiasWebPage = new EpiasWebPage(driver);

        epiasWebPage.getEpiasPage();
        Assert.assertEquals(epiasWebPage.isPageDisplayed(),
                "EPİAŞ ŞEFFAFLIK PLATFORMU - ANASAYFA",
                "Page is not opened");


        epiasWebPage.getProductPage();
        Double [] arr = epiasWebPage.getTableValues(30,04,2021);

        epiasWebPage.getConsumePage();
        Double [] arr2 = epiasWebPage.getTableValues(30,04,2021);

        epiasWebPage.checkNuance(arr, arr2);


    }


}
