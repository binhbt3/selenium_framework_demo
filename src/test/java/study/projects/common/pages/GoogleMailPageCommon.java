package study.projects.common.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import study.keywords.WebUI;
import study.utils.LogUtils;

public class GoogleMailPageCommon {
    public By inputEmailSpectos = By.xpath("//input[@type='email']");
    public By btnContinue = By.xpath("//span[text()='Next' or text()='Weiter']");
    public By inputPasswordSpectos = By.xpath("//input[@type='password']");
    public By emailVerify = By.xpath("//div[contains(text(),'Mail')]");
    public By btnCompose = By.xpath("//div[text()='Compose']");
    public By inputTo = By.xpath("//input[@class='agP aFw']");
    public By inputSubject = By.xpath("//input[@name='subjectbox']");
    public By inputEmailContent = By.xpath("//div[@class='Ar Au']/div");
    public By btnSend = By.xpath("//div[@class='dC']");
    public By btnUserAnotherAccount = By.xpath("//div[contains(text(),'Use another account') or contains(text(),'Anderes Konto verwenden')]");
    public By btnSignIn = By.xpath("//a[@data-action='sign in']");

    public void sendEmail(String supportEmail, String subject, String content) {
        try {
            WebUI.clickElement(btnCompose);
            WebUI.sleep(1);
            WebUI.setText(inputTo, supportEmail);
            WebUI.setText(inputSubject, subject);
            WebUI.setText(inputEmailContent, content);
            WebUI.waitForElementClickable(btnSend);
            WebUI.clickElement(btnSend);
        } catch (UnhandledAlertException f) {
            try {
                WebUI.alertAccept();
            } catch (NoAlertPresentException e) {
                LogUtils.info(e);
            }
        }
        WebUI.sleep(5);
    }

    public void logOutEmail(String customerEmail, String password, String url) {
        WebUI.openURL("https://mail.google.com/mail/logout?hl=en");
        WebUI.sleep(1);
        WebUI.clickElement(btnUserAnotherAccount);
    }

    public void loginToEmail(String customerEmail, String password) {
        WebUI.openURL("https://mail.google.com/mail/u/0/#inbox");
//        int count = 0;
//        while (!WebUI.verifyElementVisible(btnUserAnotherAccount) && count < 3) {
//            WebUI.clickElement(btnSignIn);
//            count += 1;
//        }
//        WebUI.clickElement(btnUserAnotherAccount);
        WebUI.setText(inputEmailSpectos, customerEmail);
        WebUI.clickElement(btnContinue);
        WebUI.sleep(5);
        WebUI.setText(inputPasswordSpectos, password);
        WebUI.clickElement(btnContinue);
        WebUI.sleep(5);
        WebUI.verifyElementExists(emailVerify);
    }

}
