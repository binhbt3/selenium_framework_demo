package study.projects.greenkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import study.keywords.WebUI;
import study.utils.LogUtils;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class PlaceOrderPage {

    By productNameInConfirmPage = By.xpath("//tbody//p[@class='product-name']");
    By quantiryInConfirmPage = By.xpath("//tbody//p[@class='quantity']");
    By priceInConfirmPage = By.xpath("//tbody//td[4]/p");
    By totalInTable = By.xpath("//tbody//td[5]/p");
    By noOfItems = By.xpath("//b[contains(.,'No. of Items')]");
    By totalAmount = By.xpath("//span[@class='totAmt']");
    By discount = By.xpath("//span[@class='discountPerc']");
    By totalAfterDiscount = By.xpath("//span[@class='discountAmt']");
    By inputPromoCode = By.xpath("//input[@class='promoCode']");
    By buttonApply = By.xpath("//button[@class='promoBtn']");
    By applyPromoCodeMessage = By.xpath("//span[@class='promoInfo']");
    By buttonPlaceOrder = By.xpath("//button[text()='Place Order']");
    By dropDownSelectCountry = By.xpath("//select");
    By checkboxAgreeTermConditions = By.xpath("//input[@class='chkAgree']");
    By buttonProceed = By.xpath("//button[contains(text(),'Proceed')]");

    public void placeOrderConfirmation(Hashtable<String, String> data){
        verifyPlaceOrderConfirmation(data);
        completePlaceOrder();
    }

    public void applyPromoCode(String promoCode, String applyPromoCodeMessageExpected){
        LogUtils.info("Promo Code: " + promoCode);
        WebUI.clearAndFillText(inputPromoCode, promoCode);
        WebUI.clickElement(buttonApply);
        WebUI.verifyElementTextEquals(applyPromoCodeMessage, applyPromoCodeMessageExpected);
    }

    public int getNoofItems(){
        return Integer.parseInt(WebUI.getTextElement(noOfItems));
    }

    public int getTotalAmount(){
        return Integer.parseInt(WebUI.getTextElement(totalAmount));
    }

    public int getDiscount(){
        return Integer.parseInt(WebUI.getTextElement(discount).replace("%",""));
    }

    public int getTotalAfterDiscount(){
        return Integer.parseInt(WebUI.getTextElement(totalAfterDiscount));
    }
    public void verifyPlaceOrderConfirmation(Hashtable<String, String> data){

        // Verify product Name, Quantiry, Price, Total in table
        List<String> itemNameExpectedList = Arrays.stream(data.get("item").trim().split(", ")).toList();
        LogUtils.info("itemNameExpectedList: " + itemNameExpectedList);
        List <String> itemPriceExpectedList = Arrays.stream(data.get("price").trim().split(", ")).toList();
        LogUtils.info("itemPriceExpectedList: " + itemPriceExpectedList);
        List <String> qualityList = Arrays.stream(data.get("quality").trim().split(", ")).toList();
        LogUtils.info("qualityList: " + qualityList);

        int totalAmountCalculation = 0;
        WebUI.waitForElementVisible(totalInTable, 1);
        List<WebElement> totalRows = WebUI.getWebElements(totalInTable);
        LogUtils.info("totalRows size: " + totalRows.size());

        for(int j = 0; j < itemNameExpectedList.size() ; j++) {
            boolean check = false;
            for(int i = 1; i <= totalRows.size(); i++) {
                System.out.println("78 : " + i);
                if (WebUI.getValueOnTableByRowColumn(i, 2).equals(itemNameExpectedList.get(j))) {
                    WebUI.verifyEquals(WebUI.getValueOnTableByRowColumn(i, 3), qualityList.get(j));
                    WebUI.verifyEquals(WebUI.getValueOnTableByRowColumn(i, 4), itemPriceExpectedList.get(j));
                    WebUI.verifyEquals(Integer.parseInt(WebUI.getValueOnTableByRowColumn(i, 5)), Integer.parseInt(qualityList.get(j)) * Integer.parseInt(itemPriceExpectedList.get(j)));
                    totalAmountCalculation += Integer.parseInt(qualityList.get(j)) * Integer.parseInt(itemPriceExpectedList.get(j));
                    check = true;
                }
            }
            WebUI.verifyTrue(check, itemNameExpectedList.get(j) + " not found in Confirm Place Order page");
        }

        // Verify No. of item, Total Amount, Discount, Total Before Discount
        int totalAmountIntBeforeApplyCode = getTotalAmount();
        WebUI.verifyEquals(totalAmountIntBeforeApplyCode, totalAmountCalculation, "Total Amount is not match");
        WebUI.verifyEquals(getDiscount(), 0);
        WebUI.verifyEquals(getTotalAfterDiscount(),totalAmountCalculation);

        if(data.get("promo code") != "") {
            applyPromoCode(data.get("promo code"), data.get("Apply code message"));
        }

        WebUI.verifyEquals(getDiscount(), Integer.parseInt(data.get("Discount")), "Discount is not match");
        WebUI.verifyEquals(getTotalAmount(), totalAmountCalculation, "Total Amount is not match");
        WebUI.verifyEquals(getTotalAmount(), totalAmountCalculation, "Total Amount is not match");

        if(data.get("Apply code message").equals("Code applied ..!")){
            WebUI.verifyEquals(getTotalAfterDiscount(), totalAmountCalculation - totalAmountIntBeforeApplyCode*Integer.parseInt(data.get("Discount"))/100, "Total Amount is not match");
        } else {
            WebUI.verifyEquals(getTotalAfterDiscount(), totalAmountCalculation, "Total Amount is not match");
        }
        WebUI.clickElement(buttonPlaceOrder);
    }

    public void completePlaceOrder(){
        WebUI.selectOptionByText(dropDownSelectCountry, "Vietnam");
        WebUI.clickElement(checkboxAgreeTermConditions);
        WebUI.clickElement(buttonProceed);
    }



}
