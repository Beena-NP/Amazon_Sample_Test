package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import suite.SuiteManager;
import util.DriverManager;

import java.util.ArrayList;
import java.util.List;

public class BasePage extends SuiteManager {

    @FindBy(xpath="//a[@id='nav-link-accountList']")
    private WebElement signIn;
    @FindBy(css = "span.nav-action-inner")
         //   "//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][contains(text(),'Sign in')]")
    private WebElement signInBtn;
    @FindBy(id = "searchDropdownBox")
    private WebElement searchCategories;
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;
    @FindBy(xpath = "//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")
    private WebElement searchBtn;


    public BasePage()
     {
         PageFactory.initElements(DriverManager.driver, this);
     }
     public void enterDetails(WebElement field, String value)
     {
         field.click();
         field.clear();
         field.sendKeys(value);
     }
    public LoginPage clickSignIn()
     {
         /*
         WebDriverWait wait = new WebDriverWait(DriverManager.driver,20);
         wait.until(ExpectedConditions.elementToBeClickable(signIn));
         signIn.click();
         WebDriverWait waitT = new WebDriverWait(DriverManager.driver,30);
         waitT.until(ExpectedConditions.visibilityOf(signInBtn));
         signInBtn.click();
         */
         Actions actions = new Actions(DriverManager.driver);
         WebElement mainMenu = DriverManager.driver.findElement(By.id("nav-link-accountList"));
                 //((By) signIn);
         actions.moveToElement(mainMenu);
         actions.build().perform();

         WebElement subMenu = DriverManager.driver.findElement(By.cssSelector("span.nav-action-inner"));
                 //((By) signInBtn);
         actions.moveToElement(subMenu);
         actions.click().build().perform();

         return new LoginPage();
     }
     public void searchCategories()
     {
         Select selCategory = new Select(searchCategories);
         List<WebElement> categoryOptions = selCategory.getOptions();
         int size = categoryOptions.size();
         System.out.println("Size of the search dropdown list is  "+size);
         if(size>0)
         {
             ArrayList<String> searchOpt = new ArrayList<>();
             for(String e: searchOpt)
             {
                 searchOpt.add(e);
                 System.out.println("The categories are  "+e);
             }
             for(int i=0; i<size; i++)
             {
                 String names = categoryOptions.get(i).getText();
                 System.out.println("Options are  "+names);
             }
         }

     }
     public void searchItems(String itemToSearch)
     {
         enterDetails(searchBox, itemToSearch);
         searchBtn.click();

     }

}
