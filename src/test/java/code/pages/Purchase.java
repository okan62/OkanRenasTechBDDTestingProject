package code.pages;

import code.utils.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Purchase extends BrowserUtils {
        public Purchase(){
            PageFactory.initElements(driver,this);
        }
        @FindBy(id = "card_nmuber")
        private WebElement cardNumber;
        @FindBy(id = "month")
        private WebElement month;
        @FindBy(id = "year")
        private WebElement year;
        @FindBy(id = "cvv_code")
        private WebElement cvvCode;
        @FindBy(xpath = "//input[@type='submit']")
        private WebElement payButton;
        @FindBy(xpath = "//h2[contains(text(),'Payment successfull!')]")
        private WebElement paymentVerification;

        public void setCardNumber(String CardNumber){
            staticWait(1);
            cardNumber.sendKeys(CardNumber);
        }
        public void setMonth(String Month){
            staticWait(1);
            month.sendKeys(Month);
        }
        public void setYear(String Year){
            staticWait(1);
            year.sendKeys(Year);
        }
        public void setCvvCode(String CVVCODE){
            staticWait(1);
            cvvCode.sendKeys(CVVCODE);
        }
        public void setPayButton(){
            staticWait(1);
            payButton.click();
    }
        public void setPaymentVerification(String PaymentVerification){
            Assert.assertEquals(paymentVerification.getText(),PaymentVerification);
            System.out.println("Payment SUCCESSFUL!!!");
        }

}
