package com.example.selenium.steps;

import com.example.selenium.helpers.VisibilityHelper;
import com.example.selenium.pages.FlowlystHomePage;
import com.example.selenium.runners.Hook;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
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

    List<Map<String, String>> freeStudents;
    List<Map<String, String>> paidStudents;
    String freeCount;
    String paidCount;

    @When("I fill out the form for <free> or <paid> student")
    public void i_fill_out_the_form_for_free_or_paid_student(DataTable dataTable) throws IOException {
        Map<String, String> status = dataTable.asMap(String.class, String.class);
        freeCount = status.get("free");
        paidCount = status.get("paid");
        System.out.println("Free:" + freeCount + "\nPaid:" + paidCount);

        freeStudents = getRandomStudentData(Integer.parseInt(freeCount), "free");
        paidStudents = getRandomStudentData(Integer.parseInt(paidCount), "paid");


        System.out.println("Free Students:\n");
        System.out.println(freeStudents);

        System.out.println("Paid Students:\n");
        System.out.println(paidStudents);
    }


    @Then("I enter first name")
    public void i_enter_first_name() {
        homePage.firstName.sendKeys(freeStudents.get(0).get("fname"));

    }

    @Then("I enter the middle initial")
    public void i_enter_the_middle_initial() {
        homePage.middleName.sendKeys(freeStudents.get(0).get("mname"));

    }

    @Then("I enter last name")
    public void i_enter_last_name() {
       homePage.lastName.sendKeys(freeStudents.get(0).get("lname"));
    }

    @Then("I enter date of birth")
    public void i_enter_date_of_birth() {
       homePage.dob.sendKeys(freeStudents.get(0).get("birthDate"));
    }

    @Then("I pick a school")
    public void i_pick_a_school() throws InterruptedException {
        Select school = new Select(homePage.school);
        school.selectByValue(freeStudents.get(0).get("school"));
    }

    @Then("I pick a grade")
    public void i_pick_a_grade() throws InterruptedException {
        Select grade = new Select(homePage.grade);
        grade.selectByValue(freeStudents.get(0).get("grade"));
    }

    @Then("I enter address")
    public void i_enter_address() {
        homePage.address.sendKeys(freeStudents.get(0).get("address"));
        homePage.addressItem0.click();
    }

    @Then("I enter parent name")
    public void i_enter_parent_name() {
        homePage.parentName.sendKeys(freeStudents.get(0).get("parentName"));
    }

    @Then("I enter parent email")
    public void i_enter_parent_email() {
        homePage.parentEmailAddress.sendKeys(freeStudents.get(0).get("parentEmailAddress"));
    }

    @Then("I enter parent phone")
    public void i_enter_parent_phone() {
        homePage.parentPhoneNumber.sendKeys(freeStudents.get(0).get("parentPhoneNumber"));
    }

    @Then("I click on add sibling")
    public void i_click_on_add_sibling() {
        homePage.addSibling.click();
    }

    @Then("I input the sibling information")
    public void i_input_the_sibling_information() throws InterruptedException {
        int numberOfSiblings = Integer.parseInt(freeCount)-1;
        for (int i = 1,y = 1; i <= numberOfSiblings; i++) {
            i_click_on_add_sibling();
            Map<String, String> student = freeStudents.get(i);
            List<WebElement> sibling = homePage.siblingElements(i);
            sibling.get(0).sendKeys(student.get("fname"));
            sibling.get(2).sendKeys(student.get("lname"));
            sibling.get(3).sendKeys(student.get("birthDate"));
            Select school = new Select(sibling.get(4));
            school.selectByValue(student.get("school"));
            Select grade = new Select(sibling.get(5));
            grade.selectByValue(student.get("grade"));
        }
    }

    @Then("I click on contunue button")
    public void i_click_on_contunue_button() {
        homePage.continueButton.click();
    }
    @Then("I click on submit buuton")
    public void i_click_on_submit_buuton() throws InterruptedException {
        Thread.sleep(1000);
        homePage.submit.click();
    }








}
