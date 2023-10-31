// Importing Library
import java.util.Scanner;
import java.util.Random;

// initialising the class
public class NumberGame {
    public static void main(String[] args){
        //Initialising the variables
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int attempt = 0;
        int score = 0;
        boolean playagain = true;

        // intitialising the game 
        System.out.println("\t Welcome!");
        System.out.print("\t Guess The Number Game\n\n" +
                            "How to play:\n" +
                            "1. The system will generate a random number from the range 1 to 10.\n" +
                            "2. You have to enter your Guess, the more accurately you guess, your score increases.\n" +
                            "LET THE GAME BEGIN! All The Best!👍");
        System.out.println("\n\nStart: ");

        while (playagain){

            int num = random.nextInt(max - min +1) + min;
            while(true){
                
                System.out.print(" Enter your Number: ");
                int guess = input.nextInt();
                attempt++;

                if (guess == num){
                    System.out.println("\t Bingo!! You have guessed it right");
                    score++;
                    break;
                }
                else if(guess < num){
                    System.out.println("\t Ah! so close! You have guessed a number smaller than the Key. Try again\n");
                }

                else {
                    System.out.println("\t Ah! so close! You have guessed a number larger than the Key. Try again\n");
                }

                if(attempt>=10){
                    System.out.print("\t Sign! You have exeeded your attempts ☹ \n" +
                                    "\t The number was: " + num);
                    break;

                }
            }

            System.out.print("\n\nDo you wish to play again? (Yes/No):  ");
            String choice = input.next().toLowerCase();
            if(!choice.equals("yes")){
                playagain = false;
            } 
            else {
                playagain = true;
                attempt = 0;
                System.out.println("\n");
            }

        }

        System.out.println("\n Thank you! Your score was: "+ score);
        
        input.close();
    }

}