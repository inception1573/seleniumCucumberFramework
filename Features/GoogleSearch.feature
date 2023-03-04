Feature: Google search
  Scenario: Searching for Software Engineer on google and count the result is more then 0
    Given Open chrome browser
    When Go google search
    Then Search for "Software Engineer"
    And Hit enter
    Then Validate the search result is more then "0"
    And Close browser