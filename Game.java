import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;
public class Game
{
    private Scanner sc = new Scanner(System.in); 
    private ArrayList<Player> playerlist;
    private boolean gameFinished;
    private boolean actionsFinished;
    private boolean buysFinished;
    private int numberOfPlayers = 2;
    private Player activePlayer;
    private Deck deck;
    private ArrayList<Card> playBoard;
    private Card card;
    
    public Game()
    {
        initGame();
        
    }
    public void initGame()
    
    {
        deck = new Deck();
        makePlayerList(numberOfPlayers); 
        playBoard = new ArrayList<Card>();
        gameFinished = false;
        welcomePlayers();
        playerlist.get(0).getCardsInHand().add(new Cellar());
        startGame();
    }
    public void startGame()
    {
        for (int i = 0; i < 2; i++) // while !gameFinished
        {
            for (Player player : playerlist)
            {
                actionsFinished = false;
                buysFinished = false;
                activePlayer = player;
                
                showGameInfo();
                while (!actionsFinished)
                {
                    actionPhase();
                }
                while (!buysFinished)
                {
                    buyPhase();
                }
                cleanUp();
            }
        }
    }
    public void actionPhase()
    {
        if (activePlayer.hasActionCard())
        {
                  System.out.println("------------");
                  System.out.println("ACTION PHASE");
                  System.out.println("------------");
                  activePlayer.printStatus();
                  activePlayer.showHand();
                  askForAction();
        } else {
            actionsFinished = true;
        }
    }
    public void askForAction()
    {
        boolean validInput = false;
        
        System.out.println("Please choose an action card to play..");
        int selectedCard = 0;
        while (!validInput)
        {
            selectedCard = sc.nextInt()-1;
            if ( (selectedCard > activePlayer.getCardsInHand().size()) || (selectedCard < 0) )
            {
                System.out.println("Card not found. please choose another card.");
            } else {
                if ( (activePlayer.getCardsInHand().get(selectedCard).isActionCard()) )
                {
                    validInput = true;
                } else {
                    System.out.println("this card is not an action card");
                }
            }
        }
        
        playActionCard(selectedCard);
    }
    public void buyPhase()
    {
       System.out.println("----------");
       System.out.println("BUY PHASE");
       System.out.println("----------");
       System.out.println("\nWhat do you want to do?");
       System.out.println("\n1 = drawcard || 2 = buycard || 3 = end buy phase");
       int action = sc.nextInt();
       switch (action) 
       {
           case 1:
                
                break;
           case 2:
                
                break;
           case 3:
                buysFinished = true;
                break;
           default: 
                System.out.println("No valid action");
       }
    }
    public void cleanUp()
    {
        activePlayer.resetValues();
        activePlayer.discardHand();
        activePlayer.drawHand();
        
        checkGameStatus();
    }
    public void playActionCard(int selectedCard)
    {
        Card card = activePlayer.getCardsInHand().get(selectedCard);
        System.out.println("playing "+card.getName()+"...\n");
        
            card.performAction(this);
        
        activePlayer.getDiscardPile().add(card);
        activePlayer.getCardsInHand().remove(card);        
        activePlayer.setRemainingActions(activePlayer.getRemainingActions()-1);
        System.out.println("finished");
    }
    public void buyCard(Player player)
    {
        System.out.println("");
        
        player.setRemainingBuys(player.getRemainingBuys()-1);
    }
    public void makePlayerList(int numberOfPlayers) 
    {
        playerlist = new ArrayList<Player>();
        for (int i = 0; i < numberOfPlayers; i++)
        {
            System.out.println("give player name: "); String name = sc.nextLine();
            playerlist.add(new Player(name));
        }
    }
    public void showGameInfo()
    {
        System.out.println("*****************************************************");
        System.out.println("\t\tCurrenty playing: "+activePlayer.getPlayerName());
        System.out.println("*****************************************************");
    }
        public void checkGameStatus()
    {
        if ( (deck.getEmptyDeckList().size() == 3) || (deck.getEmptyDeckList().contains("province")) )
        {
            gameFinished = true;
        }
    }
    public void welcomePlayers()
    {
        System.out.println("**************************************************");
        System.out.println("\t\twelcome to the dominion card game");
        System.out.println("**************************************************");
        for (int i = 0; i < playerlist.size(); i++)
        {
            System.out.println("Player "+(i+1)+": "+playerlist.get(i).getPlayerName());
        }
    }
    /////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////// G E T T E R S ////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////
    public ArrayList<Player> getPlayerlist()
    {
        return playerlist;
    }
    public Player getActivePlayer()
    {
        return activePlayer;
    }
}
