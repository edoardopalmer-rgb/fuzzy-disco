package steps;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import pages.GooglePage;
import utils.DriverFactory;

public class GoogleSteps {
  private GooglePage google;

  @Given("a web browser is on the Google page")
  public void openGoogle(){
      
    google = new GooglePage(DriverFactory.get());
  }

  @When("the search phrase {string} is entered")
  public void enterSearch(String phrase){
phrase="testing" ;
google.search(phrase);
  }

  @Then("results for {string} are shown")
  public void resultsShown(String phrase){
    //to implement
      System.out.println(google.results(phrase));
      Assertions.assertTrue(
              google.results(phrase),
              "Expected results to contain: " + phrase
      );
  }

}
