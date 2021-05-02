package com.example.selenium.pages;

import com.example.selenium.runners.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlowlystHomePage implements BasePage{

    @Autowired
    private Hook hooks;

    @FindBy(id = "fname")
    public WebElement firstName;

    @FindBy(id = "mName")
    public WebElement middleName;

    @FindBy(id = "lname")
    public WebElement lastName;

    @FindBy(id = "birthDate")
    public WebElement dob;

    @FindBy(id = "school")
    public WebElement school;

    @FindBy(id = "grade")
    public WebElement grade;

    @FindBy(css = "[class=\"rbt-input-main form-control rbt-input\"]")
    public WebElement address;

    @FindBy(id = "address-item-0")
    public WebElement addressItem0;

    @FindBy(id = "parentName")
    public WebElement parentName;

    @FindBy(id = "parentEmailAddress")
    public WebElement parentEmailAddress;

    @FindBy(id = "parentPhoneNumber")
    public WebElement parentPhoneNumber;

    @FindBy(css = "[value='Add Sibling']")
    public WebElement addSibling;

    public List<WebElement> siblingElements(int row) {
        return hooks.getDriver().findElements(By.cssSelector("[counter='"+row+"'] input, [counter='"+row+"'] select"));
    }

    @FindBy(css = "[value='Continue']")
    public WebElement continueButton;

    @FindBy(css = "[value='Complete Registration']")
    public WebElement submit;
}
