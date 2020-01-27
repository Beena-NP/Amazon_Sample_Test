package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import suite.SuiteManager;
import util.DriverManager;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends SuiteManager {
    @FindBy(xpath = "//ul[@class='a-pagination']")
    private List<WebElement> pagination;


    @FindBy(xpath = "//body[@class='a-aui_157141-c a-aui_158613-t1 a-aui_72554-c a-aui_dropdown_187959-c a-aui_pci_risk_banner_210084-c a-aui_perf_130093-c a-aui_tnr_v2_180836-c a-aui_ux_145937-c a-meter-animate']/div[@id='a-page']/div[@id='search']/div[@class='s-desktop-width-max s-desktop-content sg-row']/div[@class='sg-col-20-of-24 sg-col-28-of-32 sg-col-16-of-20 sg-col s-right-column sg-col-32-of-36 sg-col-8-of-12 sg-col-12-of-16 sg-col-24-of-28']/div[@class='sg-col-inner']/span[4]")
 /*
    //body[@class='a-aui_157141-c a-aui_158613-t1 a-aui_72554-c a-aui_dropdown_187959-c a-aui_pci_risk_banner_210084-c a-aui_perf_130093-c a-aui_tnr_v2_180836-c a-aui_ux_145937-c a-meter-animate']/div[@id='a-page']/div[@id='search']/div[@class='s-desktop-width-max s-desktop-content sg-row']/div[@class='sg-col-20-of-24 sg-col-28-of-32 sg-col-16-of-20 sg-col s-right-column sg-col-32-of-36 sg-col-8-of-12 sg-col-12-of-16 sg-col-24-of-28']/div[@class='sg-col-inner']/span[4]
//body[@class='a-aui_157141-c a-aui_158613-t1 a-aui_72554-c a-aui_dropdown_187959-c a-aui_pci_risk_banner_210084-c a-aui_perf_130093-c a-aui_tnr_v2_180836-c a-aui_ux_145937-c a-meter-animate']/div[@id='a-page']/div[@id='search']/div[@class='s-desktop-width-max s-desktop-content sg-row']/div[@class='sg-col-20-of-24 sg-col-28-of-32 sg-col-16-of-20 sg-col s-right-column sg-col-32-of-36 sg-col-8-of-12 sg-col-12-of-16 sg-col-24-of-28']/div[@class='sg-col-inner']/span[4]
    body.a-aui_157141-c.a-aui_158613-t1.a-aui_72554-c.a-aui_dropdown_187959-c.a-aui_pci_risk_banner_210084-c.a-aui_perf_130093-c.a-aui_tnr_v2_180836-c.a-aui_ux_145937-c.a-meter-animate:nth-child(2) div.s-desktop-container:nth-child(22) div.s-desktop-width-max.s-desktop-content.sg-row:nth-child(6) div.sg-col-20-of-24.sg-col-28-of-32.sg-col-16-of-20.sg-col.s-right-column.sg-col-32-of-36.sg-col-8-of-12.sg-col-12-of-16.sg-col-24-of-28 div.sg-col-inner > span.rush-component.s-latency-cf-section:nth-child(5)
 */
    private WebElement productTitle;
    public SearchPage()
    {
        PageFactory.initElements(DriverManager.driver,this);
    }

    public void enterDetails(WebElement field, String value)
    {
        field.click();
        field.clear();
        field.sendKeys(value);
    }
    public void searchPagination()
    {
        WebDriverWait wait = new WebDriverWait(DriverManager.driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("ul")));
        pagination = new ArrayList<>();
        int size = pagination.size();
        if(size>0)
        {
            System.out.println("Pagination exists and the size is  "+size);
            for(WebElement pages: pagination)
            {
                pagination.add(pages);
            }
            for(int i=0; i<size; i++)
            {
                String title = pagination.get(i).getAttribute("title");
                if(title.equals("Next"))
                {
                    pagination.get(i).click();
                    break;
                }
            }

        }
    }
    public ProductPage productClick()
    {
        productTitle.click();
        return new ProductPage();
    }// db : https://www.guru99.com/database-testing-using-selenium-step-by-step-guide.html

}
