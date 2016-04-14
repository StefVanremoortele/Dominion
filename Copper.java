
public class Copper extends TreasureCard
{   
    private int value;
    public Copper ()
    {
        super("copper", 0, 1);
    } 
    public void performAction(Game game)
    {
        System.out.println("this card has no actions");
    }
}
