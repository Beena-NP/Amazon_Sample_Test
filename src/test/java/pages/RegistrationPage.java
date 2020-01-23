package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import suite.SuiteManager;
import util.DriverManager;

public class RegistrationPage extends SuiteManager {

    @FindBy(xpath = "//input[@id='ap_customer_name']")
    private WebElement name;
    @FindBy(xpath = "//span[@class='a-dropdown-prompt']")
            //span[@class='a-button-text a-declarative']
    public WebElement countryCode;
    @FindBy(xpath = "//input[@id='ap_phone_number']")
    private WebElement phone;
    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement optionalEmail;
    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement password;
    @FindBy(xpath = "//input[@id='continue']")
    private WebElement cont;
    @FindBy(xpath = "//div[@class=\"a-alert-content\" and contains(text(),'Passwords must be at least 6 characters.')]")
            //"//div[@class=\"a-alert-content\" and text()=\"Passwords must be at least 6 characters.\"]"
    public WebElement passHint;

////div[@class='a-box a-alert-inline a-alert-inline-info auth-inlined-information-message a-spacing-top-mini']//div[@class='a-alert-content'][contains(text(),'Passwords must be at least 6 characters.')]
    public RegistrationPage()
    {
        PageFactory.initElements(DriverManager.driver,this);
    }
    public void enterDetails(WebElement field, String value)
    {
        field.click();
        field.clear();
        field.sendKeys(value);
    }
    public String countryTeleCode()
    {
        //String code = String.valueOf(countryCode);
        //enterDetails(countryCode,code);
        //WebDriverWait wait = new WebDriverWait(DriverManager.driver,30);
        //wait.until(ExpectedConditions.visibilityOf(countryCode));
        String text = countryCode.getText();
        System.out.println("Country telephone code text is  "+text);
        return text;

    }
    public String passwordHintText()
    {
        String hint = passHint.getText();
        System.out.println("Password hint text is  "+hint);
        return hint;
    }

}
