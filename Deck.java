import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;
public class Deck
{
    
    private ArrayList<Card> copper = new ArrayList<Card>();
    private ArrayList<Card> silver = new ArrayList<Card>();
    private ArrayList<Card> gold = new ArrayList<Card>();
    
    private ArrayList<Card> estate = new ArrayList<Card>();
    private ArrayList<Card> duchy = new ArrayList<Card>();
    private ArrayList<Card> province = new ArrayList<Card>();
    
    private ArrayList<Card> curse = new ArrayList<Card>();
    
    private ArrayList<Card> militia = new ArrayList<Card>();
    private ArrayList<Card> village = new ArrayList<Card>();
    private ArrayList<Card> throneroom = new ArrayList<Card>();
    private ArrayList<Card> councilroom = new ArrayList<Card>();
    private ArrayList<Card> cellar = new ArrayList<Card>();
    private ArrayList<Card> smithy = new ArrayList<Card>();
    private ArrayList<Card> festival = new ArrayList<Card>();
    private ArrayList<Card> market = new ArrayList<Card>();
    private ArrayList<Card> feast = new ArrayList<Card>();
    private ArrayList<Card> adventurer = new ArrayList<Card>();
    private ArrayList<Card> spy = new ArrayList<Card>();
    private ArrayList<Card> thief = new ArrayList<Card>();
    private ArrayList<Card> chancellor = new ArrayList<Card>();
    private ArrayList<Card> chapel = new ArrayList<Card>();
    private ArrayList<Card> moat = new ArrayList<Card>();
    private ArrayList<Card> mine = new ArrayList<Card>();
    private ArrayList<Card> moneylender = new ArrayList<Card>();
    private ArrayList<Card> witch = new ArrayList<Card>();
    private ArrayList<Card> woodcutter = new ArrayList<Card>();
    private ArrayList<Card> bureaucrat = new ArrayList<Card>();
    private ArrayList<Card> workshop = new ArrayList<Card>();
    private ArrayList<Card> gardens = new ArrayList<Card>();
    private ArrayList<Card> library = new ArrayList<Card>();
    private ArrayList<Card> laboratory = new ArrayList<Card>();
    
    private HashMap<String, ArrayList<Card>> treasureDeck;
    private HashMap<String, ArrayList<Card>> victoryDeck;
    private HashMap<String, ArrayList<Card>> kingdomDeck;
    private String[] allKingdomCards = new String[]{"militia", "village", "throneroom", "councilroom", "cellar", "smithy", "festival", "market", "feast", "adventurer", "spy", "thief", "chancellor", "chapel", "moat", "mine", "moneylender", "witch", "woodcutter", "bureaucrat", "workshop", "gardens", "library", "laboratory"};
    private ArrayList<String> availableKingdomCards;
    private ArrayList<String> emptyDeckList;
    private Card c;
    
    private HashMap<String, Map<String, ArrayList<Card>>> cardSupply = new HashMap<String, Map<String, ArrayList<Card>>>();
    
    private int amountOfEmptyDecks;
    public Deck()
    {
        init();
    }
    public void init()
    {
        treasureDeck = new HashMap<String, ArrayList<Card>>();
        victoryDeck = new HashMap<String, ArrayList<Card>>();
        kingdomDeck = new HashMap<String, ArrayList<Card>>();
        emptyDeckList = new ArrayList<String>();
        availableKingdomCards = new ArrayList<String>();
        
        amountOfEmptyDecks = 0;
        
        availableKingdomCards.add("militia");
        availableKingdomCards.add("festival");

        makeDecks();
        
        cardSupply.put("treasurecard", treasureDeck);
        cardSupply.put("victorycard", victoryDeck);
        cardSupply.put("kingdomcard", kingdomDeck);
    }
    public void makeDecks()
    {   
        makeTreasurePile();
        makeVictoryPile();
        makeKingdomPile();
        addPileToDeck();
    }
    public void addCardsToPile(ArrayList<Card> pile, int amount, Card card)
    {
        for (int i = 0; i < amount; i++)
        {
            pile.add(card);
        }
    }
        public void addPileToDeck()
    {
        treasureDeck.put("copper", copper);
        treasureDeck.put("silver", silver);
        treasureDeck.put("gold", gold);
        
        victoryDeck.put("estate", estate);
        victoryDeck.put("duchy", duchy);
        victoryDeck.put("province", province);
        
        for (String string : allKingdomCards)
        {
            switch (string)
            {
                case ("smithy"): addKingdomPilesToDeck(string, smithy);
                    break;
                case ("festival"): addKingdomPilesToDeck(string, festival);
                    break;
            }
        }
    }
    public void makeTreasurePile()
    {
        addCardsToPile(copper, 60, new Copper());
        addCardsToPile(silver, 40, new Silver());
        addCardsToPile(gold, 30, new Gold());
    }
    public void makeVictoryPile()
    {
        addCardsToPile(estate, 8, new Estate());
        addCardsToPile(duchy, 8, new Duchy());
        addCardsToPile(province, 8, new Province());
    }
    public void makeKingdomPile()
    {
        for (String string : availableKingdomCards)
        {
            switch (string)
            {
                case ("smithy"): 
                    addCardsToPile(smithy, 10, new Smithy());
                    break;
                case ("festival"):
                    addCardsToPile(festival, 10, new Festival());
                    break;
            }
        }
    }
    public int getSizeOfPile(String name)
    {
        int size = 0;
        for(Map.Entry<String, Map<String, ArrayList<Card>>> deck : cardSupply.entrySet()){
            for(Map.Entry<String, ArrayList<Card>> pile : deck.getValue().entrySet()){
                if (pile.getKey().equals(name)){
                    size = pile.getValue().size();
                }
            }
        }
        return size;
    }
        public void testPile(String name)
    {
        int size = 0;
        for(Map.Entry<String, Map<String, ArrayList<Card>>> deck : cardSupply.entrySet()){
            for(Map.Entry<String, ArrayList<Card>> pile : deck.getValue().entrySet()){
                if (pile.getKey().equals(name)){
                    System.out.println();
                }
            }
        }
        
    }
    public Card gainCard(String name)
    {
        for(Map.Entry<String, Map<String, ArrayList<Card>>> deck : cardSupply.entrySet()){
            for(Map.Entry<String, ArrayList<Card>> pile : deck.getValue().entrySet()){
                if (pile.getKey().equals(name)){
                    c = pile.getValue().get(0);
                    pile.getValue().remove(0);
                }
            }
        }
        return c;
    }

    public void addKingdomPilesToDeck(String pileName, ArrayList<Card> pile)
    {
        kingdomDeck.put(pileName, pile);
    }
    public HashMap getTreasureDeck()
    {
        return treasureDeck;
    }
    public HashMap getVictoryDeck()
    {
        return victoryDeck;
    }
    public HashMap getKingdomDeck()
    {
        return kingdomDeck;
    }
    //***GETTERS***
    public ArrayList<String> getAvailableKingdomCards()
    {
        return availableKingdomCards;
    }
    public ArrayList<String> getEmptyDeckList()
    {
        return emptyDeckList;
    }
    public int getAmountOfEmptyDecks()
    {
        return emptyDeckList.size();
    }
    public HashMap getCardSupply()
    {
        return cardSupply;
    }
    public boolean isPileEmpty(String pileName)
    {
        boolean emptyDeck = false;
        for (String emptyPile : emptyDeckList)
        {
            if (emptyPile.equals(pileName))
            {
                emptyDeck = true;
            }
        }
        return emptyDeck;
    }

}
