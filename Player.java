import javax.swing.JOptionPane;
/**
 *
 * @author John
 */
public class Player 
{
    Game game;
    
    //Constructor
    public Player(Game game)
    {
        this.game = game;
    }
    
    //Take a value from player input and return it if it's within the rules.
    public int promptPlayer()
    {
        int iAnswer;
        
        String answer = JOptionPane.showInputDialog(
                null, 
                "There are " + game.getMatchesLeft() + " matches left."
                + "\n How many do you take?");
        //Convert answer into an integer.
        
        iAnswer = Integer.parseInt(answer);
        
        //Return answer
        return iAnswer;
    }
    
    
    
}

