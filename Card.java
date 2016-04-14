public abstract class Card
{
    abstract void performAction(Game game);
    private String name;
    private String type;
    private int value;
    private int cost;
    
    public Card(String name, String type, int cost, int value)
    {
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.value = value;
    }
    /////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////G E T T E R S/////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////
    public String getName()
    {
        return name;
    }
    public String getType()
    {
        return type;
    }
    public int getCost()
    {
        return cost;
    }
    public int getValue()
    {
        return value;
    }
    public boolean isActionCard()
    {
        return this.type.equals("kingdom");
    }
}
