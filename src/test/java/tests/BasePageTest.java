package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.SearchPage;
import suite.SuiteManager;
import util.ConfigFileReader;
import util.DriverManager;

public class BasePageTest extends SuiteManager {
    public BasePage base;
    ConfigFileReader config = new ConfigFileReader();

    @Test(priority = 0)
    public void titleCheck()
    {
        base = new BasePage();

        String expHeading = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        String actHeading = DriverManager.driver.getTitle();
        Assert.assertEquals(expHeading,actHeading);
        System.out.println("Heading verification successful!");

    }
    @Test(priority = 1)
    public void verifySearchCategories()
    {
        base.searchCategories();
    }

    @Test(priority = 2)
    public SearchPage verifySearch()
    {
        String item = config.getProperty("search_item");
        base.searchItems(item);
        System.out.println("Search item entered and clicked on the search button!");
        return new SearchPage();
    }


}
