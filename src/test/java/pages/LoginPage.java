package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import suite.SuiteManager;
import util.DriverManager;

public class LoginPage extends SuiteManager {
    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement email;
    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueBtn;
    @FindBy(xpath = "//a[@id='createAccountSubmit']")
    private WebElement createAcnt;

    public LoginPage()
    {
        PageFactory.initElements(DriverManager.driver,this);
    }
    public void enterDetails(WebElement field, String value)
    {
        field.click();
        field.clear();
        field.sendKeys(value);
    }
    public SignInPage enterEmailAndCont(String emailId)
    {
        enterDetails(email, emailId);
        continueBtn.click();
        return new SignInPage();
    }
    public RegistrationPage createNewAccount()
    {
        createAcnt.click();
        return new RegistrationPage();
    }

}
