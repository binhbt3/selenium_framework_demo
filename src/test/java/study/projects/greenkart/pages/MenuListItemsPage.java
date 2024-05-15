package study.projects.greenkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import study.keywords.WebUI;
import study.utils.LogUtils;

import java.util.*;

public class MenuListItemsPage {

    By inputSearchItem = By.xpath("//input[@class='search-keyword']");
    By divSearchItemResult = By.xpath("//div[@class='products']/div");
    By divSearchItemNameResultCheck = By.xpath("//div[@class='products']/div/h4");
    By divitemPrice = By.xpath("//div[@class='products']//p");
    By inputQuality = By.xpath("//input[@class='quantity']");
    By buttonAddToCart = By.xpath("//div[@class='product-action']");
    By divNoResultSearch = By.xpath("//div[@class='no-results']/h2");
    By itemQualityinCart = By.xpath("//td[text()='Items']/parent::tr");
    By itemPriceinCart = By.xpath("//td[text()='Price']/parent::tr");
    By cartItem = By.xpath("//li[@class='cart-item']");
    By cartItemProductName = By.xpath("//li[@class='cart-item']//p[@class='product-name']");
    By cartItemProductPrice = By.xpath("//li[@class='cart-item']//p[@class='product-price']");
    By cartItemProductAmount= By.xpath("//li[@class='cart-item']//p[@class='amount']");
    By buttonProceedToCheckout= By.xpath("//button[text()='PROCEED TO CHECKOUT']");

    public List <WebElement> searchItem(String searchItem){
        WebUI.clearAndFillText(inputSearchItem, searchItem);
        WebUI.sleep(1);
        List <WebElement> searchItemResults = WebUI.getWebElements(divSearchItemResult);
        LogUtils.info("Number of items in search result: "+searchItemResults.size());
        if (WebUI.verifyElementExists(divSearchItemNameResultCheck)) {
            LogUtils.info("Show information of list search Item result");
            for (int i = 0; i < searchItemResults.size(); i++) {
                String itemNameActual = WebUI.getWebElements(divSearchItemNameResultCheck).get(i).getText();
                LogUtils.info("itemNameActual: " + itemNameActual);
                WebUI.verifyContains(itemNameActual, searchItem);
            }
            return searchItemResults;
        } else {
            WebUI.verifyElementTextEquals(divNoResultSearch, "Sorry, no products matched your search!");
//            String noResultMessage = WebUI.getTextElement(divNoResultSearch);
//            LogUtils.info(noResultMessage);
//            if(searchItem.contains("not exist")) {
//                AssertUtil.assertEquals(noResultMessage, "Sorry, no products matched your search!", "No Result message is not match");
//            } else {
//                AssertUtil.assertFalse(true, "search function is not working!");
//            }
            return null;
        }
    }
    By cartIcon = By.xpath("//a[@class='cart-icon']");
    public void addToCards(String searchItem, String itemNameExpected, String itemPriceExpected, String quality){
        List <String> searchItemList = Arrays.stream(searchItem.trim().split(", ")).toList();
        LogUtils.info("searchItemList: " + searchItemList);

        List <String> itemNameExpectedList = Arrays.stream(itemNameExpected.trim().split(", ")).toList();
        LogUtils.info("itemNameExpectedList: " + itemNameExpectedList);
        List <String> itemPriceExpectedList = Arrays.stream(itemPriceExpected.trim().split(", ")).toList();
        LogUtils.info("itemPriceExpectedList: " + itemPriceExpectedList);
        List <String> qualityList = Arrays.stream(quality.trim().split(", ")).toList();
        LogUtils.info("qualityList: " + qualityList);

        HashMap<String, Integer> itemInCart = new HashMap<String, Integer>();

        for(int j = 0; j < itemNameExpectedList.size() ; j++) {
            List<WebElement> searchItemResults = searchItem(searchItemList.get(j));
            if (searchItemResults != null) {
                for (int i = 0; i < searchItemResults.size(); i++) {
                    String itemNameActual = WebUI.getWebElements(divSearchItemNameResultCheck).get(i).getText();
                    LogUtils.info("itemNameActual: " + itemNameActual);
                    LogUtils.info("itemNameExpectedList.get(j): " + itemNameExpectedList.get(j));
                    WebUI.verifyContains(itemNameActual, itemNameExpectedList.get(j));

                    String itemPriceActual = WebUI.getWebElements(divitemPrice).get(i).getText();
                    LogUtils.info("itemPriceActual: " + itemPriceActual);
                    WebUI.verifyEquals(itemPriceActual, itemPriceExpectedList.get(j));

                    String defaultQuality = WebUI.getWebElements(inputQuality).get(i).getAttribute("value");
                    WebUI.verifyEquals(Integer.parseInt(defaultQuality), 1, "Default is not 1");

                    if (!quality.equals(defaultQuality)) {
                        WebUI.clearAndFillText(inputQuality, qualityList.get(j));
                    }
                    //Verify quality of item and price before add to cart
                    System.out.println("86: " + WebUI.getValueOnTableByRowColumn(1,3));
                    System.out.println("87: " + WebUI.getValueOnTableByRowColumn(2,3));
                    int qualityInCartBeforeAddToCartInt = Integer.parseInt(WebUI.getValueOnTableByRowColumn(1,3));
                    int PriceInCartBeforeAddToCartInt = Integer.parseInt(WebUI.getValueOnTableByRowColumn(2,3));
                    //Add item to cart
                    WebUI.getWebElements(buttonAddToCart).get(i).click();

                    //Verify quality of item and price after add to cart
                    int qualityInCartAfterAddToCart = Integer.parseInt(WebUI.getValueOnTableByRowColumn(1,3));
                    int qualityInCartAfterAddToCartExpected;
                    // Check item have already add to cart before or not.
                    if (!itemInCart.keySet().contains(itemNameActual)) {
                        itemInCart.put(itemNameActual, Integer.parseInt(qualityList.get(j)));
                        qualityInCartAfterAddToCartExpected = 1 + qualityInCartBeforeAddToCartInt;
                    } else {
                        itemInCart.put(itemNameActual, itemInCart.get(itemNameActual) + Integer.parseInt(qualityList.get(j)));
                        qualityInCartAfterAddToCartExpected = qualityInCartBeforeAddToCartInt;
                    }
                    WebUI.verifyEquals(qualityInCartAfterAddToCart, qualityInCartAfterAddToCartExpected, "Quality Item in cart is not match");

                    int PriceInCartAfterAddToCart = Integer.parseInt(WebUI.getValueOnTableByRowColumn(2,3));
                    int PriceInCartAfterAddToCartExpected = Integer.parseInt(qualityList.get(j)) * Integer.parseInt(itemPriceActual) + PriceInCartBeforeAddToCartInt;
                    WebUI.verifyEquals(PriceInCartAfterAddToCart, PriceInCartAfterAddToCartExpected, "Quality Item in cart is not match");

                }
            } else {
                return;
            }
        }
        LogUtils.info("itemInCart: " + itemInCart);
        verifyProceedToCheckoutPopupPage(itemNameExpectedList, itemPriceExpectedList, qualityList);
    }

