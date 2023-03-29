package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DocumentsPage extends PageBase{
    public DocumentsPage(WebDriver driver) {
        super(driver);
        action = new Actions(driver);
    }
    @FindBy(xpath = "//a[@title='Docs']")
    WebElement DocsLink;
    @FindBy(xpath = "//a[@title='New Document']")
    WebElement NewDocumentLink;
    @FindBy(name = "title")
    WebElement titleTB;
    @FindBy(name = "description")
    WebElement descriptionTB;
    @FindBy(name = "version")
    WebElement versionTB;
    @FindBy(name = "overwrite")
    WebElement overwriteRadioBTN;
    @FindBy(name = "contact_lookup")
    WebElement contactTB;
    @FindBy(name = "client_lookup")
    WebElement companyTB;
    @FindBy(name = "prospect_lookup")
    WebElement prospectTB;
    @FindBy(name = "task_lookup")
    WebElement taskTB;
    @FindBy(name = "case_lookup")
    WebElement caseTB;
    @FindBy(name = "tags")
    WebElement tagsTB;
    @FindBy(css = "input.button")
    WebElement saveBTN;
    @FindBy(xpath = "//a[@title='New Directory']")
    WebElement NewDirectoryLink;
    @FindBy(name = "directory")
    WebElement directoryTB;
    @FindBy(name = "description")
    WebElement descriptionTXTBOX;
    @FindBy(css = "input.button")
    WebElement saveButton;
    @FindBy(linkText = "Mokhtar//Documents")
    public WebElement directoryFolder;




    public void userCanClickOnNewDocumentLink(String title,String description,String version,String contact,String company,
                                              String prospect,String task,String case1,String tags)
    {
        action.moveToElement(DocsLink).click(NewDocumentLink).build().perform();
        setTextElementText(titleTB,title);
        setTextElementText(descriptionTB,description);
        setTextElementText(versionTB,version);
        clickButton(overwriteRadioBTN);
        setTextElementText(contactTB,contact);
        setTextElementText(companyTB,company);
        setTextElementText(prospectTB,prospect);
        setTextElementText(taskTB,task);
        setTextElementText(caseTB,case1);
        setTextElementText(tagsTB,tags);
        clickButton(saveBTN);

    }
    public void userCanClicOnNewDirectoryLink(String directory,String description)
    {
        action.moveToElement(DocsLink).click(NewDirectoryLink).build().perform();
        setTextElementText(directoryTB,directory);
        setTextElementText(descriptionTXTBOX,description);
        clickButton(saveButton);
    }


}
