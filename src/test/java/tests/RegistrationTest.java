package tests;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.RegistrationPage;
import suite.SuiteManager;
import util.ConfigFileReader;
import util.DriverManager;

import java.util.Locale;

public class RegistrationTest extends SuiteManager {

    public BasePage base;
    public LoginPage login;
    public RegistrationPage registrationPage;
    public ConfigFileReader config = new ConfigFileReader();

    @Test(priority = 0)
    public void registerTitleCheck()
    {
        base = new BasePage();
        login = base.clickSignIn();
        registrationPage = login.createNewAccount();

        String expRegPagTitle = "Amazon Registration";
        String actRegPagTitle = DriverManager.driver.getTitle();
        Assert.assertEquals(expRegPagTitle, actRegPagTitle, "New user registration page title verification Unsuccessful!");
        System.out.println("User registration title verified!");
    }

    @Test(priority = 1)
    public void verifyDefaultCountryTeleCode()
    {
        String expDefCode = config.getProperty("india_phone_code");
        String actDefCode = registrationPage.countryTeleCode();
        Assert.assertEquals(expDefCode,actDefCode,"The country Telephone Code is not shown by default!");
        System.out.println("The country Telephone code is shown by default!");
    }
/*
    @Test(priority = 2)
    public void verifyPasswordHintText() throws InterruptedException {
        Thread.sleep(3000);
        String expPassHintText = config.getProperty("password_hint_text");
        String actPassHintText = registrationPage.passwordHintText();
        Assert.assertEquals(expPassHintText,actPassHintText, "Password Help Text is Not visible!");
        System.out.println("Password help text is visible!");
    }

*/
}
