package com.example.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class FlowlystHomePage implements BasePage{

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

}
