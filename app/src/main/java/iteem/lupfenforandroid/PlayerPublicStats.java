package iteem.lupfenforandroid;

/** class to transfer data from one Intent to another
 *
*/
public Class PlayerPublicStats(){
    private int cardCount;
    private int trickCount;
    private double wealth;

    public PlayerPublicStats(int aCardCound, int aTrickCount, double aWealth){
        this.cardCount = aCardCount;
        this.trickCount = aTrickCount;
        this.wealth = aWealth;
    }

    public int getCardCount(){
        return this.cardCount;
    }
    public int getTrickCount(){
        return this.trickCount;
    }
    public double getWealth(){
        return this.wealth;
    }
}

