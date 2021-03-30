# A Mobile Winner Card Game App
 
- Royce Zhai (mzhai4) | Moderator: Satvik Sethia (ssethia2)
- Ruikang Zhao(ruikang2) | Moderator: Janak Shah (janaks2)
 
This is a mobile Card Game App about a project for CS242
Winner:
https://en.wikipedia.org/wiki/Winner_(card_game)
 
## Abstract
 
### Project Purpose
 
Create a Winner game mobile app with interactive AIs.
 
### Project Motivation
 
Winner is a card game similar to the game “President” and “Dou dizhu”, but not in the genre of gambling. It could be a good start for people who want to learn popular Chinese gambling card games like “Dou dizhu”, since the rules are very simple except that rules are the same for all players in “Winner”.
 
## Technical Specification
 
- Platform: Cross-platform app (Java, React Native)
- Programming Languages: Java, JavaScript
- Stylistic Conventions: Classic Java style Guide, Airbnb JavaScript Style Guide
- IDE: IntelliJ (IDE for Java), Visual Studio Code (IDE for React Native, acquired by Airbnb)
- Tools/Interfaces: Desktop and Mobile devices
- Target Audience: Broad-range audience
 
## Functional Specification
 
### Features
 
- Users can play against each other on a local computer, by taking seats in turns.
- Users can play against different types of AI opponents, including basic AI and advanced AI.
- A ranking system which records win/loss and allows users to see the match history against different AIs.
 
## Brief Timeline
 
- Week 1: Implement the essential player/game/card class.
- Week 2: Implement the basic AI and game logic/game loop. The game should be playable by human players.
- Week 3: Implement the meidum AI and the ranking system.
- Week 4: Implement the advanced AI and the GUI.

 
## Rubrics
 
### Week 1
 
Royce Zhai:
| Category | Total Score Allocated | Detailed Rubrics |
|-----------|:---------:|-------------------------------------------------------------------------------|
| Game class | 4 | 0: Didn't implement anything <br> 2: Implemented all necessary fields and constructor <br> 4: Implemented all necessary getters and helper functions|
| Game loop: joinable by players | 3 | 0: Didn't implement anything <br> 1: Implemented a loop <br> 2: Allow player to enter the game loop but not fully functional <br> 3: Fully functioning multi-player game loop that allows a input number of players and switches turns properly |
|Game loop: start and end | 3 | 0: Didn't implement anything <br> 1: Game loop ends properly when one player clears his hand <br> 2: Part of the game logic functions properly in a game loop <br> 3: Fully functioning game logic in a game loop|
| Coding style | 5 | 0: Didn't implement any documentation <br>3: Implemented some documentation but not all of them <br> 5: All classes and functions have documentations and codes are properly formatted according to java-style |
| Unit Test for Game loop | 5 | 0: Didn't implement tests <br> 1: unit test coverage < 50% <br> 3: unit test coverage < 70% <br> 5: unit test coverage > 90% |
| Unit Test for Game class | 5 | 0: Didn't implement tests <br> 1: unit test coverage < 50% <br> 3: unit test coverage < 70% <br> 5: unit test coverage > 90% |
 
Ruikang Zhao:
| Category | Total Score Allocated | Detailed Rubrics |
|-----------|:---------:|-------------------------------------------------------------------------------|
| Card class | 5 | 0: Didn't implement anything <br> 3: Implemented all necessary types of card <br> 5: Implemented all necessary constructor, getters, and helper functions properly|
| Player class | 5 | 0: Didn't implement anything <br> 3: Implemented all necessary fields, constructor, getters and helper functions for player <br> 5: Included player hand and subtle rules |
| Coding style | 5 | 0: Didn't implement any documentation <br>3: Implemented some documentation but not all of them <br> 5: All classes and functions have documentations and codes are properly formatted according to java-style |
| Unit Test for Card class | 5 | 0: Didn't implement tests <br> 1: unit test coverage < 50% <br> 3: unit test coverage < 70% <br> 5: unit test coverage > 90% |
| Unit Test for Game class | 5 | 0: Didn't implement tests <br> 1: unit test coverage < 50% <br> 3: unit test coverage < 70% <br> 5: unit test coverage > 90% |
 
### Week 2
 
