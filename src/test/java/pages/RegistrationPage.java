package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import suite.SuiteManager;
import util.DriverManager;

public class RegistrationPage extends SuiteManager {

    @FindBy(xpath = "//input[@id='ap_customer_name']")
    private WebElement name;
    @FindBy(xpath = "//span[@class='a-dropdown-prompt']")
    public WebElement countryCode;
    @FindBy(xpath = "//input[@id='ap_phone_number']")
    private WebElement phone;
    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement optionalEmail;
    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement password;
    @FindBy(xpath = "//input[@id='continue']")
    private WebElement cont;
    @FindBy(xpath = "//div[@class=\"a-alert-content\" and text()=\"Passwords must be at least 6 characters.\"]")
    public WebElement passHint;

////div[@class='a-box a-alert-inline a-alert-inline-info auth-inlined-information-message a-spacing-top-mini']//div[@class='a-alert-content'][contains(text(),'Passwords must be at least 6 characters.')]
    public RegistrationPage()
    {
        PageFactory.initElements(DriverManager.driver,this);
    }




}
