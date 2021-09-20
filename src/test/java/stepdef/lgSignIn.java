package stepdef;

import base.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LgSignInPageObject;

public class lgSignIn extends Config {

    LgSignInPageObject lg = new LgSignInPageObject(driver);

    @Given("^I am at \"([^\"]*)\"$")
    public void i_am_at_something(String url) throws Throwable {
        lg.goToSignInUrl(url);
    }

    @When("^I click on the sign in button$")
    public void i_click_on_the_sign_in_button() throws Throwable {
         lg.clickSignInBtn();
    }

    @Then("^I should be able to successfully sign in$")
    public void i_should_be_able_to_successfully_sign_in() throws Throwable {
        lg.verifySuccessfulLogin();
    }

    @And("^I enter email as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void i_enter_email_as_something_and_password_as_something(String email, String password) throws Throwable {
        lg.enterEmailAndPass(email, password);
    }


    @And("^I solve the captcha Image$")
    public void i_solve_the_captcha_image() throws Throwable {
        lg.solveCaptcha();
    }

    @And("^I enter the the captcha text in the captcha input box$")
    public void i_enter_the_the_captcha_text_in_the_captcha_input_box() throws Throwable {
       lg.inputCaptcha();
    }




}
