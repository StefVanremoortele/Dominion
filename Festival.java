
public class Festival extends ActionCard
{
    
    public Festival ()
    {
        super("festival", 5);
    }

    public void performAction(Game game)
    {
        game.getActivePlayer().addActions(2);
        game.getActivePlayer().addBuys(1);
        game.getActivePlayer().addCoins(2);
    }
}
