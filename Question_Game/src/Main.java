import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //get the name of the file:
        File fileName = new File("/home/kinya/IdeaProjects/Question_Game/WarsEdition.txt");
        //make a scanner object for the file
        Scanner fileInput;
        //make a PrintStream object to overwrite the file
        PrintStream updater;
        //make player input
        Scanner playerInput = new Scanner(System.in);
        //make a gametree object
        Task_Tree myGame = new Task_Tree();
        //the player's choice
        String choice = "";
        //welcome the player to the game:
        System.out.println("Welcome to the game of 20 Questions");
        System.out.println("You have selected: " + fileName);
        System.out.println("For every \"yes\" or \"no\" query, type 'y' or 'n'");
        System.out.println("Would you like to begin?");
        choice = playerInput.nextLine();

        if (choice.equals("y"))
        {
            //read the file in
            try
            {
                //get the scanner object
                fileInput = new Scanner((fileName));
                //tell the user that the computer is generating the tree:
                System.out.println("Creating Tree...");
                //send the scanner object over to create the tree
                myGame.makeTree(fileInput);
                //tell the user to think of an object
                System.out.println("Game is ready to begin!");
                do
                {
                    //tell the user to think of an object
                    System.out.println("Please think of an object. \nType 'y' and press enter when ready to begin");
                    //get user input (can be anything)
                    choice = playerInput.nextLine();
                    //start the game:
                    myGame.playGame();
                    //ask if the user wants to play again
                    System.out.println("Would you like to play again?");
                    choice = playerInput.nextLine();

                } while(choice.equals("y"));//loop while the player says yes to another game

                //thank the user for playing and ask if they want to save the current questions and answers for furture use
                System.out.println("Thank you for playing!");
                System.out.println("Would you like to save the current Game Tree for future games?");
                choice = playerInput.nextLine();

                //update the file
                if (choice.equals("y"))
                {
                    //make a PrintStream object
                    updater = new PrintStream(fileName);
                    //call the overwrite method
                    myGame.overWriteFile(updater);
                    //tell the user it was succesful
                    System.out.println("File has been updated");
                    //close the filewriter
                    updater.close();

                }

                //close the scanner
                fileInput.close();
            }

            //in case the file could not be found
            catch(FileNotFoundException ex)
            {
                //let the user know the file could not be found
                System.out.println("Error: File not found");
            }

        }

        //end the program
        System.out.println("The game is over. Powering down now.");
    }
}