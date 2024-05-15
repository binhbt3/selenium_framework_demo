package study.projects.greenkart.testcases;

import org.testng.annotations.Test;
import study.common.BaseTest;
import study.dataprovider.DataProviderPlaceOrders;
import study.projects.greenkart.pages.MenuListItemsPage;
import study.utils.LogUtils;

import java.util.Hashtable;

public class testSearchItem extends BaseTest{

    @Test(dataProvider = "data_provider_place_order_with_search_not_existed_item", dataProviderClass = DataProviderPlaceOrders.class, description = "testPlaceOrderWithSearchNotExistedItem")
    public void testPlaceOrderWithSearchNotExistedItem(Hashtable<String, String> data){
        MenuListItemsPage menuListItemsPage = new MenuListItemsPage();
        LogUtils.info(data.get("search item"));
        menuListItemsPage.searchItems(data.get("search item"));
    }
}
