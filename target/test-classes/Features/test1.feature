Feature: feature to test CoinMarketCap

  Scenario: To verify all hundred rows of record are present
    Given I navigate to the given URL
    And count number of rows
    Then verify them to be hundred rows
    And close the browser
    
    Scenario: To verify all columns of the table is present
    Given I navigate to the given URL
    And count number of columns
    Then verify them
    And close the browser
