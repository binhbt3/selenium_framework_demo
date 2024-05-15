package study.dataprovider;

import org.testng.annotations.DataProvider;
import study.constants.FrameworkConstants;
import study.helpers.ExcelHelpers;

public class DataProviderPlaceOrders {

    @DataProvider(name="data_provider_place_order_with_search_apply_invalid_promo_code")
    public Object[][] DataPlaceOrderWithSearchApplyInvalidPromoCode(){
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(FrameworkConstants.EXCEL_GREENKART_PATH, "place order", 3, 3);
        return data;
    }

    @DataProvider(name="data_provider_place_order_with_search_not_existed_item")
    public Object[][] DataPlaceOrderWithSearchNotExistedItem(){
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(FrameworkConstants.EXCEL_GREENKART_PATH, "place order", 4, 4);
        return data;
    }

    @DataProvider(name="data_provider_place_order_with_search_apply_without_promo_code")
    public Object[][] DataPlaceOrderWithSearchApplyWithoutPromoCode(){
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(FrameworkConstants.EXCEL_GREENKART_PATH, "place order", 1, 1);
        return data;
    }

    @DataProvider(name="data_provider_place_order_with_search_apply_valid_promo_code")
    public Object[][] DataPlaceOrderWithSearchApplyValidPromoCode(){
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(FrameworkConstants.EXCEL_GREENKART_PATH, "place order", 2, 2);
        return data;
    }


}
