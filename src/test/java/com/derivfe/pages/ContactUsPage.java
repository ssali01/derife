package com.derivfe.pages;

import com.derivfe.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends BasePage{
public ContactUsPage(){
    PageFactory.initElements(Driver.getDriver(), this);
}
    @FindBy(xpath = "//input[@id='phone']")
    public WebElement phone;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement name;

    @FindBy(xpath = "//button[.='Send']")
    public WebElement sendButton;








}
