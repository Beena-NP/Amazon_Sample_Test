package tests;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.SignInPage;
import suite.SuiteManager;
import util.ConfigFileReader;

public class LoginTest extends SuiteManager {

    public BasePage base;
    public LoginPage login;
    public SignInPage sign;
    public ConfigFileReader config = new ConfigFileReader();

    @Test(priority = 0)
    public void loginToAmazon()
    {
        base = new BasePage();
        login = base.clickSignIn();
        String userId = config.getProperty("username");
        sign = login.enterEmailAndCont(userId);
    }

}
