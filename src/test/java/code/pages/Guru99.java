package code.pages;

import code.utils.BrowserUtils;
import code.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Guru99 extends BrowserUtils {
    public Guru99(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h2")
    private WebElement verification;
    @FindBy(xpath = "//h3")
    private WebElement toyPrice;
    @FindBy(xpath = "//select")
    private WebElement quantity;
    @FindBy (xpath = "//input[@type='submit']")
    private WebElement submit;

    public void setVerification(String expected){
        Assert.assertEquals(verification.getText(),expected);
        System.out.println("Verification Successful!!!");
    }
    public void setToyPrice(String price)
    {
        Assert.assertEquals(toyPrice.getText(),price);
        System.out.println("Toy Price Verification Successful!!!");
    }
    public void urlVerification(String expectedUrl){
        Driver.getDriver();
        String actual=driver.getCurrentUrl();
        if(actual.contains(expectedUrl)){
            System.out.println("URL verification PASSED!!!");
        }else
            System.out.println("URL Verification FAILED!!!");
    }
    public void setQuantity(String sum){
        Select select=new Select(quantity);
        select.selectByVisibleText(sum);
    }
    public void setSubmit(){
        BrowserUtils.staticWait(1);
        submit.click();
    }

}
