
import java.util.ArrayList;
public abstract class TreasureCard extends Card
{
    abstract void performAction(Game game);
    public TreasureCard(String name, int cost, int value)
    {
        super(name, "treasure", cost, value);
    }
}
