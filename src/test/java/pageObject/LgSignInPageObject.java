package pageObject;

import base.Config;
import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Normal;
import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.types.selectors.SelectSelector;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

//import java.io.File;

public class LgSignInPageObject extends Config {

    public String captchaText;

    public LgSignInPageObject(WebDriver driver) {

        PageFactory.initElements(driver, this);
        Config.driver = driver;

    }

    @FindBy(how = How.ID, using = "customizedCaptcha_CaptchaImage")
    public WebElement captchaImg;

    @FindBy(how = How.ID, using = "captchaCode")
    public WebElement captchaInput;

    @FindBy(how = How.CLASS_NAME, using = "email")
    public WebElement emailInput;

    @FindBy(how = How.ID, using = "txtBoxDkagh")
    public WebElement passwordInput;

    @FindBy(how = How.NAME, using = "signinFormTrigger")
    public WebElement signInBtn;

    @FindBy(how = How.CSS, using = ".login.logged")
    public WebElement loginIcon;


    public void goToSignInUrl(String url) {
        driver.get(url);
    }

    public void solveCaptcha() throws IOException, URISyntaxException {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(captchaImg));

        File f = captchaImg.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f, new File("screenshots.png"));
        File file = new File("screenshots.png");

        System.out.println("file: " + file);
        TwoCaptcha solver = new TwoCaptcha("3940daf4eab14ff372ce54691f3de0ac");
        Normal captcha = new Normal();
        captcha.setFile(file);

        try {
            solver.solve(captcha);
            captchaText = captcha.getCode();
            System.out.println("Captcha solved: " + captcha.getCode());
            System.out.println("captcha- "+captchaText);
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

    }

    public void inputCaptcha() {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(captchaInput));
        captchaInput.sendKeys(captchaText);

    }

    public void enterEmailAndPass(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(emailInput));

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }

    public void clickSignInBtn() {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(signInBtn));

        signInBtn.click();
    }

    public void verifySuccessfulLogin(){

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(loginIcon));

        if(loginIcon.isDisplayed()){
            Assert.assertEquals(true, true);
        }
        else{
            Assert.assertEquals(false, true);
        }

    }
    public void waitForPageToBeReady(WebDriver driver)
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //This loop will rotate for 100 times to check If page Is ready after every 1 second.
        for (int i=0; i<100; i++)
        {
            try
            {
                Thread.sleep(1000);
            }catch (InterruptedException e) {}
            //To check page ready state.
            if (js.executeScript("return document.readyState").toString().equals("complete"))
            {
                break;
            }
        }
    }



    public void clickSignInLink() throws InterruptedException {

        waitForPageToBeReady(driver);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //js.executeScript("document.getElementById('closeIconContainer').click();");

        WebElement login = driver.findElement(By.cssSelector("div.login"));
        WebElement signInLink =login.findElement(By.cssSelector("a[data-link-name='sign_in_/_sign_up']"));
        //signInLink.click();
        js.executeScript("arguments[0].click();", signInLink);


    }
}
