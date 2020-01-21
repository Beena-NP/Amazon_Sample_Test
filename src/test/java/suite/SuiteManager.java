package suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import util.ConfigFileReader;
import util.DriverManager;

public class SuiteManager {

    DriverManager driverManager;
    ConfigFileReader config = new ConfigFileReader();

    @BeforeSuite(alwaysRun = true)
    public void startDriver()
    {
        driverManager = new DriverManager();
    }
    @AfterSuite(alwaysRun = true)
    public void quitDriver()
    {
        driverManager.driver.quit();
    }
    @BeforeClass
    public void launchUrl()
    {
        String url = config.getProperty("base_url");
        driverManager.driver.manage().window().maximize();
        driverManager.driver.get(url);
    }




}
