package pageObject;

import base.Config;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SignUpPageObject extends Config {


    public SignUpPageObject(WebDriver driver) {

        PageFactory.initElements(driver, this);
        Config.driver = driver;

    }

    @FindBy(how = How.NAME, using = "firstName")
    public WebElement firstNameLocator;

    @FindBy(how = How.NAME, using = "lastName")
    public WebElement lastNameLocator;

    @FindBy(how = How.NAME, using = "email")
    public WebElement emailLocator;

    @FindBy(how = How.NAME, using = "password")
    public WebElement passLocator;


    @FindBy(how = How.NAME, using = "confirmPassword")
    public WebElement confirmpassLocator;

    @FindBy(how = How.NAME, using = "month")
    public WebElement monthLocator;

    @FindBy(how = How.NAME, using = "day")
    public WebElement dayLocator;

    @FindBy(how = How.NAME, using = "year")
    public WebElement yearLocator;

    @FindBy(how = How.NAME, using = "agree")
    public WebElement agreeCheckBoxLocator;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement createMyAccBtn;

    @FindBy(how = How.CSS, using = ".alert.alert-success")
    public WebElement successMsg;

    @FindBy(how = How.CSS, using = ".alert.alert-danger p")
    public WebElement emailErrMsg;

    public void waitForElement(WebDriver driver, int time, WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public void enterFirstName(String fname) {
        waitForElement(driver, 20, firstNameLocator);
        firstNameLocator.clear();
        firstNameLocator.sendKeys(fname);
    }

    public void enterLastName(String lname) {
        waitForElement(driver, 20, lastNameLocator);
        lastNameLocator.clear();
        lastNameLocator.sendKeys(lname);
    }

    public void enterEmail(String em) {
        waitForElement(driver, 20, emailLocator);
        emailLocator.clear();
        emailLocator.sendKeys(em);
    }

    public void enterPassword(String pass) {
        waitForElement(driver, 20, passLocator);
        passLocator.clear();
        passLocator.sendKeys(pass);
        waitForElement(driver, 20, confirmpassLocator);
        confirmpassLocator.clear();
        confirmpassLocator.sendKeys(pass);

    }

    public void selectMonth() {
        Select month = new Select(monthLocator);
        String defaultMonth = month.getFirstSelectedOption().getText();
        // System.out.println(defaultMonth);
        Assert.assertEquals(defaultMonth, "Jan");
        month.selectByIndex(6);
    }

    public void selectDay() {
        Select day = new Select(dayLocator);
        String defaultDay = day.getFirstSelectedOption().getText();
        // System.out.println(defaultDay);
        Assert.assertEquals(defaultDay, "1");
        day.selectByValue("08");
    }

    public void selectYear() {
        Select year = new Select(yearLocator);
        String defaultYear = year.getFirstSelectedOption().getText();
        //  System.out.println(defaultYear);
        Assert.assertEquals(defaultYear, "1990");
        year.selectByVisibleText("1996");
    }

    public void selectRadioBtn(String gender){

        List<WebElement> radio_label = driver.findElements(By.cssSelector(".radio-inline"));

        for(WebElement e : radio_label)
        {
            //System.out.println(e.getText());
            if(e.getText().equalsIgnoreCase(gender))
            {
                e.findElement(By.tagName("input")).click();
            }
        }

    }
    public void selectCheckBox(){

      // System.out.println( agreeCheckBoxLocator.isSelected());
       Assert.assertFalse(agreeCheckBoxLocator.isSelected());
       agreeCheckBoxLocator.click();
    }

    public void clickCreateAccBtn(){
        createMyAccBtn.click();
    }

    public String verifySuccessMsg(){
        String fullMsg = successMsg.getText();
        String studentID = fullMsg.split("-")[1].trim();
        System.out.println(fullMsg);
        String msg = successMsg.getText().split(",")[0];
        System.out.println(msg);
        Assert.assertEquals("Thank you for sign up", msg);

        return studentID;

    }

    public void verifyInvalidEmailErrMsg(){

        waitForElement(driver, 15, emailErrMsg);
        String errMsg = emailErrMsg.getText();
        System.out.println(errMsg);
        Assert.assertEquals("The Email-ID field must contain a valid email address.", errMsg);



    }

}
