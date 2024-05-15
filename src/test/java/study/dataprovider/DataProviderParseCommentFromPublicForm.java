package study.dataprovider;

import org.testng.annotations.DataProvider;
import study.constants.FrameworkConstants;
import study.helpers.ExcelHelpers;

public class DataProviderParseCommentFromPublicForm {
    @DataProvider(name="data_provider_parse_comment_from_public_form_samsungseg")
    public Object[][] dataParseCommentFromPublicForm(){
        ExcelHelpers excel = new ExcelHelpers();
        Object[][] data = excel.getDataHashTable(FrameworkConstants.EXCEL_TICKET_SERVICE_SAMSUNGSEG, "Comment_from_public_form", 1, 1);
        return data;
    }
}
