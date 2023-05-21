package mentor;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Q02_facebook {
    //TC 1: Facebook dropdown verification
    //1. Open chrome browser
    //2. Go to “https://www.facebook.xn--com-9o0a
    //3. Verify:
    //● month dd has 12 month options
    //● day dd has 31 day options
    //● year dd has 115 year options
    //4. Select your date of birth
    //5. Quit browser
    @Test
    public void facebookTest () {
        //1. Open chrome browser
        //2. Go to “https://www.facebook.com/
        Driver.getDriver().get(ConfigReader.getProperty("faceUrl"));
        FacebookPage facebookPage = new FacebookPage();
        facebookPage.cookiesAcceptButton.click();
        facebookPage.hesapOlusturButonu.click();

        //3. Verify:
        //● month dd has 12 month options
        Select select = new Select(facebookPage.hesapOlusturAySelectMenu);
        int actualMonthSize = select.getOptions().size();
        int expectedMonthSize = 12;
        Assert.assertEquals(actualMonthSize, expectedMonthSize);

        //● day dd has 31 day options
        select = new Select(facebookPage.hesapOlusturGunSelectMenu);
        int actualDaySize = select.getOptions().size();
        int expectedDaySize = 31;
        Assert.assertEquals(actualDaySize, expectedDaySize);

        //● year dd has 115 year options
        select = new Select(facebookPage.hesapOlusturYilSelectMenu);
        int actualYearSize = select.getOptions().size();
        int expectedYearSize = 119;
        Assert.assertEquals(actualYearSize, expectedYearSize);

        //4. Select your date of birth
        facebookPage.hesapOlusturGunSelectMenu.sendKeys("1");
        facebookPage.hesapOlusturAySelectMenu.sendKeys("Kas");
        facebookPage.hesapOlusturYilSelectMenu.sendKeys("1985");
        ReusableMethods.bekle(2);

        //5. Quit browser
        Driver.quitDriver();


    }

}
