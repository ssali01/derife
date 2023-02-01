package com.derivfe.step_definitions;
import com.derivfe.pages.BasePage;
import com.derivfe.pages.MarketsPage;
import com.derivfe.utilities.BrowserUtils;
import com.derivfe.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MarketsOpt_Step_Defs {

    MarketsPage marketsPage = new MarketsPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),40);
    @When("User sees the Markets option")
    public void user_sees_the_markets_option() {
        BrowserUtils.hover(marketsPage.marketsOptions);
        marketsPage.termsButton.click();
        BrowserUtils.sleep(3);
    }

    @When("User clicks on {string} option")
    public void user_clicks_on_option(String expectedTitle) {
        Assert.assertFalse(Driver.getDriver().getTitle().contains(expectedTitle));
    }
}
