package stepdef;

import base.Config;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.SignUpPageObject;

public class talteksignup extends Config {

    SignUpPageObject su = new SignUpPageObject(driver);
    Faker fk = new Faker();
    @And("I enter student first name, last name, valid email address, password and confirm password")
    public void iEnterStudentFirstNameLastNameValidEmailAddressPasswordAndConfirmPassword() {

        su.enterFirstName(fk.name().firstName());
        su.enterLastName(fk.name().lastName());
        su.enterEmail(fk.internet().safeEmailAddress());
        su.enterPassword(fk.internet().password());






    }

    @And("I enter student birth month, date and year")
    public void iEnterStudentBirthMonthDateAndYear() {
        su.selectMonth();
        su.selectDay();
        su.selectYear();
    }

    @And("I enter student gender as female")
    public void iEnterStudentGenderAsFemale() {
        su.selectRadioBtn("Female");
    }

    @And("I agree with the terms and data use policy")
    public void iAgreeWithTheTermsAndDataUsePolicy() {

        su.selectCheckBox();
    }

    @When("I click on the Create my account")
    public void iClickOnTheCreateMyAccount() {

        su.clickCreateAccBtn();
    }

    @Then("I should be able to get the student id")
    public void iShouldBeAbleToGetTheStudentId() {

        su.verifySuccessMsg();

    }

}
