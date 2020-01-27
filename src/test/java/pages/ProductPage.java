package pages;

import org.openqa.selenium.support.PageFactory;
import suite.SuiteManager;
import util.DriverManager;

public class ProductPage extends SuiteManager {

    public ProductPage()
    {
        PageFactory.initElements(DriverManager.driver,this);
    }

}
