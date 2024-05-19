package study.projects.greenkart.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import study.keywords.WebUI;
import study.projects.common.pages.GoogleMailPageCommon;

import java.io.File;

public class testDemo {
    @Test
    public void uploadFileWithLocalForm() {
        WebUI.getURL("https://easyupload.io/");
        By buttonUpload = By.xpath("//button[@class='dz-button']");
        String uploadFilePath = WebUI.getPathDownloadDirectory() + File.separator + "Day+9+-+Course+slides.pdf";
        System.out.println(uploadFilePath);
        WebUI.uploadFileWithLocalForm(buttonUpload, uploadFilePath);
    }

    @Test
    public void testSelectCheckbox(){
        WebUI.getURL("https://demo.guru99.com/test/newtours/register.php");
        By selectCountry = By.xpath("//select[@name='country']");
        WebUI.verifySelectedByText(selectCountry, "ALBANA");
        WebUI.verifyOptionExitInSelect(selectCountry, "CUBA");
        WebUI.selectOptionByText(selectCountry, "ALGERIA");
        WebUI.verifySelectedByText(selectCountry, "ALGERIA");
        WebUI.getAllOptionsExitInSelect(selectCountry);
    }

    public void selectCountry(By selectBy, By listOptions, String text){
        WebUI.clickElement(selectBy);
        WebUI.sleep(1);
        WebUI.selectOptionDynamic(listOptions, text);
        WebUI.verifyElementText(selectBy, text);
    }
    @Test
    public void testSelectDynamicDropDown(){
        WebUI.getURL("https://techydevs.com/demos/themes/html/listhub-demo/listhub/index.html");
        By optionList = By.xpath("//ul[contains(.,'Select a Country')]/li");
        By spanSelectOption = By.xpath("//span[normalize-space()='Select a Country']");
        WebUI.sleep(1);
        selectCountry(spanSelectOption, optionList, "Vietnam");
    }

    @Test
    public void testHightLightElement(){
        WebUI.getURL("https://demo.guru99.com/test/newtours/register.php");
        By selectCountry = By.xpath("//select[@name='country']");
        By btnSignOn = By.xpath("//td[.='SIGN-ON']");
        WebUI.sleep(1);
        WebUI.sleep(1);
        WebUI.rightClickElement(btnSignOn);
        WebUI.highLightElement(selectCountry);
    }

    @Test
    public void testSendEmailByGoogleEmail(){
        GoogleMailPageCommon googleMailPageCommon = new GoogleMailPageCommon();
        googleMailPageCommon.loginToEmail("***", "***");
        googleMailPageCommon.sendEmail("***@gmail.com", "Email Subject", "This is email automatically!");
    }

}
