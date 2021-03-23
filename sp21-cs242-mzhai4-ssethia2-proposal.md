# A Mobile Winner Card Game App 
Royce Zhai (mzhai4) | Moderator: Satvik Sethia (ssethia2)
Ruikang Zhao(ruikang2) | Moderator: Janak Shah (janaks2)
 
This is a mobile Card Game App about a project for CS242
Winner:
https://en.wikipedia.org/wiki/Winner_(card_game)
 
## Abstract
### Project Purpose
Create a Winner game mobile app with interactive AIs. 
 
### Project Motivation
Winner is a card game similar to the game “President” and “Dou dizhu”, but not in the genre of gambling. It could be a good start for people who want to learn popular Chinese gambling card games like “Dou dizhu”, since the rules are very simple except that rules are the same for all players in “Winner”.
 
## Technical Specification
- Platform: Cross-platform app (React Native)
- Programming Languages: JavaScript 
- Stylistic Conventions: Airbnb JavaScript Style Guide
- IDE: Visual Studio Code (IDE for React Native, acquired by Airbnb)
- Tools/Interfaces: Mobile devices
- Target Audience: Broad-range audience
 
## Functional Specification
### Features
 
- Users can play against each other on a local computer, by taking seats in turns.
- Users can play against different types of AI opponents, including basic AI and advanced AI.
- A ranking system which records win/loss and allows users to see the match history against different AIs.
 
 
 
## Brief Timeline
- Week 1: Implement the essential player/game/card class.
- Week 2: Write the whole game logic and game loop. The game should be playable by human players. 
- Week 3: Implement the basic AI and the ranking system.
- Week 4: Implement the advanced AI and the GUI.
### Labor division
Cowork on essential player/game/card classes, game logic and game loop.
Royce would create basic AI and advanced AI, and Ruikang would take the part of the ranking system and GUI.
 
 
 
## Rubrics
### Week 1
| Category  | Total Score Allocated | Detailed Rubrics                                                            |
|-----------|:---------:|-------------------------------------------------------------------------------|
|  Player class |  5  |  0: Didn't implement anything <br> 3: implemented incomplete Player class<br> 5: completed Player class |
|  Game class |  5  |  0: Didn't implement anything <br> 3: implemented incomplete Game class <br> 5: completed Game class |
|  Card class |  5  |  0: Didn't implement anything <br> 3: implemented incomplete Card class <br> 5: completed Card class |
|  Test Player class |  3  |  0: Didn't implement tests <br> 2: 60%+ test coverage <br> 3: 90%+ test coverage |
|  Test Card class |  3  | 0: Didn't implement tests <br> 2: 60%+ test coverage <br> 3: 90%+ test coverage |
|  Test Game class |  4  |  0: Didn't implement tests <br> 2: 60%+ test coverage <br> 4: 90%+ test coverage |
 
### Week 2
| Category  | Total Score Allocated | Detailed Rubrics                                                            |
|-----------|:---------:|-------------------------------------------------------------------------------|
|  Refactoring/Complete missing functions |  2  |  0: Didn't implement anything <br> 1: Not much duplicate code but can be improved <br> 2: Well designed and fully functional |
|  Game loop |  7  |  0: Didn't implement anything <br> 1: Implemented a loop <br> 3: Allow player to enter the game loop but not fully functional  <br> 5: The game can be played but would not switch turns/end properly <br> 7: Fully functional game loop that start,switch and end properly |
|  Game logic |  6  |  0: Didn't implement anything <br> 2: Implemented <3 card playing logic <br> 4: Implemented the card playing logic <br> 6: Implemented how the card could be played and how the game would start and end |
|  Unit Test for game loop |  5  |  0: Didn't implement tests <br> 1: unit test coverage < 50% <br> 3: unit test coverage < 70%  <br> 5: unit test coverage > 90% |
|  Unit Test for game logic |  5  |  0: Didn't implement tests <br> 1: unit test coverage < 50% <br> 3: unit test coverage < 70%  <br> 5: unit test coverage > 90% |
 
 
 
 
### Week 3
| Category  | Total Score Allocated | Detailed Rubrics                                                            |
|-----------|:---------:|-------------------------------------------------------------------------------|
| Basic AI |  5  |  0: Didn't implement anything <br> 1: Implemented 1 basic AI features/functions <br> 2: Implemented 2 basic AI features/functions  <br> 3: Implemented 3 basic AI features/functions <br> 4: Implemented 5 basic AI features/functions <br> 5: Implemented >=5 basic AI features/functions|
|  Basic AI in game logic |  3  |  0: Didn't implement anything <br> 2: implemented AI feature but not in game loop <br> 3: fully functioning basic AI in game loop |
|  Ranking system |  5  |  0: Didn't implement anything <br> 3: added rank feature to players <br> 5: fully functioning ranking system |
|  Refactoring |  2  |  0: Didn't refactor previews code <br> 2: refactored all problems according to the feedback |
 
|  Unit Test for basic AI |  5  |  0: Didn't implement tests <br> 1: unit test coverage < 50% <br> 3: unit test coverage < 70%  <br> 5: unit test coverage > 90% |
|  Manual Test Plan |  5  |  0: No manual test plan <br> 1: The test plan includes only environmental setup or scenario descriptions <br> 3: Test plans contain some content but can be further improved <br> 5: Well composed test plans |
 
 
 
### Week 4
| Category  | Total Score Allocated | Detailed Rubrics                                                            |
|-----------|:---------:|-------------------------------------------------------------------------------|
| Advanced AI |  5  |  0: Didn't implement anything <br> 1: Implemented 1 advanced AI features/functions <br> 2: Implemented 2 advanced AI features/functions  <br> 3: Implemented 3 advanced AI features/functions <br> 4: Implemented 5 advanced AI features/functions <br> 5: Implemented >=5 advanced AI features/functions|
|  GUI interface for game |  6  |  0: Didn't implement anything <br> 2: There is an interface for card and game room <br> 4: User can choose whether to add AI and the type of AI <br> 6: Fully runnable UI and game logic |
|  GUI interface for ranking |  4  |  0: Didn't implement anything <br> 2: Implemented a ranking counter <br> 4: Completed the ranking and match history and chooseable from home page |
|  Unit Test for advanced AI |  5  |  0: Didn't implement tests <br> 1: unit test coverage < 50% <br> 3: unit test coverage < 70%  <br> 5: unit test coverage > 90% |
|  Manual Test Plan |  5  |  0: No manual test plan <br> 1: The test plan includes only environmental setup or scenario descriptions <br> 3: Test plans contain some content but can be further improved <br> 5: Well composed test plans |


link for the grading calculator:
https://docs.google.com/spreadsheets/d/1m0Tz0bqKwk-yHyYF5w4lUY6ORNpmerBHYGyTWcHt9eM/edit?usp=sharing
