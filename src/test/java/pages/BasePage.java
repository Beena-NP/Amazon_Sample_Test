package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import suite.SuiteManager;
import util.DriverManager;

public class BasePage extends SuiteManager {

    @FindBy(xpath="//a[@id='nav-link-accountList']")
    private WebElement signIn;
    @FindBy(xpath = "//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][contains(text(),'Sign in')]")
    private WebElement signInBtn;
    /*
    @FindBy(xpath = "//span[@class='nav-sprite nav-logo-base']")
    private WebElement heading;

   */

    public BasePage()
     {
         PageFactory.initElements(DriverManager.driver, this);
     }
    public LoginPage clickSignIn()
     {
         WebDriverWait wait = new WebDriverWait(DriverManager.driver,20);
         wait.until(ExpectedConditions.elementToBeClickable(signIn));
         signIn.click();
         WebDriverWait waitT = new WebDriverWait(DriverManager.driver,30);
         waitT.until(ExpectedConditions.visibilityOf(signInBtn));
         signInBtn.click();
         return new LoginPage();
     }




}
