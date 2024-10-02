package anhntTest.PageObjectModel.pages;

import anhntTest.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import java.util.Hashtable;

public class TaskPage extends CommonPage{
    private By inputTitle = By.xpath("//input[@name='task_name']");
    private By selectProject = By.xpath("//select[@name='project_id']");
    private By buttonUpdateTask = By.xpath("//form[@id='update_task']//span[normalize-space()='Update Task']");
    private By inputUpdateDescription = By.xpath("//form[contains(@id,'update')]//iframe[@title='Editable area. Press F10 for toolbar.']");

    String messageUpdateSuccess ="Task updated.";


    public TaskPage addNewTask(Hashtable<String, String> data){
        clickButtonAddNew();
        WebUI.setText(inputTitle,data.get("TITLE"));
        setTextStartDate(data.get("START DATE"));
        setTextEndtDate(data.get("END DATE"));
        WebUI.selectOption(selectProject,data.get("PROJECT"));
        setTextAddSummary(data.get("SUMMARY"));
        setTextDescription(data.get("DESCRIPTION"));
        clickButtonSave();
        return this;
    }
    public TaskPage verifyAddNewTask(Hashtable<String, String> data){
        setTextInputSearch(data.get("TITLE"));
        WebUI.checkDataInTableByColumn_Contains(1, data.get("TITLE"), "Project title", "//div[@id='xin_table_wrapper']");
        return this;
    }

    public TaskPage editTask(Hashtable<String,String> data){
        setTextInputSearch(data.get("TITLE"));
        clickButtonViewDtails();
        clickButtonEditTab();
        WebUI.waitForPageLoaded();
        selectOptionTeam(data.get("TEAM"));
        setTextAddSummary(data.get("SUMMARY")+"eidted");
        setTextDescription(data.get("DESCRIPTION")+"eidted");
        WebUI.clickElement(buttonUpdateTask);
        verifyContentMessage(messageUpdateSuccess);
        return this;
    }
    public TaskPage verifyEditTask(Hashtable<String,String> data){
        setTextInputSearch(data.get("TITLE"));
        clickButtonViewDtails();
        clickButtonEditTab();
        WebUI.sleep(2);
        SoftAssert softAssert = new SoftAssert();
        WebUI.softAssertEquals(softAssert,data.get("TEAM"),WebUI.getTextFirstOption(selectTeam),"The Team does not match!");
        WebUI.softAssertEquals(softAssert,data.get("SUMMARY")+"eidted",WebUI.getTextElement(inputUpdateSummary),"The summary does not match!");
        WebUI.goToIframe(iframeDescription);
        WebUI.softAssertEquals(softAssert,data.get("DESCRIPTION")+"eidted",WebUI.getTextElement(inputDescription),"The Description does not match!");
        WebUI.exitIframe();
        WebUI.softAssertAll(softAssert);
        return this;
    }

    public TaskPage deleteTask(Hashtable<String,String> data){
        setTextInputSearch(data.get("TITLE"));
        clickButtonFirstDelete();
        clickButtonConfirm();
        return this;
    }
    public TaskPage verifyDeleteTask(){
        verifyContentMessage("Task deleted.");
        return this;
    }

}