    public void verifyProceedToCheckoutPopupPage(List<String> itemNameExpectedList, List<String> itemPriceExpectedList, List<String> qualityList){
        WebUI.clickElement(cartIcon);
        WebUI.sleep(2);
        WebUI.waitForElementVisible(buttonProceedToCheckout,2);
        //Verify item in proceed to checkout popup page
        for(int j = 0; j < itemNameExpectedList.size() ; j++) {
            List<WebElement> listCartItem = WebUI.getWebElements(cartItem);
            boolean existedItem = false;
            for(int i = 0; i < listCartItem.size(); i++){
                LogUtils.info("Product Name" + WebUI.getWebElements(cartItemProductName).get(i).getText());
                LogUtils.info("itemNameExpected: " + itemNameExpectedList.get(j));
                if(WebUI.getWebElements(cartItemProductName).get(i).getText().equals(itemNameExpectedList.get(j))){
                    WebUI.verifyEquals(WebUI.getWebElements(cartItemProductPrice).get(i).getText(), itemPriceExpectedList.get(j), "Price in proceed to checkout not match");
                    WebUI.verifyEquals(Integer.parseInt(WebUI.getWebElements(cartItemProductAmount).get(i).getText()), Integer.parseInt(itemPriceExpectedList.get(j))*Integer.parseInt(qualityList.get(j)), "Price in proceed to checkout not match");
                    existedItem = true;
                    break;
                }
            }
            WebUI.verifyTrue(existedItem, itemNameExpectedList.get(j) + " is not found in proceed to checkout");
        }
    }
    public PlaceOrderPage goToPlaceOrderPage(){
        WebUI.clickElement(buttonProceedToCheckout);
        WebUI.sleep(1);
        PlaceOrderPage placeOrderPage = new PlaceOrderPage();
        return placeOrderPage;
    }
    public void placeOrder(Hashtable<String, String> data){
        WebUI.getURL("https://rahulshettyacademy.com/seleniumPractise/#/");
        addToCards(data.get("search item"), data.get("item"), data.get("price"), data.get("quality"));
    }

    public void searchItems(String searchItem){
        WebUI.getURL("https://rahulshettyacademy.com/seleniumPractise/#/");
        searchItem(searchItem);
    }
}
