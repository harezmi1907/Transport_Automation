package com.example.selenium.steps;

import com.example.selenium.helpers.VisibilityHelper;
import com.example.selenium.pages.FlowlystHomePage;
import com.example.selenium.runners.Hook;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;



public class FlowlystHomePageSteps {
    @Autowired
    private FlowlystHomePage homePage;

    @Autowired
    private VisibilityHelper visibilityHelper;

    @Autowired
    private Hook hooks;

    @Given("I enter the first name")
    public void i_enter_the_first_name() {
        homePage.firstName.sendKeys("Akif");
    }

    @Then("I enter the middle initial")
    public void i_enter_the_middle_initial() {
        homePage.middleName.sendKeys("luli");

    }

    @Then("I enter last name")
    public void i_enter_last_name() {
       homePage.lastName.sendKeys("Mireliyev");
    }

    @Then("I enter date of birth")
    public void i_enter_date_of_birth() {
       homePage.dob.sendKeys("05/26/2012");
    }

    @Then("I pick a school")
    public void i_pick_a_school() throws InterruptedException {
        Select school = new Select(homePage.school);
        school.selectByValue("RSS");
    }

    @Then("I pick a grade")
    public void i_pick_a_grade() throws InterruptedException {
        Select grade = new Select(homePage.grade);
        grade.selectByValue("3");
    }

    @Then("I enter address")
    public void i_enter_address() {
        homePage.address.sendKeys("20 PORTER RD");
        homePage.addressItem0.click();
    }





}
