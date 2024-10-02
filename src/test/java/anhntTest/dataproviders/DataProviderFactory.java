package anhntTest.dataproviders;

import anhntTest.constants.ConfigData;
import anhntTest.helpers.DataFakerHelper;
import anhntTest.helpers.ExcelHelper;
import anhntTest.helpers.SystemHelper;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {
    DataFakerHelper dataFakerHelper;

    private String excelFilePath = ConfigData.EXCEL_FILE_DATA_PATH;
    @DataProvider(name = "data_Login"/*, parallel = true*/)
    public Object[][] dataLogin() {
        ExcelHelper excelHelper = new ExcelHelper();
        return excelHelper.getExcelData(SystemHelper.getCurrentDir() + excelFilePath, "Login");
    }

    @DataProvider(name = "data_Info_Clients")
    public Object[][] dataClients() {
        ExcelHelper excelHelper = new ExcelHelper();
        return excelHelper.getDataHashTable(SystemHelper.getCurrentDir() + excelFilePath, "Clients");
    }
    @DataProvider(name = "data_Info_Project")
    public Object[][] dataProject() {
        ExcelHelper excelHelper = new ExcelHelper();
        return excelHelper.getDataHashTable(SystemHelper.getCurrentDir() + excelFilePath, "Projects");
    }

    @DataProvider(name = "data_Info_Task")
    public Object[][] dataTask() {
        ExcelHelper excelHelper = new ExcelHelper();
        return excelHelper.getDataHashTable(SystemHelper.getCurrentDir() + excelFilePath, "Task");
    }

    @DataProvider(name = "data_Info_EditProjectStatus")
    public Object[][] dataProjectStatus() {
        ExcelHelper excelHelper = new ExcelHelper();
        return excelHelper.getDataHashTable(SystemHelper.getCurrentDir() + excelFilePath, "EditProjectStatus");
    }
    @DataProvider(name = "data_AttachFile")
    public Object[][] dataAttachFile() {
        ExcelHelper excelHelper = new ExcelHelper();
        return excelHelper.getDataHashTable(SystemHelper.getCurrentDir() + excelFilePath, "AttachFile");
    }


}
