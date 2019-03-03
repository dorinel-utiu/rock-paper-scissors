Feature: User option -> Rock/Paper/Scissors
  As a user I select an option from Rock/Paper/Scissors

  Scenario: User chooses an option successfully
    Given The application is up and running
    And The game with 'id' is started
    When User selects 'paper' as option for game 'id'
    Then A '200' response status code should be returned

  Scenario: User chooses and invalid option
    Given The application is up and running
    And The game with 'id' is started
    When User selects 'invalidOption' as option for game 'id'
    Then A '400' response status code should be returned

  Scenario: User chooses an option with a non existing game id
    Given The application is up and running
    When User selects 'paper' as option for game 'nonExistingId'
    Then A '404' response status code should be returned