package pageObject;

import base.Config;
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

    public void waitForElement(WebDriver driver, int time, WebElement ele)
    {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(ele));
    }


    public void clickCreateNewAccBtn(){
        waitForElement(driver, 20, createNewAccBtn);
        createNewAccBtn.click();
    }

}
