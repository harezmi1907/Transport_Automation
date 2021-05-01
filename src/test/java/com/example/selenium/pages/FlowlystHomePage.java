package com.example.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlowlystHomePage implements BasePage{

    @FindBy(how = How.ID, using = "fname")
    public WebElement firstName;



    @FindBy(how = How.ID, using = "mName")
    public WebElement middleName;

    @FindBy(how = How.ID, using = "lname")
    public WebElement lastName;

    @FindBy(how = How.ID, using = "birthDate")
    public WebElement dob;

    @FindBy(how = How.ID, using = "school")
    public WebElement school;

    @FindBy(how = How.ID, using = "grade")
    public WebElement grade;

    @FindBy(how = How.CSS, using = "[class=\"rbt-input-main form-control rbt-input\"]")
    public WebElement address;

    @FindBy(how = How.ID, using = "address-item-0")
    public WebElement addressItem0;

    @FindBy(how = How.ID, using = "parentName")
    public WebElement parentName;

    @FindBy(how = How.ID, using = "parentEmailAddress")
    public WebElement parentEmailAddress;

    @FindBy(how = How.ID, using = "parentPhoneNumber")
    public WebElement parentPhoneNumber;

}
