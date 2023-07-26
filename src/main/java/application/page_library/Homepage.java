package application.page_library;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Base {

    @FindBy (id = "gh-ac")
    WebElement searchBar;

    @FindBy (id = "gh-btn")
    WebElement searchButton;

    public Homepage(){
        PageFactory.initElements(driver,this);
    }

    public void inputSearchText(String searchTerm){
        searchBar.sendKeys(searchTerm);
    }
    public void clickSearchButton(){
        searchButton.click();
    }
    public SearchResultsPage doSearch(String searchTerm){
        inputSearchText(searchTerm);
        clickSearchButton();

        return new SearchResultsPage();

    }

}
