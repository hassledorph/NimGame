
import java.util.Random;
import javax.swing.JOptionPane;
/**
 *
 * @author John
 */
public class AI {
    
    Game game;
    
    //Constructor
    public AI(Game game)
    {
        this.game = game;
    }
    // Makes a random (Stupid) move.
    private int stupidAI()
    {
        Random rand = new Random();
        
        if(game.getMatchesLeft() > 3)
        {
            return rand.nextInt(3) + 1;
        }
        else
        {
            switch(game.getMatchesLeft())
            {
                case 2:
                    return 1;
                case 3:
                    return rand.nextInt(2) + 1;
                default:
                    return 1;
            }
        }
    }
    
    //Makes a thought out move. (Smart)
    private int smartAI()
    {
        int mLeft = game.getMatchesLeft();
        int takeMatch = 1;
        
        Random rand = new Random();
        
        if(mLeft > 12)
        {
            takeMatch = rand.nextInt(3) + 1;
        }
        else
        {
            switch(mLeft)
            {
                case 2:
                    takeMatch = 1;
                    break;
                    
                case 3:
                    takeMatch = 2;
                    break;
                    
                case 4:
                    takeMatch = 3;
                    break;
                    
                case 5:
                    takeMatch = 1;
                    break;
                    
                case 6:
                    takeMatch = 2;
                    break;
                    
                case 7:
                    takeMatch = 3;
                    break;
                    
                case 8:
                    takeMatch = 1;
                    break;
                    
                case 9:
                    takeMatch = 2;
                    break;
                    
                case 10:
                    takeMatch = 3;
                    break;
                    
                case 11:
                    takeMatch = 1;
                    break;
                    
                case 12:
                    takeMatch = 2;
                    break;
            }
        }
        return takeMatch;
    }
    
    
    
    public int makeMove()
    {
        Random rand = new Random();
        int matches;
        if(rand.nextBoolean())
        {
            matches = smartAI();
        }
        else
        {
            matches = stupidAI();
        }
        JOptionPane.showMessageDialog(null, "AI takes " + matches + " matches.");
        return matches;
    }
    
}
