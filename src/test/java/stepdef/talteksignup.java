package stepdef;

import base.Config;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
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
        su.selectMonth();
        su.selectDay();
        su.selectYear();
        su.selectRadioBtn("Female");
        su.selectCheckBox();
        su.clickCreateAccBtn();
        su.verifySuccessMsg();





    }

    @And("I enter student birth month, date and year")
    public void iEnterStudentBirthMonthDateAndYear() {
    }
}
