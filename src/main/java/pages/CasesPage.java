package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CasesPage extends PageBase{
    public CasesPage(WebDriver driver) {
        super(driver);
        action = new Actions(driver);
        jse = (JavascriptExecutor) driver;
    }
    @FindBy(xpath = "//a[@title='Cases']")
    WebElement casesLink;
    @FindBy(xpath = "//a[@title='New Case']")
    WebElement NewCaseLink;
    @FindBy(name = "title")
    WebElement titletxtBox;
    @FindBy(name = "status")
    WebElement status;
    @FindBy(name = "deadline")
    WebElement deadlineList;
    @FindBy(name = "closed")
    WebElement stateRadioBTN;
    @FindBy(name = "close_date")
    WebElement close_date;
    @FindBy(name = "identifier")
    WebElement identifiertxtBox;
    @FindBy(name = "tags")
    WebElement tagsTxtBox;
    @FindBy(name = "description")
    WebElement descriptionTxtBox;
    @FindBy(name = "type")
    WebElement typeList;
    @FindBy(name = "priority")
    WebElement priorityList;
    @FindBy(name = "email_notification")
    WebElement email_notificationRadioBTN;
    @FindBy(name = "contact_lookup")
    WebElement contactTxtBox;
    @FindBy(name = "client_lookup")
    WebElement keyCompanyTxtBox;
    @FindBy(css = "input.button")
    WebElement SaveBTN;
    @FindBy(css = "td.tabs_header")
    public WebElement titleOfAnewCase;
    @FindBy(xpath = "//a[@href='https://classic.freecrm.com/system/index.cfm?action=case&sub=search']")
    WebElement FullSearchFormLink;
    @FindBy(name = "cs_keyword")
    WebElement titleTB;
    @FindBy(name = "cs_closed")
    WebElement stateList;
    @FindBy(name = "cs_deadline")
    WebElement deadLine;
    @FindBy(name = "cs_created_at_from")
    WebElement Creationdate1;
    @FindBy(name = "cs_created_at_to")
    WebElement Creationdate2;
    @FindBy(name = "cs_last_modified_from")
    WebElement Modifieddate1;
    @FindBy(name = "cs_last_modified_to")
    WebElement Modifieddate2;
    @FindBy(name = "cs_close_date")
    WebElement Closedate;
    @FindBy(name = "tag")
    WebElement tagsTB;
    @FindBy(name = "cs_notes")
    WebElement cs_notes;
    @FindBy(name = "cs_search_extended")
    WebElement cs_search_extendedRaBtn;
    @FindBy(name = "cs_save_search")
    WebElement saveSearchradioBtn;
    @FindBy(name = "cs_search_title")
    WebElement searchTitle;
    @FindBy(name = "cs_priority")
    WebElement cs_priorityList;
    @FindBy(name = "cs_status")
    WebElement cs_statusList;
    @FindBy(name = "cs_type")
    WebElement cs_typeList;
    @FindBy(name = "cs_identifier")
    WebElement cs_identifierTB;
    @FindBy(name = "cs_company_name")
    WebElement cs_company_nameTB;
    @FindBy(name = "cs_contact_name")
    WebElement cs_contact_nameTB;


    public void userCanClickOnNewCaseLink()
    {
        action.moveToElement(casesLink).click(NewCaseLink).build().perform();
    }
    public void userCanEnterdCaseInformation(String title,String identifier,String tags,String description,String contact,
                                             String keyCompany)
    {
        setTextElementText(titletxtBox,title);
        select = new Select(status);
        select.selectByValue("Reviewing");
        jse.executeScript("arguments[0].setAttribute('value','" + "15-06-2023" + "')", deadlineList);
        clickButton(stateRadioBTN);
        jse.executeScript("arguments[0].setAttribute('value','" + "20-08-2023" + "')", close_date);
        setTextElementText(identifiertxtBox,identifier);
        setTextElementText(tagsTxtBox,tags);
        setTextElementText(descriptionTxtBox,description);
        select = new Select(typeList);
        select.selectByValue("General Support");
        select = new Select(priorityList);
        select.selectByValue("Normal");
        clickButton(email_notificationRadioBTN);
        setTextElementText(contactTxtBox,contact);
        setTextElementText(keyCompanyTxtBox,keyCompany);
        clickButton(SaveBTN);
    }
    public void userCanClickOnFullSearchFrom()
    {
        action.moveToElement(casesLink).click(FullSearchFormLink).build().perform();
    }
    public void userCanEnteredSearchCase(String title,String tags,String notes,String search,String cs_identifier
            ,String cs_company_name,String cs_contact_name)
    {
        setTextElementText(titleTB,title);
        select = new Select(stateList);
        select.selectByValue("Y");
        jse.executeScript("arguments[0].setAttribute('value','" + "10-10-2023" + "')", deadLine);
        jse.executeScript("arguments[0].setAttribute('value','" + "20-10-2023" + "')", Creationdate1);
        jse.executeScript("arguments[0].setAttribute('value','" + "20-04-2023" + "')", Creationdate2);
        jse.executeScript("arguments[0].setAttribute('value','" + "20-09-2023" + "')", Modifieddate1);
        jse.executeScript("arguments[0].setAttribute('value','" + "08-09-2023" + "')", Modifieddate2);
        jse.executeScript("arguments[0].setAttribute('value','" + "15-01-2023" + "')", Closedate);
        setTextElementText(tagsTB,tags);
        setTextElementText(cs_notes,notes);
        clickButton(cs_search_extendedRaBtn);
        clickButton(saveSearchradioBtn);
        setTextElementText(searchTitle,search);
        select = new Select(cs_priorityList);
        select.selectByValue("High");
        select = new Select(cs_statusList);
        select.selectByValue("Awaiting input");
        select=new Select(cs_typeList);
        select.selectByValue("Complaint");
        setTextElementText(cs_identifierTB,cs_identifier);
        setTextElementText(cs_company_nameTB,cs_company_name);
        setTextElementText(cs_contact_nameTB,cs_contact_name);

    }


}
