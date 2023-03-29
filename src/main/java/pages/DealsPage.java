package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class DealsPage extends PageBase{
    public DealsPage(WebDriver driver) {
        super(driver);
        action = new Actions(driver);
    }
    @FindBy(xpath = "//a[@title='Deals']")
    WebElement DealsLink;
    @FindBy(xpath = "//a[@title='New Deal']")
    WebElement NewDealLink;
    @FindBy(name = "title")
    WebElement titletxtBox;
    @FindBy(name = "client_lookup")
    WebElement companyNameTxtBox;
    @FindBy(name = "contact_lookup")
    WebElement primaryContacttxtBox;
    @FindBy(name = "amount")
    WebElement amounttxtBox;
    @FindBy(name = "probability")
    WebElement probabilityTxtBox;
    @FindBy(name = "commission")
    WebElement commissionTxtBox;
    @FindBy(name = "identifier")
    WebElement identifierTxtBox;
    @FindBy(name = "tags")
    WebElement tagstxtBox;
    @FindBy(name = "description")
    WebElement descriptionTxtBox;
    @FindBy(name = "next_step")
    WebElement nextStepTxtBox;
    @FindBy(name = "quantity")
    WebElement quantityTxtBox;
    @FindBy(name = "type")
    WebElement type;
    @FindBy(name = "source")
    WebElement source;
    @FindBy(name = "closed")
    WebElement statusRadioBtn;
    @FindBy(name = "close_date")
    WebElement closeDateTxtBox;
    @FindBy(name = "actual_close_date")
    WebElement actualCloseDatetxtBox;
    @FindBy(name = "exclude_reports")
    WebElement reportsRadioBtn;
    @FindBy(xpath = "//a[@href='https://classic.freecrm.com/system/index.cfm?action=user&sub=fieldset&field_set_name=PROSPECT_STAGE']")
    WebElement AddStageLink;
    @FindBy(name = "update_records")
    WebElement updateAllRelatedRadioBtn;
    @FindBy(name = "key_1")
    WebElement keyTxtBox;
    @FindBy(name = "weight_1")
    WebElement weightTxtBox;
    @FindBy(css = "input.button")
    WebElement saveBtn;
    @FindBy(css = "td.datacardtitle")
    public WebElement fieldSets;


    public void userCanOpenNewDealPage()
    {
        action
                .moveToElement(DealsLink).click(NewDealLink).build().perform();
    }

    public void userCreateDeal(String title,String company,String primaryContact,String amount,String probability
            ,String commission,String identifier,String tags,String description,String nextStep,String quantity
            ,String closeDate,String actualCloseDate,String key,String weightT)
    {
        setTextElementText(titletxtBox,title);
        setTextElementText(companyNameTxtBox,company);
        setTextElementText(primaryContacttxtBox,primaryContact);
        setTextElementText(amounttxtBox,amount);
        setTextElementText(probabilityTxtBox,probability);
        setTextElementText(commissionTxtBox,commission);
        setTextElementText(identifierTxtBox,identifier);
        setTextElementText(tagstxtBox,tags);
        setTextElementText(descriptionTxtBox,description);
        setTextElementText(nextStepTxtBox,nextStep);
        setTextElementText(quantityTxtBox,quantity);
        select = new Select(type);
        select.selectByValue("New");
        select = new Select(source);
        select.selectByValue("Partner");
        clickButton(statusRadioBtn);
        setTextElementText(closeDateTxtBox,closeDate);
        setTextElementText(actualCloseDatetxtBox,actualCloseDate);
        clickButton(reportsRadioBtn);
        clickButton(AddStageLink);
        clickButton(updateAllRelatedRadioBtn);
        setTextElementText(keyTxtBox,key);
        setTextElementText(weightTxtBox,weightT);
        clickButton(saveBtn);

    }





}
