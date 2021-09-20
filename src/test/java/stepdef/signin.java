package stepdef;


import base.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @When("I enter studentID and password")
    public void i_enter_student_id_and_password() {
        si.enterIDAndPass( talteksignup.studentID, talteksignup.pass);
        si.clickOnLoginBtn();
    }
    @Then("I should be able successfully to sign in")
    public void i_should_be_able_successfully_to_sign_in() throws InterruptedException {

        si.assertSuccessfullyLogin(talteksignup.studentID);
    }

}
