# Number Guessing Game
This is a simple number guessing game implemented in Java.

## Game Description

The program generates a random number within a specified range and prompts the user to guess the number. It provides feedback on whether the guess is correct, too high, or too low. The user can play multiple rounds, and the score is based on the number of successful guesses.

## How to Play

1. The system generates a random number within a specified range.
2. The user is prompted to enter their guess for the generated number.
3. The system provides feedback on the guess: whether it's correct, too high, or too low.
4. The user continues guessing until the number is guessed correctly or until the maximum number of attempts is reached.

## Running the Program

### Prerequisites
- Java installed on your system

### Instructions
1. Clone the repository.
2. Navigate to the directory where the code is located.
3. Compile the Java file:
			javac NumberGame.java
4. Run the compiled file:
			java NumberGame
5. Follow the on-screen instructions to play the game.

##Sample Output:

         Welcome!
         Guess The Number Game

How to play:
1. The system will generate a random number from the range 1 to 10.
2. You have to enter your Guess, the more accurately you guess, your score increases.
LET THE GAME BEGIN! All The Best!

Start: 

 Enter your Number: 99
         Ah! so close! You have guessed a number larger than the Key. Try again

 Enter your Number: 50
         Ah! so close! You have guessed a number Smaller than the Key. Try again

 Enter your Number: 70
         Ah! so close! You have guessed a number Smaller than the Key. Try again

 Enter your Number: 80
         Ah! so close! You have guessed a number larger than the Key. Try again

 Enter your Number: 75
         Ah! so close! You have guessed a number larger than the Key. Try again

 Enter your Number: 72
         Ah! so close! You have guessed a number larger than the Key. Try again

 Enter your Number: 71
         Bingo!! You have guessed it right


Do you wish to play again? (Yes/No):  no

Thank you! Your score was: 1