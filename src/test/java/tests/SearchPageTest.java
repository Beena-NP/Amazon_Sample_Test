package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.SearchPage;
import util.ConfigFileReader;
import util.DriverManager;

public class SearchPageTest {
    public BasePage base;
    public SearchPage search;
    public ConfigFileReader config = new ConfigFileReader();

    @Test(priority = 0)
    public void verifySearchPageTitle()
    {
        base = new BasePage();
        BasePageTest basePageTest = new BasePageTest();
        search = basePageTest.verifySearch();
        String expTitle = config.getProperty("search_page_title");
        String actTitle = DriverManager.driver.getTitle();
        Assert.assertEquals(expTitle,actTitle,"Search page title is incorrect!");
        System.out.println("Search Page Title is  "+expTitle);
    }
    @Test(priority = 1)
    public void verifySearchPagination()
    {
        search.searchPagination();
        String expProName = config.getProperty("product_name");
        String actProName = search.productClick();
        Assert.assertEquals(expProName,actProName,"Product name title is incorrect!");
        System.out.println("Product name title is clicked");
    }

}
