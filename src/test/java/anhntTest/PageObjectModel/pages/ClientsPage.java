package anhntTest.PageObjectModel.pages;

import anhntTest.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;

import java.util.Hashtable;

public class ClientsPage extends CommonPage {
    private By inputFistName = By.xpath("//input[@name='first_name']");
    private By inputLastName = By.xpath("//input[@name='last_name']");
    private By inputpassword = By.xpath("//input[@name='password']");
    private By inputContact = By.xpath("//input[@name='contact_number']");
    private By buttonSelectGender = By.xpath("//span[contains(@id,'gender')]");
    private By inputSearchGender = By.xpath("//input[@type='search' and @role='searchbox']");
    private By inputEmail = By.xpath("//input[@name='email']");
    private By inputUsername = By.xpath("//input[@name='username']");
    private By inputProfilePicture = By.xpath("//input[@name='file']");
    private By selectCountry = By.xpath("//select[@data-placeholder='Country']");
    private By inputAddress1 = By.xpath("//label[normalize-space()='Address']//following-sibling::input[@name='address_1']");
    private By inputAddress2 = By.xpath("//input[@name='address_2']");
    private By inputCity= By.xpath("//input[@name='city']");
    private By inputState = By.xpath("//input[@name='state']");
    private By inputZipCode = By.xpath("//input[@name='zipcode']");


    String messageUpdateClientSuccess = "Client updated.";
    String messageDeleteClientSuccess ="Client deleted.";


    public ClientsPage enterAddNewClient(Hashtable<String, String> data) {
        clickButtonAddNew();
        WebUI.setText(inputFistName, data.get("FIRST NAME"));
        WebUI.setText(inputLastName, data.get("LAST NAME"));
        WebUI.setText(inputpassword, data.get("PASSWORD"));
        WebUI.setText(inputContact, data.get("CONTACT"));
        WebUI.clickElement(buttonSelectGender);
        WebUI.setText(inputSearchGender, data.get("GENDER") + Keys.ENTER);
        WebUI.setText(inputEmail, data.get("EMAIL"));
        WebUI.setText(inputUsername, data.get("USERNAME"));
        WebUI.setText(inputProfilePicture, data.get("IMAGE"));
        clickButtonSave();
        return this;
    }

    public ClientsPage enterEditClient(Hashtable<String, String> data) {
        setTextInputSearch(data.get("USERNAME"));
        clickButtonViewDtails();
        WebUI.sleep(2);
        WebUI.selectOption(selectCountry, data.get("COUNTRY"));
        WebUI.sleep(2);
        WebUI.clearAndSetText(inputAddress1, data.get("ADDRESS"));
        WebUI.clearAndSetText(inputAddress2, data.get("ADDRESS 2"));
        WebUI.clearAndSetText(inputCity, data.get("CITY"));
        WebUI.clearAndSetText(inputState, data.get("STATE"));
        WebUI.clearAndSetText(inputZipCode, data.get("ZIP"));
        clickButtonSave();
        verifyContentMessage(messageUpdateClientSuccess);
        return this;
    }
    public ClientsPage verifyEditClient(Hashtable<String, String> data){
        setTextInputSearch(data.get("USERNAME"));
        clickButtonViewDtails();
        WebUI.sleep(2);
        SoftAssert softAssert = new SoftAssert();
        WebUI.softAssertEquals(softAssert,data.get("COUNTRY"),WebUI.getTextFirstOption(selectCountry), "The Country name has not been edited!");
        WebUI.softAssertEquals(softAssert,data.get("ADDRESS"),WebUI.getElementAttribute(inputAddress1,"value"),"The address name has not been edited!");
        WebUI.softAssertEquals(softAssert,data.get("ADDRESS 2"),WebUI.getElementAttribute(inputAddress2,"value"),"The address 2 name has not been edited!");
        WebUI.softAssertEquals(softAssert,data.get("CITY"),WebUI.getElementAttribute(inputCity,"value"),"The city name has not been edited!");
        WebUI.softAssertEquals(softAssert,data.get("STATE"),WebUI.getElementAttribute(inputState,"value"),"The state name has not been edited!");
        WebUI.softAssertEquals(softAssert,data.get("ZIP"),WebUI.getElementAttribute(inputZipCode,"value"),"The zip code name has not been edited!");
        WebUI.softAssertAll(softAssert);
        return this;
    }

    public ClientsPage deleteClient(Hashtable<String, String> data) {
        setTextInputSearch(data.get("USERNAME"));
        clickButtonFirstDelete();
        clickButtonConfirm();
        verifyContentMessage(messageDeleteClientSuccess);
        return this;
    }



    public ClientsPage verifyAddNewClient(Hashtable<String, String> data) {
        /*verifyContentMessage("Client added.");*/
        setTextInputSearch(data.get("USERNAME"));
        WebUI.sleep(2);
        WebUI.checkDataInTableByColumn_Contains(2, data.get("USERNAME"), "User name","");
        return this;
    }
    public ClientsPage checkDeleteClient(Hashtable<String, String> data){
        setTextInputSearch(data.get("USERNAME"));
        checkNoRecordsAvailable();
        return this;
    }

}
