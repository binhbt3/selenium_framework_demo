package study.dataprovider;

import org.testng.annotations.DataProvider;
import study.constants.FrameworkConstants;
import study.helpers.ExcelHelpers;

public class DataProviderUpdateTicket {
    @DataProvider(name="data_provider_update_ticket_without_edit")
    public Object[][] datatestUpdateTicketWithoutEdit(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_KEOLIS, "Update_ticket_without_edit", 1, 5);
        return data;
    }
    @DataProvider(name="data_provider_update_ticket_without_edit_lvb")
    public Object[][] datatestUpdateTicketWithoutEditLVB(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_LVB, "Update_ticket_without_edit", 1, 4);
        return data;
    }
    @DataProvider(name="data_provider_create_ticket_fahrservice_lvb")
    public Object[][] datatestCreateTicketFahrservice(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_LVB, "Update ticket Fahrservice", 1, 1);
        return data;
    }

    @DataProvider(name="data_provider_update_ticket_fahrservice_lvb")
    public Object[][] datatesttestUpdateTicketFahrservice(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_LVB, "Update ticket Fahrservice", 2, 3);
        return data;
    }
    @DataProvider(name="data_provider_update_status_ticket_fahservice_lvb")
    public Object[][] datatestUpdateStatusTicketFahrservice(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_LVB, "Update ticket Fahrservice", 4, 4);
        return data;
    }

    @DataProvider(name="data_provider_reopen_ticket_fahrservice_from_lvb")
    public Object[][] datatestReOpenTicketFahrserviceFromLVB(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_LVB, "Update ticket Fahrservice", 5, 5);
        return data;
    }

    @DataProvider(name="data_provider_update_ticket_without_edit_samsungseg")
    public Object[][] datatestUpdateTicketWithoutEditSamSungSEG(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_SAMSUNGSEG, "Update_ticket_without_edit", 1, 3);
        return data;
    }

    @DataProvider(name="data_provider_update_ticket_without_edit_kvb")
    public Object[][] datatestUpdateTicketWithoutEditKVB(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_KVB, "Update_ticket_without_edit", 4, 4);
        return data;
    }

    @DataProvider(name="data_provider_update_ticket_with_edit_kvb")
    public Object[][] datatestUpdateTicketWithEditKVB(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_KVB, "Update_ticket_with_edit", 1, 1);
        return data;
    }

    @DataProvider(name="data_provider_update_ticket_with_edit_lvb")
    public Object[][] datatestUpdateTicketWithEditLVB(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_LVB, "Update_ticket_with_edit", 1, 1);
        return data;
    }

    @DataProvider(name="data_provider_update_ticket_with_edit_keolis")
    public Object[][] datatestUpdateTicketWithEditKeolis(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_KEOLIS, "Update_ticket_with_edit", 1, 1);
        return data;
    }

    @DataProvider(name="data_provider_update_ticket_with_edit_samsungseg")
    public Object[][] datatestUpdateTicketWithEditSamSungSeg(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_SAMSUNGSEG, "Update_ticket_with_edit", 1, 1);
        return data;
    }

    @DataProvider(name="data_provider_update_ticket_dvs_zup")
    public Object[][] dataUpdateTicketDVSZup(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_DVS_COMPLAINT, "Update_ticket_with_edit", 1, 2);
        return data;
    }

}
