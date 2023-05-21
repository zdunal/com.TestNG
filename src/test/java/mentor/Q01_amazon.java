package mentor;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class Q01_amazon {
    //TC 1: Amazon link count:
    //1. Open chrome browser
    //2. Go to “https://www.amazon.com/”
    //3. Get all links
    //4. Get number of links that has text
    //5. Print to console only the links that has text

    @Test
    public void amazonTest () {
        //1. Open chrome browser
        //2. Go to “https://www.amazon.com/”
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //3. Get all links
        AmazonPage amazonPage = new AmazonPage();
        System.out.println(amazonPage.linksElementList.size());
        //4. Get number of links that has text
        int textOlanLinkSayisi = amazonPage.textOlanLinklerListesi.size();
        //5. Print to console only the links that has text
        System.out.println(textOlanLinkSayisi);

        Driver.closeDriver();
    }
}
