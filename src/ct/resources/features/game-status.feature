Feature: Game status
  As a user I would like to get the game status

  Scenario: User sees game status successfully
    Given The application is up and running
    And The game with 'gameSId' is started
    When User calls game status for game 'id'
    Then Game status with status code '204' should be returned

  Scenario: User sees game status successfully
    Given The application is up and running
    And The game with 'gameSId' is started
    And User selects 'paper' as option for game 'gameSId'
    When User calls game status for game 'gameSId'
    Then Game status with status code '200' should be returned

  Scenario: User chooses an option with a non existing game id
    Given The application is up and running
    When User calls game status for game 'nonExistingId'
    Then Game status with status code '404' should be returned