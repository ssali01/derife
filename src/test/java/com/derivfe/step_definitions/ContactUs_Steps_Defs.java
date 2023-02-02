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

/**
 * JavaFaker was used to pass on some test data
 * Explicit wait used to handle synchronization issues
 * POM Design Pattern was used to associate related webElements
 */

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


    /**
     * random characters were passed on <Phone number line> for negative testing
     * sleep() from BrowserUtils was used just to show as one of the variations of implicit wait
     * ..not recommended though
     * for loop and if statement were used to be able to ensure only digits input
     */
    @When("User fills out the Phone Number line")
    public void user_fills_out_the_phone_number_line() {
        contactUsPage.phone.sendKeys(faker.letterify("fwgfwefgwfewgvw"));

        BrowserUtils.sleep(2);

    }

    @Then("{string} should be only in digits format")
    public void should_be_only_in_digits_format(String digitFormat) {

        for (int i = 0; i < digitFormat.length(); i++) {
            ArrayList<Integer> digits = new ArrayList<>();
            if (i <= 9) {
                digits.add(i);
                String actualInput = contactUsPage.phone.getText();
                Assert.assertFalse(actualInput, Boolean.parseBoolean(digitFormat));
            } else {
                System.out.println("This must be digits only");
                break;
            }

        }

    }

    /**
     * regex method was used to be able to achieve particular format, it is possible to
     * loop it through adn stored in ArrayList for further assertion
     * assertion should fail if the input does not equal to expected
     */
    @Then("Phone Number should be in the following format {string}")
    public void phoneNumberShouldBeInTheFollowingFormat(String expectedFormat) {
        while (contactUsPage.phone.isSelected()) {
            contactUsPage.phone.sendKeys(faker.letterify("fwgfwefgwfewgvw"));
            String actualInput = contactUsPage.phone.getText();

            if (!actualInput.contains("a-z") && actualInput.contains(")(*&^%$#@!")){
                Assert.assertEquals(expectedFormat, actualInput);

            }else{
                break;
            }

        }


    }
}




















// while (!expectedFormat.isEmpty()) {
//
//         System.out.println(expectedFormat.replaceFirst("(\\d{4})(\\d{3})(\\d{4})", "$1-$2-$3"));
//         String phone = expectedFormat.replaceFirst("(\\d{4})(\\d{3})(\\d{4})", "$1-$2-$3");
//         ArrayList<Long> userInput = new ArrayList<>();
//        for (Long each : userInput){
//        userInput.add(each);
//        if (phone.equals(userInput))
//        Assert.assertNotEquals(expectedFormat, userInput);
//        }
//        break;
//        }

//     while(!phone.isEmpty()){
//
//             ArrayList<String> userInput = new ArrayList<>();
//
//        for (String each : userInput){
//        userInput.add(each);
//
//        if (userInput.equals(phone)){
//        Assert.assertNotEquals(phone, userInput);
//
//        }
//        break;
//        }
