package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import suite.SuiteManager;
import util.DriverManager;

public class BasePageTest extends SuiteManager {
    public BasePage base;

    @Test(priority = 0)
    public void titleCheck()
    {
        base = new BasePage();

        String expHeading = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        String actHeading = DriverManager.driver.getTitle();
        Assert.assertEquals(expHeading,actHeading);
        System.out.println("Heading verification successful!");

    }
}
