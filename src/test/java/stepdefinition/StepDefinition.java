package stepdefinition;

import implementation.DemoImplementation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.net.MalformedURLException;

public class StepDefinition {
    @Given("open Google and check for logo and Gmail Button and Images Button")
    public void openGoogle(){
        DemoImplementation.openAndSearch();
    }
    @Then("Enter Selenium in the search box and click enter")
    public void search(){
        DemoImplementation.searchForSelenium();
    }
    @Then("Make a list of all the links present And Search for the the link on which page it is and return the number of the page")
    public void listOfLinks() throws InterruptedException, MalformedURLException {
        DemoImplementation.listOfLinks();
    }

}
