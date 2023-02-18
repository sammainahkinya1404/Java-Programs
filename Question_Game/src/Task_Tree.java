import java.io.PrintStream;
import java.util.Scanner;

//import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Root;

public class Task_Tree {

    // Variables of the Project tree
    public int intializer=0;
    public String user_Input="";
    public Scanner inputs= new Scanner(System.in);

    public T_node tRoot;
    //default class Constructor to initilaize  the Roots of the Game to check if choice is blank or not
     public Task_Tree(){
         tRoot = new T_node("Empty Choice");
     }

     // Function/Method to create Tree used in the game
     public  void makeTree(Scanner f){
         tRoot=recursiveTreeMakerFunction(f);
     }
     //Function to Recursively create the Tree

    public  T_node recursiveTreeMakerFunction(Scanner f){
         //Beginning to read  first line in the input file

        String L= f.nextLine();

        //check if the line in the file is a test or a choice
        if(getNature(L)=="Test")

            {
                //get Test/Question  from the Input file
                String test = L.replaceAll("Test\\|", "");
                //create T_node with two  roots
                return new T_node(test,recursiveTreeMakerFunction(f), recursiveTreeMakerFunction(f));
            }
        else
            {
                //get the answer (strip the answer choice)
                String choice = L.replaceAll("Choice\\|", "");
                //create T_node with no roots
                return new T_node(choice);
            }

        }
    //get the type (question or answer)
    private String getNature(String l)
    {
        //return String
        String type = "";


        if (l.charAt(0) == 'Q')
        {
            type = "Test";
        }
        else
        {
            type = "Choice";
        }

        return type;
    }
    //public method for playing the game
    public void playGame()
    {
        //send the root to the private recursive method
        recursivePlay(tRoot);
    }

    private T_node recursivePlay(T_node currentNode)
    {
        //check if at a leaf node (answer)
        if (currentNode.t_side == null && currentNode.f_side == null)
        {
            //increment the counter:
            intializer++;
            //ask if the user is thinking of this answer:
            System.out.println(intializer + ": Are you thinking of " + currentNode.Name + "?");
            //get the user input
            user_Input = inputs.nextLine();

            //if the computer guessed right
            if (user_Input.equals("y"))
            {
                //tell the user that the computer is right
                System.out.println("The computer guessed right");
                //check if less than 20 guesses
                if (intializer <= 20)
                {
                    System.out.println("The computer wins!");
                }
                else
                {
                    System.out.println("Took more than 20 guesses, therefore you win!");
                }
                //reset the  initilalizer
                intializer = 0;
            }
            else
            {
                //Ask what the user was thinking of:
                System.out.println("The computer could not guess your object");
                System.out.println("You win!");
                //reset the initializer
                intializer = 0;
                System.out.println("What object were you thinking of?");
                String newObject = "";
                newObject = inputs.nextLine();
                //ask what type of question would distinguish this object from the previous object
                System.out.println("Please provide a yes or no question to distinguish this object from the one the computer guessed");
                String newQuestionText = "";
                newQuestionText = inputs.nextLine();
                System.out.println("Provide 'y' or 'n' for the answer to the question for your object");
                String newAnswer = "";
                newAnswer = inputs.nextLine();

                //add to the tree depending on whether the answer was yes or no
                if (newAnswer.equals("y"))
                {
                    //if yes subtree
                    //create a new leaf node for this new leaf node object for yes answer
                    T_node newLeaf = new T_node(newObject);
                    //make a copy of the previous leaf node (for no answer)
                    T_node previousLeaf = new T_node(currentNode.Name);
                    //make a new node for the new question to replace the old leaf node on the tree
                    //note: put the newLeaf as the second argument since it is "yes" to the question
                    T_node newQuestionNode = new T_node(newQuestionText, newLeaf, previousLeaf);
                    //update the current node to be the new question node
                    currentNode = newQuestionNode;
                }
                else if (newAnswer.equals("n"))
                {
                    //if no subtree
                    //create a new leaf node for this new leaf node object for no answer
                    T_node newLeaf = new T_node(newObject);
                    //make a copy of the previous leaf node (for yes answer)
                    T_node  previousLeaf = new  T_node (currentNode.Name);
                    //make a new node for the new question to replace the old leaf node on the tree
                    //note: put the newLeaf as the third argument since it is "no" to the question
                    T_node newQuestionNode = new  T_node (newQuestionText, previousLeaf, newLeaf);
                    //update the current node to be the new question node
                    currentNode = newQuestionNode;
                }

            }
        }
        //if a question node:
        else
        {
            //increment the question counter:
            intializer++;
            //get the question:
            System.out.println(intializer + ": " + currentNode.Name);
            //get the user's answer:
            user_Input= inputs.nextLine();
            //if yes
            if (user_Input.equals("y"))
            {
                //go down the yes subtree recursively by assigning the current yes node back
                currentNode.t_side = recursivePlay(currentNode.t_side);
            }
            //if no
            else if (user_Input.equals("n"))
            {
                //go down the no subtree recursively by assigning the current no node back
                currentNode.f_side = recursivePlay(currentNode.f_side);
            }

        }

        return currentNode;
    }



    //public method for overwriting
    public void overWriteFile(PrintStream f)
    {
        //send to the private recursive method
        recursiveOverWrite(tRoot, f);
    }

    private void recursiveOverWrite(T_node currentNode, PrintStream output)
    {
        //make sure there is still a node to traverse
        if (currentNode != null)
        {
            //print out the questions
            if (currentNode.t_side != null || currentNode.f_side != null)
            {
                //make a question string
                String question = ("Question|" + currentNode.Name);
                //output to the file
                output.println(question);
            }
            //print out the answers
            else
            {
                //make an answer string
                String answer = ("Answer|" + currentNode.Name);
                //output to the file
                output.println(answer);
            }
            //recursively descend down the yes subtree
            recursiveOverWrite(currentNode.t_side, output);
            //recursively descend down the no subtree
            recursiveOverWrite(currentNode.f_side, output);
        }
    }

}