Royce Zhai:
| Category | Total Score Allocated | Detailed Rubrics |
|-----------|:---------:|-------------------------------------------------------------------------------|
| Basic AI functions | 5 | 0: Didn't implement anything <br> 1: Implemented 1 basic AI features/functions <br> 2: Implemented 2 basic AI features/functions <br> 3: Implemented 3 basic AI features/functions <br> 4: Implemented 4 basic AI features/functions <br> 5: Implemented >=5 basic AI features/functions|
| Basic AI interaction feedback | 3 | 0: Didn't implement anything <br> 2: Implemented simple reaction feedback using terminal/commandline <br> 3: Implemented detailed AI feedback and information using terminal/commandline |
| Basic AI game logic | 5 | 0: Didn't implement anything <br>1: Player is able to choose the number of AI in game using commandline <br>3: Three AIs can automatically join and start the game <br> 5: The indicated amount of AI can play smoothly with real players and end the game with accurate winner |
| Refactoring | 2 | 0: Didn't refactor previous code <br> 2: refactored all problems according to the feedback |
| Unit Test for basic AI | 5 | 0: Didn't implement tests <br> 1: unit test coverage < 50% <br> 3: unit test coverage < 70% <br> 5: unit test coverage > 90% |
| Manual Test Plan for basic AI in game | 5 | 0: No manual test plan <br> 1: The test plan includes only environmental setup or scenario descriptions <br> 3: Test plans contain some content but can be further improved <br> 5: Well composed test plans |
 
Ruikang Zhao
| Category | Total Score Allocated | Detailed Rubrics |
|-----------|:---------:|-------------------------------------------------------------------------------|
| Game logic: card combinations | 7 | 0: Didn't implement anything <br> 4: Implemented part of the playable combainations of cards <br> 7: Implemented all playable combinations of cards |
| Game logic: comparison rules | 6 | 0: Didn't implement anything <br> 2: Implemented comparison logic between some combinations <br> 4: Implemented the comparison logic between all combinations <br> 6: Comparisons functions properly when players switch turns in a game loop|
| Refactoring | 2 | 0: Didn't refactor previous code <br> 2: refactored all problems according to the feedback |
| Unit Test for game loop | 5 | 0: Didn't implement tests <br> 1: unit test coverage < 50% <br> 3: unit test coverage < 70% <br> 5: unit test coverage > 90% |
| Unit Test for game logic | 5 | 0: Didn't implement tests <br> 1: unit test coverage < 50% <br> 3: unit test coverage < 70% <br> 5: unit test coverage > 90% |
 
### Week 3
 
Royce Zhai:
| Category | Total Score Allocated | Detailed Rubrics |
|-----------|:---------:|-------------------------------------------------------------------------------|
| Medium AI functions | 5 | 0: Didn't implement anything <br> 1: Implemented 1 medium AI features/functions <br> 2: Implemented 2 medium AI features/functions <br> 3: Implemented 3 medium AI features/functions <br> 4: Implemented 4 medium AI features/functions <br> 5: Implemented >=5 medium AI features/functions|
| Medium AI interaction feedback | 3 | 0: Didn't implement anything <br> 2: Implemented simple reaction feedback using terminal/commandline <br> 3: Implemented detailed AI feedback and information using terminal/commandline |
| Medium AI win rate | 5 | 0: Didn't implement anything <br> 1: Medium AI share a similar or slightly higher win rate than basic AI<br> 3: Medium AI can win most games when against two basic AIs <br> 5: Medium AI can occasionally win a human player |
| Refactoring | 2 | 0: Didn't refactor previous code <br> 2: refactored all problems according to the feedback |
| Unit Test for medium AI | 5 | 0: Didn't implement tests <br> 1: unit test coverage < 50% <br> 3: unit test coverage < 70% <br> 5: unit test coverage > 90% |
| Manual Test Plan for medium AI in game | 5 | 0: No manual test plan <br> 1: The test plan includes only environmental setup or scenario descriptions <br> 3: Test plans contain some content but can be further improved <br> 5: Well composed test plans |
 
