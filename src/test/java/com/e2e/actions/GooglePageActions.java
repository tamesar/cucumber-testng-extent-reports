package com.e2e.actions;

import com.e2e.utils.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class GooglePageActions {

    @FindBy(name="q")
    public WebElement searchBox;

    @FindBy(css = "#search a h3")
    public List<WebElement> searchResults;

    public GooglePageActions(){
        PageFactory.initElements(DriverUtil.getDriver(),this);
    }

    public void launch(){
        DriverUtil.getDriver().get("https://www.google.com");
    }

    public void search(String query){
        DriverUtil.getWait().until(ExpectedConditions.visibilityOf(searchBox));
        this.searchBox.sendKeys(query);
    }

    public int getResultsCount(){
        return this.searchResults.size();
    }
}
