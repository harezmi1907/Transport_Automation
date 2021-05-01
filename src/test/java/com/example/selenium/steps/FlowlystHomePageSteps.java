package com.example.selenium.steps;

import com.example.selenium.helpers.VisibilityHelper;
import com.example.selenium.pages.FlowlystHomePage;
import com.example.selenium.runners.Hook;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.example.selenium.helpers.JsonMapper.getRandomStudentData;
import static com.example.selenium.helpers.JsonMapper.mapJson;


public class FlowlystHomePageSteps {
    @Autowired
    private FlowlystHomePage homePage;

    @Autowired
    private VisibilityHelper visibilityHelper;

    @Autowired
    private Hook hooks;

    @When("I fill out the form for <free> or <paid> student")
    public void i_fill_out_the_form_for_free_or_paid_student(DataTable dataTable) throws IOException {
        Map<String, String> status = dataTable.asMap(String.class, String.class);
        String freeCount = status.get("free");
        String paidCount = status.get("paid");
        System.out.println("Free:" + freeCount + "\nPaid:" + paidCount);

        List<Map<String, String>> freeStudents = getRandomStudentData(Integer.parseInt(freeCount), "free");
        List<Map<String, String>> paidStudents = getRandomStudentData(Integer.parseInt(paidCount), "free");


        System.out.println("Free Students:\n");
        System.out.println(freeStudents);

        System.out.println("Paid Students:\n");
        System.out.println(paidStudents);
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
