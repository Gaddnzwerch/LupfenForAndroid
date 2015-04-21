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
        this.newRound();
    }
   
    public void showCards() {
        this.cardsSeen = true;
    } 
    public void newRound() {
        this.cardsSeen = false;
        this.tricks = new Vector<Trick>();
        this.cards = new Vector<Card>();
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
    public Card playCard() {
        // TODO has to be in UI
        Card card = this.playableCards.elementAt(0);
        this.cards.remove(card);
        //DEBUG 
        System.out.println("spielt " + card);
        return card;
    }
    public void calculatePlayableCards(Trick aTrick) {
        // when first player, all cards can be played
        // if there is the same colour this card has to be played
        // if not the same colour, a trump should be played
        // otherwise all cards can be played
        Vector<Card> sameColour = new Vector<>();
        Vector<Card> trumps = new Vector<>();
        // DEBUG 
        System.out.println(this + " alle: " + this.cards);

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
            // DEBUG
            System.out.print("hat Trumpf ");
            this.playableCards = trumps;
        }
        if (sameColour.size() > 0) {
            System.out.print("muss zugeben ");
            this.playableCards = sameColour;
        }
        
        // DEBUG
        System.out.println("Spielbar: " + this.playableCards);
    }

}
