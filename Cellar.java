import java.util.Scanner;
public class Cellar extends ActionCard
{
    private Scanner sc = new Scanner(System.in);
    public Cellar ()
    {
        super("cellar", 2);
    }

    public void performAction(Game game)
    {
        boolean discardFinished = false;
        int amountOfDiscardedCards = 0;
        while ( (!game.getActivePlayer().getCardsInHand().isEmpty()) && (!discardFinished))
        {
            game.getActivePlayer().showHand();
            System.out.println("please choose a card to discard");
            System.out.println("press 0 to stop discarding");
            int selectedCard = sc.nextInt();
           
            amountOfDiscardedCards++;
            
            if (selectedCard == 0) discardFinished = true;  
        }
        for (int i = 0; i < amountOfDiscardedCards; i++)
        {
            game.getActivePlayer().drawCard();
        }
    }
}
