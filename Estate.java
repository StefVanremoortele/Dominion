
public class Estate extends VictoryCard
{
    public Estate ()
    {
        super("estate", 2, 1);
    }
    
    public void performAction(Game game)
    {
        System.out.println("this card has no actions");
    }
    public boolean hasAction()
    {
        return false;
    }
}
