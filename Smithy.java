
public class Smithy extends ActionCard
{
    public Smithy ()
    {
        super("smithy", 5);
    }
        public void performAction(Game game)
    {
        
         for (int i = 0; i < 3; i++) game.getActivePlayer().drawCard();
    }
}