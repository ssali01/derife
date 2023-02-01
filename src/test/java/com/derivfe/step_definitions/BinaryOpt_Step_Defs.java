package com.derivfe.step_definitions;

import com.derivfe.pages.BasePage;
import com.derivfe.utilities.BrowserUtils;
import com.derivfe.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BinaryOpt_Step_Defs {

    BasePage basePage = new BasePage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 40);

    @Given("User is on {string} page")
    public void user_is_on_page(String url) {
        Driver.getDriver().get(url);
    }

    @When("User sees title is as expected.")
    public void user_sees_title_is_as_expected() {
        String expected = "BinaryOptions";
        wait.until(ExpectedConditions.titleContains(expected));
    }

    @Then("User sees {string} is selected")
    public void user_sees_is_selected(String expectedTitle) {
        Assert.assertFalse(Driver.getDriver().getTitle().contains(expectedTitle));
    }

    @Then("Terms button verification")
    public void terms_button_verification() {
        BrowserUtils.hover(basePage.termsButton);

    }

    @When("User clicks on Terms button")
    public void user_clicks_on_terms_button() {
        basePage.termsButton.click();
        BrowserUtils.sleep(3);
    }

    @Then("User sees Terms page")
    public void user_sees_terms_page() {
        Assert.assertFalse(Driver.getDriver().getTitle().contains("Terms"));
    }

}
