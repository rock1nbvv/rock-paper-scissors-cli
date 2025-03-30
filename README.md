# Rock-Paper-Scissors Console Game

## Prerequisites

- Java 17

## Features

- Console interface
- Player vs Computer mode
- Configurable round count per session
- Architecture:
    - MVC structure
    - Command pattern for extensible commands
    - Factory pattern for players creation
- Tested with Junit 5 and assertJ

## Run the App

```bash
bash ./mvnw clean compile exec:java -Dexec.mainClass="org.vbaklaiev.Main"