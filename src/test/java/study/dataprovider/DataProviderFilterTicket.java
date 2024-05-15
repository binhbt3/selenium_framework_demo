package study.dataprovider;

import org.testng.annotations.DataProvider;
import study.constants.FrameworkConstants;
import study.helpers.ExcelHelpers;

public class DataProviderFilterTicket {
    @DataProvider(name="data_provider_filter_ticket")
    public Object[][] dataFilterTicket(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_KEOLIS, "Filter_ticket", 1, 1);
        return data;
    }
    @DataProvider(name="data_provider_filter_ticket_to_export_keolis")
    public Object[][] dataFilterTicketToExportKeolis(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_KEOLIS, "Filter_ticket", 2, 2);
        return data;
    }

    @DataProvider(name="data_provider_filter_ticket_lvb")
    public Object[][] dataFilterTicketLVB(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_LVB, "Filter_ticket", 1, 1);
        return data;
    }
    
    @DataProvider(name="data_provider_filter_ticket_to_export_lvb")
    public Object[][] dataFilterTicketToExportLVB(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_LVB, "Filter_ticket", 2, 2);
        return data;
    }

    @DataProvider(name="data_provider_filter_ticket_to_export_samsungseg")
    public Object[][] dataFilterTicketToExportSamSungSeg(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_SAMSUNGSEG, "Filter_ticket", 2, 2);
        return data;
    }
    @DataProvider(name="data_provider_filter_ticket_samsungseg")
    public Object[][] dataFilterTicketSamSungSeg(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_SAMSUNGSEG, "Filter_ticket", 1, 1);
        return data;
    }

    @DataProvider(name="data_provider_filter_ticket_kvb")
    public Object[][] dataFilterTicketKVB(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_KVB, "Filter_ticket", 1, 1);
        return data;
    }

    @DataProvider(name="data_provider_filter_ticket_export_kvb")
    public Object[][] dataFilterTicketExportKVB(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_KVB, "Filter_ticket", 2, 2);
        return data;
    }
}
