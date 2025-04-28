# Rock-Paper-Scissors Console Game

## Prerequisites

- Java 21

## Features

- Console interface
- Player vs Computer mode
- Configurable round count per session
- Architecture:
    - MVC structure(with commands instead of controllers)
    - Command pattern to enhance logic composition and testability.
    - Factory for players creation
    - GameContext for unified shared state for each session.
- Tested with Junit 5 and AssertJ
    - Junit is quite common testing framework
    - AssertJ makes writing and reading assertions more comfortable

## Command flow

- PlayGameCommand
    - StartGameCommand
    - PlayTurnCommand * n
    - ShowResultsCommand

## Run the App

```bash
bash ./mvnw clean compile exec:java -Dexec.mainClass="org.vbaklaiev.Main"