Feature: feature to test add to wish list option

  Scenario: To verify all hundred rows of record are present
    Given I navigate to the URL
    And add few random cryptocurrencies to wish list
    And open wish list in a new tab
    Then verify the added cryptocurrencies should be displayed
    And Closing the browser
    
