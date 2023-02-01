package com.derivfe.step_definitions;

import com.derivfe.pages.SettingsPage;
import com.derivfe.utilities.BrowserUtils;
import com.derivfe.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Settings_Step_Defs {
    SettingsPage settingsPage = new SettingsPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),40);
    Faker faker = new Faker();

    @When("fill out the First and Last names lines")
    public void fill_out_the_first_and_last_names_lines() {

        settingsPage.settingsOption.click();
        wait.until(ExpectedConditions.elementToBeClickable(settingsPage.firstName));

        settingsPage.firstName.sendKeys(faker.name().firstName());
        wait.until(ExpectedConditions.elementToBeClickable(settingsPage.lastName));

        settingsPage.lastName.sendKeys(faker.name().lastName());
        BrowserUtils.sleep(2);
    }


    @And("fill out the Phone Number")
    public void fillOutThePhoneNumber() {
        settingsPage.phoneNumberCell.sendKeys(faker.number().digits(15));
        BrowserUtils.sleep(3);
        settingsPage.updateProfileBtn.click();
        BrowserUtils.sleep(3);

    }
    @Then("it should be in the following format {string}")
    public void itShouldBeInTheFollowingFormat() {

        Assert.assertFalse(Boolean.parseBoolean(settingsPage.phoneNumberCell.getText()));
    }

    @Then("{string} should start from Capital letter")
    public void should_start_from_capital_letter(String firstName) {
        String expectedFirst = firstName.substring(0, 1).toLowerCase();
        BrowserUtils.sleep(3);
        Assert.assertFalse(firstName.startsWith(expectedFirst));
    }

    @Then("phone number should be in the following format {string}")
    public void phone_number_should_be_in_the_following_format(String lastName) {
        String expectedLast = lastName.substring(0, 1).toUpperCase();
        BrowserUtils.sleep(3);
        Assert.assertFalse(lastName.startsWith(expectedLast));
    }



}
