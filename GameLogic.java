import javax.swing.JOptionPane;

/**
 *
 * @author John
 */
public class GameLogic {
    
    private Game game = new Game();
    private Player player = new Player(game);
    private AI ai = new AI(game);
    
    private int maxMatches;
    private int minMatches;
    
    private boolean isRunning;
    
    //Constructor
    public GameLogic()
    {
        maxMatches = 3;
        minMatches = 1;
        isRunning = true;
    }
    
    //Runs the game logic
    public void runGameLogic()
    {
        showRules();
        while(isRunning)
        {
            if(game.getPlayerTurn() == 1)
            {
                int matchesTaken;
                do
                {
                    matchesTaken = player.promptPlayer();
                }while(!possibleMove(matchesTaken));
                
                game.takeMatch(matchesTaken);
                
                winCheck();
                
            }
            else if(game.getPlayerTurn() == 2)
            {
                game.takeMatch(ai.makeMove());
                
                winCheck();
                
            }
        }
        
    }
    //Checks if the value is a possible play with the given rules.
    private boolean possibleMove(int matches)
    {
        if(matches > maxMatches || matches < minMatches)
        {
            JOptionPane.showMessageDialog(null, "Invalid option. Must be between " + minMatches + " to " + maxMatches + " matches. Try again.");
            return false;
        }
        else if(matches > game.getMatchesLeft())
        {
            JOptionPane.showMessageDialog(null, "Invalid option. You cant take more matches then there are left. \nTry again");
            return false;
        }
        else
        {
            return true;
        }
    }
    
    //Checks if win conditions are met. 
    private void winCheck()
    {
        if(game.getMatchesLeft() <= 1)
        {
            isRunning = false;
            game.win();
        }
        else
        {
            game.changeTurn();
        }
    }
    
    //Shows game rules.
    private void showRules()
    {
        JOptionPane.showMessageDialog(
                null, 
                "Hello and welcome to the game!"
                + "\nLet's go through some rules."
                + "\nYou and an AI player take turns picking matches from the pile."
                + "\nYou can select between 1 and 3 matches each turn."
                + "\nGood Luck!"
                );
        if(game.getPlayerTurn() == 1)
        {
            JOptionPane.showMessageDialog(null, "Player Starts!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "AI Starts!");
        }
        
        
    }
    
}