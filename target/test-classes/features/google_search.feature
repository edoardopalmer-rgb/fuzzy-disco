Feature: Google Searching
  As a web surfer, I want to search the word "testing" on Google main page, so that I can learn new things.

  Scenario: Simple Google search
    Given a web browser is on the Google page
    When the search phrase "testing" is entered
    Then results for "testing" are shown
