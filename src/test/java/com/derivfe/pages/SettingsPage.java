package com.derivfe.pages;

import com.derivfe.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage extends BasePage{

    public SettingsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='fname']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='lname']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='tel']")
    public WebElement phoneNumberCell;

    @FindBy(xpath = "//button[.='Update profile']")
    public WebElement updateProfileBtn;


}
