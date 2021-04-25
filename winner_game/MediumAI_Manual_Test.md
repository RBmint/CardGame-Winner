# Medium Manual Test Plan
This is the manual test Plan for Medium AI in week3.
# Prerequisites:
What are the version/tools one needs to have to test your code:
- An operating system among: Windows, MacOS, Linux
- IntelliJ or Eclipse
- JDK 15
- JUnit 5.4
# Environment Setup and configurations:
How do you set up your testing environment?
- Install the latest version of IntelliJ or Eclipse
- make sure proper versions of JDK and JUnit have been selected
- set /src as source folder
# Operations and the results
- If the Medium AI can play freely, and his smallest card is a three of a kind,
  the following message should appear in the terminal:
  
        The Medium AI can play freely and his smallest hand is three of a kind.

- If the Medium AI can play freely, and his smallest card is a pair,
  the following message should appear in the terminal:
  
        The Medium AI can play freely and his smallest hand is a pair.
- If the Medium AI can play freely, and his smallest card is a single,
  the following message should appear in the terminal:   
  
        The Medium AI can play freely and his smallest hand is a single.
    
- If the medium AI cannot play a card combination that matches the last play, e.g. does not have a 
bigger pair, does not have a straight, does not have a bigger single .etc,
  the following message should appear in
  the terminal:

        The Medium AI does not have a bigger hand and choose to skip his turn.
            
- If the Medium AI can play a single card,
  the following message should appear in
  the terminal:

        The Medium AI will find the smallest single in his hand that beats the last play.


- If the medium AI can play a pair,
  the following message should appear in
  the terminal:

        The Medium AI will find the smallest pair in his hand that beats the last play.


- If the medium AI can play a threeOfAKind,
  the following message should appear in
  the terminal:

        The Medium AI will find the smallest three of a kind in his hand that beats the last play.

- If the medium AI can play a straight,
  the following message should appear in
  the terminal:

        The Medium AI will find the smallest straight in his hand that beats the last play.

- If the medium AI can play a full house,
  the following message should appear in
  the terminal:

        The Medium AI will find the smallest full house in his hand that beats the last play.

- If the medium AI can play a bomb!
  the following message should appear in
  the terminal:

        The Medium AI does not have a matching combotype, but he has a BOMB!

#Medium AI win rate test

- If you change the game.java file in /src/Game, you could start the game with a medium AI and
two basic AIs. The game will run automatically and print out a winner. 

         Currently, the game was ran for 50 rounds and the medium AI wins 33/50 against basic AIs.

- If you change the file again, you can try play manually with a medium AI and a basic AI.
        
        Currently, the game was played manually for 10 rounds. The medium AI won once while the basic AI
        never won any. The win rate for medium AI against human player is 1/10.
        