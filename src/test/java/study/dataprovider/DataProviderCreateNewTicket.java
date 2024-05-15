package study.dataprovider;

import org.testng.annotations.DataProvider;
import study.constants.FrameworkConstants;
import study.helpers.ExcelHelpers;

public class DataProviderCreateNewTicket {

    @DataProvider(name="data_provider_create_new_ticket")
    public Object[][] dataCreateNewTicket(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_KEOLIS, "Create_new_ticket", 2, 2);
        return data;
    }

    @DataProvider(name="data_provider_create_new_ticket_with_required_field")
    public Object[][] dataCreateNewTicketWithRequire(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_KEOLIS, "Create_new_ticket_with_require", 1, 1);
        return data;
    }

    @DataProvider(name="data_provider_create_new_ticket_by_customer")
    public Object[][] dataCreateNewTicketByCustomerEmail(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_KEOLIS, "Create_new_ticket_by_email", 1, 1);
        return data;
    }


    @DataProvider(name="data_provider_create_new_ticket_lvb")
    public Object[][] dataCreateNewTicketLVB(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_LVB, "Create_new_ticket", 2, 3);
        return data;
    }

    @DataProvider(name="data_provider_create_new_ticket_without_require_field_lvb")
    public Object[][] dataCreateNewTicketWithoutRequireLVB(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_LVB, "Create_new_ticket", 2, 2);
        return data;
    }

    @DataProvider(name="data_provider_create_new_ticket_with_required_field_lvb")
    public Object[][] dataCreateNewTicketWithRequireLVB(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_LVB, "Create_new_ticket_with_require", 1, 1);
        return data;
    }

    @DataProvider(name="data_provider_create_new_ticket_by_customer_lvb")
    public Object[][] dataCreateNewTicketByCustomerEmailLVB(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_LVB, "Create_new_ticket_by_email", 1, 1);
        return data;
    }
    @DataProvider(name="data_provider_create_new_ticket_samsungseg")
    public Object[][] dataCreateNewTicketSamSungSEG(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_SAMSUNGSEG, "Create_new_ticket", 2, 2);
        return data;
    }

    @DataProvider(name="data_provider_create_new_ticket_by_answer_samsung_service_survey")
    public Object[][] dataCreateNewTicketByAnswerSamsungServiceSurvey(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_SAMSUNGSEG, "SamSung_service_online_survey", 1, 1);
        return data;
    }

    @DataProvider(name="data_provider_create_new_ticket_with_required_field_samsungseg")
    public Object[][] dataCreateNewTicketWithRequireSamSungSEG(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_SAMSUNGSEG, "Create_new_ticket_with_require", 1, 1);
        return data;
    }

//    @DataProvider(name="data_provider_create_new_ticket_samsungseg")
//    public Object[][] dataCreateNewTicketWithoutRequiredFieldSamSungSEG(){
//        ExcelHelpers excel = new ExcelHelpers();
//        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_SAMSUNGSEG, "Create_new_ticket", 5, 5);
//        return data;
//    }


    @DataProvider(name="data_provider_create_new_ticket_kvb")
    public Object[][] dataCreateNewTicketKVB(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_KVB, "Create_new_ticket", 2, 2);
        return data;
    }
    @DataProvider(name="data_provider_create_new_ticket_with_required_field_kvb")
    public Object[][] dataCreateNewTicketWithRequireKVB(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_KVB, "Create_new_ticket_with_require", 1, 1);
        return data;
    }

    @DataProvider(name="data_provider_create_new_ticket_without_require_filed_kvb")
    public Object[][] dataCreateNewTicketWithoutRequireKVB(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_KVB, "Create_new_ticket_with_require", 1, 1);
        return data;
    }

    @DataProvider(name="data_provider_create_new_ticket_by_customer_kvb")
    public Object[][] dataCreateNewTicketByCustomerEmailKVB(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_KVB, "Create_new_ticket_by_email", 1, 1);
        return data;
    }
    @DataProvider(name="data_provider_create_new_ticket_by_answer_lvb_service_survey")
    public Object[][] dataCreateNewTicketByAnswerLVBServiceSurvey(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_LVB, "Lvb_service_online_survey", 1, 1);
        return data;
    }

    @DataProvider(name="data_provider_create_new_ticket_by_answer_kvb_service_survey")
    public Object[][] dataCreateNewTicketByAnswerKVBServiceSurvey(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_KVB, "Kvb_service_online_survey", 1, 1);
        return data;
    }
    @DataProvider(name="data_provider_create_new_ticket_by_answer_keolis_service_survey")
    public Object[][] dataCreateNewTicketByAnswerKeolisServiceSurvey(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_KEOLIS, "Keolis_service_online_survey", 1, 1);
        return data;
    }

    @DataProvider(name="data_provider_create_new_ticket_dvs_complaint")
    public Object[][] dataCreateNewTicketDVSComplaint(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_DVS_COMPLAINT, "Create_new_ticket", 1, 2);
        return data;
    }

    @DataProvider(name="data_provider_create_ticket_dvs_zup")
    public Object[][] dataCreateTicketDVSZup(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_DVS_COMPLAINT, "Create_new_ticket", 1, 2);
        return data;
    }

    @DataProvider(name="data_provider_create_new_ticket_dvs_complaint_from_debitor_user")
    public Object[][] dataCreateNewTicketWithAllFieldFromDebitorUser(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_DVS_COMPLAINT, "Create_new_ticket", 3, 3);
        return data;
    }
    @DataProvider(name="data_provider_create_new_ticket_with_required_field_dvs_complaint")
    public Object[][] dataCreateNewTicketWithRequireDVSComplaint(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_DVS_COMPLAINT, "Create_new_ticket_with_require", 1, 1);
        return data;
    }

    @DataProvider(name="data_provider_create_new_ticket_without_require_filed_dvs_complaint")
    public Object[][] dataCreateNewTicketWithoutRequireDVSComplaint(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_DVS_COMPLAINT, "Create_new_ticket_with_require", 1, 1);
        return data;
    }

    @DataProvider(name="data_provider_create_new_ticket_by_answer_dvs_service_survey")
    public Object[][] dataCreateNewTicketByAnswerDVSServiceSurvey(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_DVS_COMPLAINT, "DVS_service_online_survey", 1, 1);
        return data;
    }
    @DataProvider(name="data_provider_create_new_ticket_by_answer_DVS_Kundenreklamationen_survey")
    public Object[][] dataCreateNewTicketByAnswerDVSKundenreklamationenSurvey(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_DVS_COMPLAINT, "DVS_Kundenreklamationen_survey", 1, 1);
        return data;
    }
    @DataProvider(name="data_provider_create_new_ticket_by_answer_ihr_anliegen_survey")
    public Object[][] dataCreateTicketByAnswerDVSKundenreklamationenSurvey(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_DVS_COMPLAINT, "DVS_Ihr Anliegen_survey", 1, 1);
        return data;
    }

    @DataProvider(name="data_provider_create_new_ticket_by_customer_dvs")
    public Object[][] dataCreateNewTicketByCustomerEmailDVS(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_DVS_COMPLAINT, "Create_new_ticket_by_email", 1, 1);
        return data;
    }

    @DataProvider(name="data_provider_create_new_ticket_ameos")
    public Object[][] dataCreateNewTicketAMEOS(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_AMEOS, "Create_new_ticket", 1, 1);
        return data;
    }
}
