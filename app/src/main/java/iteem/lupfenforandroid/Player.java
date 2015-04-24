package iteem.lupfenforandroid;

import java.util.Vector;

public class Player {
    private String name;
    private double wealth;
    private Vector<Card> cards;
    private boolean cardsSeen;
    private Vector<Trick> tricks;
    private int cardValue;
    private Vector<Card> playableCards;

    public Player() {
        this.cards = new Vector<>();
        this.newRound();
    }

    public void pay(int aAmount) {
        this.wealth -= aAmount;
    }

    public void win(int aAmount) {
        this.wealth += aAmount;
    }
   
    public void showCards() {
        this.cardsSeen = true;
    } 
    public void newRound() {
        this.cardsSeen = false;
        this.tricks = new Vector<Trick>();
        this.cardValue = 0;
    }
    public void receiveCard(Card aCard) {
        this.cards.add(aCard);
        this.cardValue += aCard.getValue();
    }

    public String getName() {
        return this.name;
    }
    public void setName(String aName) {
        this.name = aName;
    }
    public double getWealth() {
        return this.wealth;
    }

    public void dropCards() {
        this.cards.clear();
    }
    public Card playCard() {
        // TODO has to be in UI
        Card card = this.playableCards.elementAt(0);
        this.cards.remove(card);
        //DEBUG 
        System.out.println(this + " spielt " + card);
        return card;
    }
    public void calculatePlayableCards(Trick aTrick) {
        // when first player, all cards can be played
        // if there is the same colour this card has to be played
        // if not the same colour, a trump should be played
        // otherwise all cards can be played
        Vector<Card> sameColour = new Vector<>();
        Vector<Card> trumps = new Vector<>();

        if(aTrick.getCardCount() > 0) {
            for(Card card: this.cards) {
                if (card.getColour() == aTrick.getColour()) {
                    sameColour.add(card);
                } 
                if (card.getColour() == aTrick.getTrumpColour()) {
                    trumps.add(card);
                } 
            }
        }    
        this.playableCards = this.cards;
        if (trumps.size() > 0) {
            this.playableCards = trumps;
        }
        if (sameColour.size() > 0) {
            this.playableCards = sameColour;
        } 
    }

    public int getTrickCount() {
        return this.tricks.size();
    }
    public void addTrick(Trick aTrick) {
        this.tricks.add(aTrick);
    } 
}
