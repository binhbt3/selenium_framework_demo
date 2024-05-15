package study.projects.greenkart.testcases;

import org.testng.annotations.Test;
import study.common.BaseTest;
import study.dataprovider.DataProviderPlaceOrders;
import study.projects.greenkart.pages.MenuListItemsPage;
import study.projects.greenkart.pages.PlaceOrderPage;

import java.util.Hashtable;

public class testPlaceOrders extends BaseTest {

    @Test(dataProvider = "data_provider_place_order_with_search_apply_valid_promo_code", dataProviderClass = DataProviderPlaceOrders.class, description = "testPlaceOrderWithSearchApplyValidPromoCode")
    public void testPlaceOrderWithSearchApplyValidPromoCode(Hashtable<String, String> data){
        MenuListItemsPage menuListItemsPage = new MenuListItemsPage();
        menuListItemsPage.placeOrder(data);
        PlaceOrderPage placeOrderPage = menuListItemsPage.goToPlaceOrderPage();
        placeOrderPage.placeOrderConfirmation(data);
    }

    @Test(dataProvider = "data_provider_place_order_with_search_apply_invalid_promo_code", dataProviderClass = DataProviderPlaceOrders.class, description = "testPlaceOrderWithSearchApplyInvalidPromoCode")
    public void testPlaceOrderWithSearchApplyInvalidPromoCode(Hashtable<String, String> data){
        MenuListItemsPage menuListItemsPage = new MenuListItemsPage();
        menuListItemsPage.placeOrder(data);
        PlaceOrderPage placeOrderPage = menuListItemsPage.goToPlaceOrderPage();
        placeOrderPage.placeOrderConfirmation(data);
    }

    @Test(dataProvider = "data_provider_place_order_with_search_apply_without_promo_code", dataProviderClass = DataProviderPlaceOrders.class, description = "testPlaceOrderWithSearchApplyWithoutPromoCode")
    public void testPlaceOrderWithSearchApplyWithoutPromoCode(Hashtable<String, String> data){
        MenuListItemsPage menuListItemsPage = new MenuListItemsPage();
        menuListItemsPage.placeOrder(data);
        PlaceOrderPage placeOrderPage = menuListItemsPage.goToPlaceOrderPage();
        placeOrderPage.placeOrderConfirmation(data);
    }


}
