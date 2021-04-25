# Ranking System Manual Test Plan
This is the manual test Plan for player ranking system in week3.
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
- If 'leaderPlayers.txt' and 'matchHistories.txt' do not exist,
  they should be created after the write calls.
- For the r/w player test, 
  leaderPlayers.txt should have the following contents:

Ricky;0\
Royce;0\
BasicAI;0

- For the r/w match history test, 
  matchHistories.txt should have the following content:

Ricky;Ricky;BasicAI;MediumAI\
Royce;Royce;BasicAI;MediumAI


- Call contents should be deleted after the clearAll() call.