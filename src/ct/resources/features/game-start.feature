Feature: Game start
  As a user I would like game to start

  Scenario: Game starts successfully
    Given The application is up and running
    When An 'gameIdd' is given to start the game
    Then A '201' status code should be returned

  Scenario: Game was already started
    Given The application is up and running
    When An 'gameIdd' is given to start the game
    Then A '409' status code should be returned