import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;
public class Player extends Deck
{
    private String playerName;
    private int remainingActions;
    private int remainingBuys;
    private int remainingCoins;
    private boolean hasReactionCard;
    private ArrayList<Card> deck;
    private ArrayList<Card> discardPile;
    private ArrayList<Card> cardsInHand;
    private ArrayList<Card> playingCards;
    
    private ArrayList<Card> playedCards;
    public Player(String name)
    {
        this.playerName = name;
        initPlayer();
    }
    public void initPlayer()
    {
        playedCards = new ArrayList<Card>();
        deck = new ArrayList<Card>();
        cardsInHand = new ArrayList<Card>();
        discardPile = new ArrayList<Card>();
        playingCards = new ArrayList<Card>();
        resetValues();
        giveStartCards();
        drawHand();
    }
    public void resetValues() //*complete*
    {
        remainingActions = 1;
        remainingBuys = 1;
        remainingCoins = 0;
    }
    public void giveStartCards() //*complete*
    {
        for (int i = 0; i < 3; i++)
        {
            deck.add(new Estate());
        }
        for (int i = 0; i < 7; i++)
        {
            deck.add(new Copper());
        }
    }
    public void drawHand()//*complete*
    {
        hasReactionCard = false;
        for(int i = 0; i < 5; i++)
        {
            drawCard();
        }
    }
    public void drawCard() //*complete*
    {
        if (deck.size() == 0) handleEmptyDeck();
        Card card = deck.get(0);
        if (card.getName().equals("moat")) hasReactionCard = true;
        deck.remove(0);
        getCardsInHand().add(card);
    }
    public void handleEmptyDeck() // *complete*
    {   Collections.shuffle(discardPile);
        while (!discardPile.isEmpty())
        {
            Card c = discardPile.get(0);
            deck.add(c);
            discardPile.remove(0);
        }
    }
    public void revealHand() //*complete*
    {
        System.out.println("********************");
        System.out.println(playerName+" reveals hand: ");
        System.out.println("********************");
        showHand();
    }
    public void discardDeck() //*complete*
    {
        for (Card card : deck)
        {
            discardPile.add(card);
        }
        deck.clear();
    }
    public void discardHand() //*complete*
    {
        for (Card card : cardsInHand)
        {
            discardPile.add(card);
        }
        cardsInHand.clear();
    }
    public void putCardOntopOfDeck(Card card)
    {
        deck.add(0, card);
    }
    public int getHandSize()
    {
        return cardsInHand.size();
    }
    public boolean hasActionCard()
    {
        boolean hasActionCard = false;
        for (Card card : cardsInHand)
        {
            if (card.getType().equals("kingdom")) hasActionCard = true;
        }
        return hasActionCard;
    }
    public void showHand() //*complete*
    {
        for (int i = 0; i < cardsInHand.size(); i++)
        {
            System.out.println((i+1)+" "+cardsInHand.get(i).getName()+"\t\t cost: "+cardsInHand.get(i).getCost()+"\t\t value: "+cardsInHand.get(i).getValue());
        }
    }
    public void printStatus()
    {
        System.out.println("\tActions: "+remainingActions+"\tbuys: "+remainingBuys+"\tCoins: "+remainingCoins);
    }
    public void addActions(int amount)
    {
        remainingActions += amount;
    }
    public void addBuys(int amount)
    {
        remainingBuys += amount;
    }
    public void addCoins(int amount)
    {
        remainingCoins += amount;
    }
    public void setRemainingActions(int value)
    {
        remainingActions = value;
    }
    public void setRemainingBuys(int value)
    {
        remainingBuys = value;
    }
    public void setRemainingCoins(int value)
    {
        remainingCoins = value;
    }
    /////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////G E T T E R S/////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////
    public ArrayList<Card> getDiscardPile()
    {
        return discardPile;
    }
    public ArrayList<Card> getCardsInHand()
    {
        return cardsInHand;
    }
    public int getRemainingActions()
    {
        return remainingActions;
    }
    public int getRemainingBuys()
    {
        return remainingBuys;
    }
    public int getRemainingCoins()
    {
        return remainingCoins;
    }
    public ArrayList<Card> getDeck()
    {
        return deck;
    }
    public String getPlayerName()
    {
        return playerName;
    }
}
