package pageObject;

import base.Config;
import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Normal;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

    }

    public void inputCaptcha() {

       WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(captchaInput));
        captchaInput.sendKeys(captchaText);

    }
}
