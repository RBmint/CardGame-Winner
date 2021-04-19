# Basic Manual Test Plan
This is the manual test Plan for Basic AI in week2.
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
- If the Basic AI plays after its own turn,
  the following message should appear in 
  the terminal:
  
The basic AI can play freely. He will choose to play his first card as a single.

- If the Basic AI can play a single card,
  the following message should appear in
  the terminal:

This is the first card that is greater than last play that the basic AI finds


- If the Basic AI cannot play a single card,
  the following message should appear in
  the terminal:

The basic AI does not have any card greater than last play and choose to skip turn


- If the Basic AI can play a pair,
  the following message should appear in
  the terminal:

This is the first pair that is greater than last play that the basic AI finds

- If the Basic AI cannot play a pair,
  the following message should appear in
  the terminal:

The basic AI does not have any card greater than last play and choose to skip turn

- If the Basic AI can play a threeOfAKind,
  the following message should appear in
  the terminal:

This is the first three of a kind that is greater than last play that the basic AI finds

- If the Basic AI cannot play a threeOfAKind,
  the following message should appear in
  the terminal:

The basic AI does not have any card greater than last play and choose to skip turn