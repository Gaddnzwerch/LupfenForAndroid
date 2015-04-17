package iteem.lupfenforandroid;

public class Player {
    private String mName;
    private double mWealth;
    private Set<Card> mCards;
    private boolean mCardsSeen;
    private Set<Trick> mTricks;
   
    public void showCards() {
        this.mCardsSeen = true;
    } 
    public void newRound() {
        this.mCardsSeen = false;
        this.mTricks = new Set<Trick>();
        this.mCards = new Set<Card>();
    }
    public String getName() {
        return this.mName;
    }
    public void setName(String aName) {
        this.mName = aName;
    }
    public double getWealth() {
        return this.mWealth;
    }

}
