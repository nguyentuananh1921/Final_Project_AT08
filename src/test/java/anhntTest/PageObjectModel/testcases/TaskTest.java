package anhntTest.PageObjectModel.testcases;

import anhntTest.PageObjectModel.pages.LoginPage;
import anhntTest.common.BaseTest;
import anhntTest.constants.ConfigData;
import anhntTest.dataproviders.DataProviderFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TaskTest extends BaseTest {
    LoginPage loginPage;
    @BeforeMethod
    public void initLogin(){
        loginPage = new LoginPage();

    }
    @Test(priority = 1, dataProvider = "data_Info_Task",dataProviderClass = DataProviderFactory.class)
    public void testAddNewTask(Hashtable<String,String> dataTask){
        loginPage.loginHRM(ConfigData.EMAIL, ConfigData.PASSWORD)
                .verifyLoginSuccess()
                .clickMenuTask()
                .addNewTask(dataTask)
                .verifyAddNewTask(dataTask);
    }

    @Test(priority = 2,dependsOnMethods = "testAddNewTask", dataProvider = "data_Info_Task",dataProviderClass = DataProviderFactory.class)
    public void testEditTask(Hashtable<String,String> dataTask){
        loginPage.loginHRM(ConfigData.EMAIL, ConfigData.PASSWORD)
                .verifyLoginSuccess()
                .clickMenuTask()
                .editTask(dataTask)
                .clickMenuTask()
                .verifyEditTask(dataTask);
    }

    @Test(priority = 3,dependsOnMethods = "testEditTask", dataProvider = "data_Info_Task",dataProviderClass = DataProviderFactory.class)
    public void testDeleteTask(Hashtable<String,String> dataTask){
        loginPage.loginHRM(ConfigData.EMAIL, ConfigData.PASSWORD)
                .verifyLoginSuccess()
                .clickMenuTask()
                .deleteTask(dataTask)
                .verifyDeleteTask();
    }

    @Test(priority = 4, dataProvider = "data_Info_Task",dataProviderClass = DataProviderFactory.class)
    public void testCreateTaskFunctionProcess(Hashtable<String,String> dataTask){
        loginPage.loginHRM(ConfigData.EMAIL, ConfigData.PASSWORD)
                .verifyLoginSuccess()
                .clickMenuTask()
                .addNewTask(dataTask)
                .verifyAddNewTask(dataTask)
                .clickMenuTask()
                .editTask(dataTask)
                .clickMenuTask()
                .verifyEditTask(dataTask)
                .clickMenuTask()
                .deleteTask(dataTask)
                .verifyDeleteTask();
    }

}
