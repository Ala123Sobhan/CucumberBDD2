package stepdef;

import base.Config;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.SignUpPageObject;

public class talteksignup extends Config {

    public static String studentID;
    SignUpPageObject su = new SignUpPageObject(driver);
    Faker fk = new Faker();
    @And("I enter student first name, last name, valid email address, password and confirm password")
    public void iEnterStudentFirstNameLastNameValidEmailAddressPasswordAndConfirmPassword() {

        su.enterFirstName(fk.name().firstName());
        su.enterLastName(fk.name().lastName());
        su.enterEmail(fk.internet().safeEmailAddress());
        su.enterPassword(fk.internet().password(5,6));






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

       studentID = su.verifySuccessMsg();

       System.out.println(studentID);

    }

    @And("I enter student information with invalid email address")
    public void iEnterStudentInformationWithInvalidEmailAddress() {

        su.enterFirstName(fk.name().firstName());
        su.enterLastName(fk.name().lastName());
        su.enterEmail(fk.name().fullName());
        su.enterPassword(fk.internet().password(5,6));
    }

    @And("I enter student gender as male")
    public void iEnterStudentGenderAsMale() {
        su.selectRadioBtn("Male");
    }

    @Then("I should get an invalid email address error message")
    public void iShouldGetAnInvalidEmailAddressErrorMessage() {
        su.verifyInvalidEmailErrMsg();
    }
}
