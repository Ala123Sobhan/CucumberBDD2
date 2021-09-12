package stepdef;


import base.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.Assert;
import pageObject.SignInPageObject;

public class signin extends Config {

    SignInPageObject si = new SignInPageObject(driver);

    @Given("I am at talenttek Home Page")
    public void iAmAtTalenttekHomePage() {
        Assert.assertEquals(driver.getTitle(), "Sign In");
    }

    @And("I click on  Create New Account button")
    public void iClickOnCreateNewAccountButton() {
        si.clickCreateNewAccBtn();
    }
}
