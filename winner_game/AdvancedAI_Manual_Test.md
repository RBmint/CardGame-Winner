# Medium Manual Test Plan
This is the manual test Plan for Advanced AI in week4.
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
- If the Advanced AI can play freely, and he has a possible straight to play,
  the following message should appear in the terminal:
  
        The Advanced AI has a good straight in hand and choose to play it first.
     
- If the Advanced AI can play freely, and he has a possible consecutive pairs to play,
  the following message should appear in the terminal:
  
        The Advanced AI has a good consecutive pairs in hand and choose to play it first.
        
- If the Advanced AI can play freely, and he has a possible full house to play,
  the following message should appear in the terminal:
  
        The Advanced AI has a full house in hand and choose to play it first.
        
- If the Advanced AI can play freely, and he has a possible three of a kind to play,
  the following message should appear in the terminal:
  
        The Advanced AI has a three of a kind but no pairs in hand.
        
- If the Advanced AI can play freely, and he has a possible pair to play,
  the following message should appear in the terminal:
  
        The Advanced AI has a small pair in his hand and cannot make other combinations.
        
- If the Advanced AI can play freely, and he has a possible small single to play,
  the following message should appear in the terminal:
  
        The Advanced AI has nothing but a small single card to play.
        
- If the Advanced AI can play freely, and he has a possible big single to play,
  the following message should appear in the terminal:
  
        The Advanced AI played his smallest card in hand. Warning!                          

- For other scenarios, the Advanced AI will behave like a medium AI.

#Advanced AI win rate test

- If you change the game.java file in /src/Game, you could start the game with an advance AI and
two medium AIs. The game will run automatically and print out a winner. 

         Currently, the game was ran for 40 rounds and the advance AI wins 27/40 against medium AIs.

- If you change the file again, you can try play manually with an advance AI and a medium AI.
        
        Currently, the game was played manually for 10 rounds. The advance AI won twice while the medium AI
        never won any. The win rate for advanced AI against human player is 3/10, which is better than
        a medium AI.
        