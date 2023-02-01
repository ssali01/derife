package com.derivfe.pages;

import com.derivfe.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    // env = https://derivfe.github.io/qa-test/

    @FindBy(xpath = "https://derivfe.github.io/qa-test/")
    public WebElement binaryOptions;

    @FindBy(xpath = "//a[.='Markets']")
    public WebElement marketsOptions;

    @FindBy(xpath = "//a[.='Settings']")
    public WebElement settingsOption;

    @FindBy(xpath = "//a[.=' Contact Us ']")
    public WebElement contactUsOption;

    @FindBy(xpath = "//a[.='Terms']")
    public WebElement termsButton;


}

