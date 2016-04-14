
import java.util.ArrayList;
public abstract class ActionCard extends Card
{
    abstract void performAction(Game game);
    public ActionCard(String name, int cost)
    {
        super(name, "kingdom", cost, 0);
    }
}
