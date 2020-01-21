package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.DriverManager;

public class SignInPage {
    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement password;
    @FindBy(xpath = "//input[@id='signInSubmit']")
    private WebElement loginBtn;
    @FindBy(xpath = "//a[@id='auth-fpp-link-bottom']")
    private WebElement forgotPasswd;

    public SignInPage()
    {
        PageFactory.initElements(DriverManager.driver,this);
    }



}
