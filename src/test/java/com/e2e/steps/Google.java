package com.e2e.steps;

import com.e2e.actions.GooglePageActions;
import com.e2e.utils.DriverUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Google {
    GooglePageActions googlePageActions = new GooglePageActions();

    @Given("user launches google")
    public void launch(){
            googlePageActions.launch();
    }

    @When("user types in search query as {string}")
    public void userTypesInSearchQueryAs(String query) {
        googlePageActions.search(query);
    }

    @And("user hits enter")
    public void userHitsEnter() {
        Actions actions = new Actions(DriverUtil.getDriver());
        actions.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
    }

    @Then("search results should be displayed")
    public void searchResultsShouldBeDisplayed() {
        Assert.assertTrue( googlePageActions.getResultsCount()>0,"Search results not returned");
    }

    @Then("search results should not be displayed")
    public void searchResultsShouldNotBeDisplayed() {
        Assert.assertTrue( googlePageActions.getResultsCount()==0,"Search results are displayed");
    }
}
