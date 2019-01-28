import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author John
 */
public class Game {
    
    private int startingMatches;
    private int matchesLeft;
    private int loosingMatches;
    private int playerTurn;
    
    private int players;
    
    Random rand = new Random();
    
    //Default constructor
    public Game()
    {
        startingMatches = 12;
        loosingMatches = 1;
        matchesLeft = startingMatches;
        players = 2;
        playerTurn = rand.nextInt(players) + 1;
    }
    //Overloaded constructor
    public Game(int startMatches, int loosingMatches)
    {
        this.startingMatches = startMatches;
        this.loosingMatches = loosingMatches;
        players = 2;
        matchesLeft = startMatches;
        playerTurn = rand.nextInt(2) + 1;
    }
    // Changes between the two players.
    public void changeTurn()
    {
        if(playerTurn == 1)
            playerTurn = 2;
        else
            playerTurn = 1;
    }
    //Takes a specified amount of matches from the pile. 
    public void takeMatch(int matchesTaken)
    {
        matchesLeft -= matchesTaken;
    }
    
    //Returns current player
    public int getPlayerTurn()
    {
        return playerTurn;
    }
    //Returns the amount of matches left in pile.
    public int getMatchesLeft()
    {
        return matchesLeft;
    }
    //Shows a win dialog. 
    public void win()
    {
        if(playerTurn == 1)
        {
            JOptionPane.showMessageDialog(null, "Player win!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "AI win!");
        }
    }
    
    
    
}
