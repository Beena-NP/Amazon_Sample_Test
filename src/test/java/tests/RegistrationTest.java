package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import suite.SuiteManager;
import util.DriverManager;

public class RegistrationTest extends SuiteManager {

    public RegistrationPage registrationPage;

    @Test(priority = 0)
    public void verifyCountryCode()
    {
        registrationPage = new RegistrationPage();
        WebElement indiaCode = DriverManager.driver.findElement((By) registrationPage.countryCode);
        String code = indiaCode.getText();
        System.out.println("The country code is  "+code);
        String expCode = "IN +91";
        Assert.assertEquals(code,expCode,"The country code is displayed by default!");
    }

    @Test(priority = 1)
    public void passwordHintCheck()
    {
        WebElement hintPass = DriverManager.driver.findElement((By) registrationPage.passHint);
        String passHintText = hintPass.getText();
        String actualText = "Passwords must be at least 6 characters.";
        Assert.assertEquals(passHintText, actualText, "Password Help Text is visible!");
    }

}
