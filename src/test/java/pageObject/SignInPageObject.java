package pageObject;

import base.Config;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPageObject extends Config {

    public SignInPageObject(WebDriver driver){

        PageFactory.initElements(driver, this);
        Config.driver = driver;

    }

    @FindBy(how = How.LINK_TEXT, using = "Create New Account")
    WebElement createNewAccBtn;

    @FindBy(how = How.NAME, using = "email")
    WebElement emailInputbox;

    @FindBy(how = How.NAME, using = "password")
    WebElement passInputbox;

    @FindBy(how = How.CLASS_NAME, using = "my-login")
    WebElement loginBtn;

    @FindBy(how = How.XPATH, using= "//*[@id='profile_form']/legend")
    WebElement welcomeTxt;

    @FindBy(how = How.XPATH, using= "//*[@placeholder='Student ID']")
    WebElement studentIDLocator;

    @FindBy(how = How.NAME, using = "email")
    WebElement emailLocator;


    public void waitForElement(WebDriver driver, int time, WebElement ele)
    {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(ele));
    }


    public void clickCreateNewAccBtn(){
        waitForElement(driver, 20, createNewAccBtn);
        createNewAccBtn.click();
    }

    public void enterIDAndPass(String id, String pass){
        waitForElement(driver, 15, emailInputbox);
        emailInputbox.sendKeys(id);
        waitForElement(driver, 15, passInputbox);
        passInputbox.sendKeys(pass);


    }

    public void clickOnLoginBtn(){
        waitForElement(driver, 15, loginBtn);
        loginBtn.click();
    }

    public void assertSuccessfullyLogin(String studentID) throws InterruptedException {
        waitForElement(driver, 15, welcomeTxt);
        Assert.assertEquals("Welcome to TalentTek", welcomeTxt.getText());
        waitForElement(driver, 15, emailLocator);
        System.out.println(studentID);
        Assert.assertEquals(studentID, studentIDLocator.getAttribute("value"));
    }


}
