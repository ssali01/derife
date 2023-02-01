package com.derivfe.step_definitions;

import com.derivfe.pages.ContactUsPage;
import com.derivfe.utilities.BrowserUtils;
import com.derivfe.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;


public class ContactUs_Steps_Defs {
    ContactUsPage contactUsPage = new ContactUsPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 40);
    Faker faker = new Faker();

    @When("User fills out the Name line,")
    public void user_fills_out_the_name_line() {
        contactUsPage.name.click();

        contactUsPage.name.sendKeys(faker.name().firstName());
        wait.until(ExpectedConditions.elementToBeClickable(contactUsPage.phone));

    }

    @When("User fills out the Phone Number line")
    public void user_fills_out_the_phone_number_line() {
        contactUsPage.phone.sendKeys(faker.letterify("fwgfwefgwfewgvw"));
        BrowserUtils.sleep(2);
    }

    @Then("{string} should be only in digits format")
    public void should_be_only_in_digits_format(String digitFormat) {

        for (int i = 0; i < digitFormat.length(); i++) {

            ArrayList<Integer> digits = new ArrayList();

            if (i >= 0 && i <= 9) {
                digits.add(i);
            } else {
                System.out.println("This must be digits only");
                break;
            }

        }

    }

    @Then("Phone Number should be in the following format {string}")
    public void phoneNumberShouldBeInTheFollowingFormat(String expectedFormat) {

        while (!expectedFormat.isEmpty()) {

            System.out.println(String.valueOf(expectedFormat).replaceFirst("(\\d{4})(\\d{3})(\\d{4})", "$1-$2-$3"));
            String phone = String.valueOf(expectedFormat).replaceFirst("(\\d{4})(\\d{3})(\\d{4})", "$1-$2-$3");
            ArrayList<Long> a = new ArrayList<>();
            for (Long each : a){
                a.add(each);
                Assert.assertNotEquals(expectedFormat, a);
            }
            break;
        }

    }
}

