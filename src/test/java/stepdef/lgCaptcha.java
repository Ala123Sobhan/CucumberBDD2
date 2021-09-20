package stepdef;

import base.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LgSignInPageObject;

import java.io.IOException;
import java.net.URISyntaxException;

public class lgCaptcha extends Config {


    LgSignInPageObject lg = new LgSignInPageObject(driver);

    @Given("^I am at \"([^\"]*)\"$")
    public void i_am_at_something(String url) throws Throwable {
        lg.goToSignInUrl(url);
    }


    @When("I input the the captcha in the captcha input box")
    public void i_input_the_the_captcha_in_the_captcha_input_box() {
       lg.inputCaptcha();
    }


    @Then("^I should be able to get done with features.captcha verification$")
    public void i_should_be_able_to_get_done_with_captcha_verification() throws Throwable {

    }

    @Given("I understand the captcha text")
    public void i_understand_the_captcha_text() throws IOException, URISyntaxException {
        lg.solveCaptcha();
    }

}
