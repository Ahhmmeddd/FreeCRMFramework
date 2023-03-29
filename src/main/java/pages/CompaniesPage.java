package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CompaniesPage extends PageBase{
    public CompaniesPage(WebDriver driver) {
        super(driver);
        action = new Actions(driver);
    }

    @FindBy(xpath = "//a[@title='Companies']")
    WebElement companiesLink;
    @FindBy(name = "cs_status")
    WebElement status;
    @FindBy(name = "cs_category")
    WebElement category;
    @FindBy(name = "cs_name")
    WebElement companyName;
    @FindBy(name = "cs_extended")
    WebElement extendedFieldsTxtBox;
    @FindBy(name = "cs_notes")
    WebElement notesTxtBox;
    @FindBy(name = "client_lookup")
    WebElement parentCompanyTxtBox;
    @FindBy(name = "cs_website")
    WebElement companiescheckBox;
    @FindBy(name = "tag")
    WebElement tagsTxtBox;
    @FindBy(name = "cs_priority")
    WebElement priority;
    @FindBy(name = "cs_address")
    WebElement fullAdressTxtBox;
    @FindBy(name = "cs_address_type")
    WebElement adressTybe;
    @FindBy(name = "cs_saved_search_id")
    WebElement savedSearches;
    @FindBy(name = "cs_save_search")
    WebElement saveSearch;
    @FindBy(css = "input.button")
    WebElement searchButton;

    public void userOpenCompany(String name,String extendedFields,String notes,String parentCompany,String tags,String fullAdress)
    {
        clickButton(companiesLink);
        select = new Select(status);
        select.selectByValue("Active");
        select = new Select(category);
        select.selectByValue("Partner");
        setTextElementText(companyName,name);
        setTextElementText(extendedFieldsTxtBox,extendedFields);
        setTextElementText(notesTxtBox,notes);
        setTextElementText(parentCompanyTxtBox,parentCompany);
        clickButton(companiescheckBox);
        setTextElementText(tagsTxtBox,tags);
        select=new Select(priority);
        select.selectByValue("Low");
        setTextElementText(fullAdressTxtBox,fullAdress);
        select = new Select(adressTybe);
        select.selectByValue("S");
        select = new Select(savedSearches);
        select.selectByValue("36551");
        clickButton(saveSearch);
        clickButton(searchButton);




    }

}
