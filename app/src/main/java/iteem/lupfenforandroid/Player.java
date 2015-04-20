package iteem.lupfenforandroid;

import java.util.Vector;

public class Player {
    private String mName;
    private double mWealth;
    private Hand mHand;

    public String getName() {
        return this.mName;
    }
    public void setName(String aName) {
        this.mName = aName;
    }
    public double getWealth() {
        return this.mWealth;
    }
    public void recieveCard(Card aCard) {
        this.mHand.recieveCard(aCard);
    }
    public Card play(Trick aTrick) {
        // signals the Player to play a Card
    }

    private class Hand {
        private Vector<Card> mCards;
        private Boolean mSeen;

        public Hand() {
            mCards = new Vector<>();
            mSeen = false;
        }

        public void recieveCard(Card aCard) {
            mCards.add(aCard);
        }

        public Vector<Card> possibleCards(Trick aTrick) {
            
        }

    }

}
