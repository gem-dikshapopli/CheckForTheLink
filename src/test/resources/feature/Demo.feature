@test1
Feature:Test Google
  Scenario:Find the Link
    Given open Google and check for logo and Gmail Button and Images Button
    Then Enter Selenium in the search box and click enter
    Then Make a list of all the links present And Search for the the link on which page it is and return the number of the page