Ruikang Zhao:
| Category | Total Score Allocated | Detailed Rubrics |
|-----------|:---------:|-------------------------------------------------------------------------------|
| Ranking system for players | 5 | 0: Didn't implement anything <br> 1: Ranking system can show previous game winner <br> 3: Ranking system add points for each separate win <br> 5: Ranking system can identify different players based on name |
| Ranking system match history | 5 | 0: Didn't implement anything <br> 2: Ranking system can show how each player played in a previous game <br> 4: Ranking system can show all past games <br> 5: Ranking system can sync play history and player's points base on game history |
| Ranking system that is permanently stored | 3 | 0: Didn't implement anything <br> 1: Player points are permanently stored <br> 3: All match history are permanently stored |
| Refactoring | 2 | 0: Didn't refactor previews code <br> 2: refactored all problems according to the feedback |
| Unit Test for Ranking system | 5 | 0: Didn't implement tests <br> 1: unit test coverage < 50% <br> 3: unit test coverage < 70% <br> 5: unit test coverage > 90% |
| Manual Test Plan for ranking system | 5 | 0: No manual test plan <br> 1: The test plan includes only environmental setup or scenario descriptions <br> 3: Test plans contain some content but can be further improved <br> 5: Well composed test plans |
 
### Week 4
 
Royce Zhai:
| Category | Total Score Allocated | Detailed Rubrics |
|-----------|:---------:|-------------------------------------------------------------------------------|
| Advanced AI functions | 5 | 0: Didn't implement anything <br> 1: Implemented 1 advanced AI features/functions <br> 2: Implemented 2 advanced AI features/functions <br> 3: Implemented 3 advanced AI features/functions <br> 4: Implemented 4 advanced AI features/functions <br> 5: Implemented >=5 advanced AI features/functions|
| Advanced AI interaction feedback and explanation | 3 | 0: Didn't implement anything <br> 1: Implemented simple reaction feedback using terminal/commandline <br> 3: Implemented detailed AI feedback and what is different from basic AI using terminal/commandline |
| Advanced AI win rate | 5 | 0: Didn't implement anything <br> 1: Advanced AI share a similar or slightly higher win rate than basic AI<br> 3: Advanced AI can win most games when against two medium AIs <br> 5: Advanced AI can be better against a human player than medium AI |
| Refactoring | 2 | 0: Didn't refactor previous code <br> 2: refactored all problems according to the feedback |
| Unit Test for advanced AI | 5 | 0: Didn't implement tests <br> 1: unit test coverage < 50% <br> 3: unit test coverage < 70% <br> 5: unit test coverage > 90% |
| Manual Test Plan for advanced AI in game | 5 | 0: No manual test plan <br> 1: The test plan includes only environmental setup or scenario descriptions <br> 3: Test plans contain some content but can be further improved <br> 5: Well composed test plans |
 
Ruikang Zhao:
| Category | Total Score Allocated | Detailed Rubrics |
|-----------|:---------:|-------------------------------------------------------------------------------|
| GUI interface for pre-game preparation | 4 | 0: Didn't implement anything <br> 2: Allowed users to input their name before the game <br> 4: Implemented an welcome screen that allows user to choose from start or quit |
| GUI interface for game play | 6 | 0: Didn't implement anything <br> 2: Implemented the graphics for each card and number of card as well as the card in hand <br> 4: The card of other players are correctly hidden during turns <br> 6: Allow the AI to have a turn and behave like a human player |
| GUI interface for ranking system | 5 | 0: Didn't implement anything <br> 1: Implemented a ranking counter hanging in game page <br> 3: Completed the ranking and match history <br> 5: The ranking system can be accessed anywhere in game but now shown directly with the option to clear history |
| Manual Test Plan for the ranking system | 5 | 0: No manual test plan <br> 1: The test plan includes only environmental setup or scenario descriptions <br> 3: Test plans contain some content but can be further improved <br> 5: Well composed test plans |
| Manual Test Plan for the game GUI | 5 | 0: No manual test plan <br> 1: The test plan includes only environmental setup or scenario descriptions <br> 3: Test plans contain some content but can be further improved <br> 5: Well composed test plans |
 
link for the grading calculator:
https://docs.google.com/spreadsheets/d/1m0Tz0bqKwk-yHyYF5w4lUY6ORNpmerBHYGyTWcHt9eM/edit?usp=sharing
 
 
