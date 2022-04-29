package code.stepDefinition;

import code.pages.Guru99;
import code.pages.Purchase;
import code.utils.BrowserUtils;
import code.utils.ConfigurationsReader;
import code.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class Steps extends BrowserUtils {
    Guru99 guru99=new Guru99();
    Purchase purchase=new Purchase();
    @Given("The user wants to see payment gateway website")
    public void the_user_wants_to_see_payment_gateway_website() {
        Driver.getDriver();
        BrowserUtils.setWaitTime();
        driver.get(ConfigurationsReader.getProperties("url"));
        driver.manage().window().maximize();
        System.out.println("The Website launched successfully");
    }

    @When("The user wants to verify message as {string}")
    public void the_user_wants_to_verify_message_as(String expected) {
        guru99.setVerification(expected);
    }
    @When("The user wants to see toy price message as {string}")
    public void the_user_wants_to_see_toy_price_message_as(String price) {
        guru99.setToyPrice(price);
    }
    @When("The user wants to see url contain as {string}")
    public void the_user_wants_to_see_url_contain_as(String string) {
        guru99.urlVerification(string);
    }
    @When("The user wants to buy elephant toy as")
    public void the_user_wants_to_buy_elephant_toy_as(Map<String,String> dataTable) {
        guru99.setQuantity(dataTable.get("Quantity"));
        guru99.setSubmit();
    }
    @Then("The user wants to enter payment information as")
    public void the_user_wants_to_enter_payment_information_as(Map<String,String> dataTable) {
        purchase.setCardNumber(dataTable.get("CNumber"));
        purchase.setMonth(dataTable.get("EMonth"));
        purchase.setYear(dataTable.get("EYear"));
        purchase.setCvvCode(dataTable.get("CVV"));

    }
    @Then("The user wants to pay now")
    public void the_user_wants_to_pay_now() {
        BrowserUtils.staticWait(2);
        purchase.setPayButton();
    }
    @Then("The user wants to see verification message as {string}")
    public void the_user_wants_to_see_verification_message_as(String paymentMessage) {
        purchase.setPaymentVerification(paymentMessage);

    }
    @When("The user wants to buy elephant toy as {string}")
    public void the_user_wants_to_buy_elephant_toy_as(String string) {
        guru99.setQuantity(string);
        guru99.setSubmit();
    }
}
