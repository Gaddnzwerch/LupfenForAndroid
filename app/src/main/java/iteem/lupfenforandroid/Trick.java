package iteem.lupfenforandroid;

import java.util.Vector;

/**
 * Here is the description of what the method is doing. Some specific things that will      
 * be helpful to the caller like {@link OtherClass#methodName()}
 * @param aParam What your param is or used for in your method
 * @return what your method is returning
 * @see OtherClass
 */
public class Trick {    
    private Vector<PlayerCard> playedCards;
    private PlayerCard trick; 
    private Card trump;
    private Boolean trumpPlayed;
    private String colour;

    public Trick(Card aTrump) {
        this.trump = aTrump;
        this.playedCards = new Vector<>();
        this.trumpPlayed = false;
    }

    public void play(Player aPlayer, Card aCard) {
        PlayerCard playerCard = new PlayerCard(aPlayer, aCard);
        Boolean cardIsTrump = (aCard.getColour() == trump.getColour());
        
        if(this.playedCards.size()==0) { 
            // first card played sets colour and is always trick
            this.trick = playerCard;
            this.colour = aCard.getColour();
        } else {
            if(this.trumpPlayed && cardIsTrump){
                // if a trump was played it can only be beaten by another trump
                if (this.trick.card.getValue() < aCard.getValue()) {
                    this.trick = playerCard;
                }
            } else {
                // a normal card is automaticly beaten by a trump
                if (cardIsTrump) {
                    this.trick = playerCard;
                } else if (this.colour == aCard.getColour() && this.trick.card.getValue() < aCard.getValue()) {
                // the colour must be the same an the value higher
                    this.trick = playerCard;
                } 
            }
        }
        
        if (cardIsTrump &! this.trumpPlayed) {
            this.trumpPlayed = true;
        }
        this.playedCards.add(playerCard);
    }

    public Player getWinner() {
        return trick.player;
    }

    /** inner class to store the information which player played which card
     */
    class PlayerCard {
        Player player;
        Card card;

        protected PlayerCard(Player aPlayer, Card aCard) {
            this.player = aPlayer;
            this.card = aCard;
        }
    }

    public String getColour() {
        return this.colour;
    }
    public String getTrumpColour() {
        return this.trump.getColour();
    }
    public int getCardCount() {
        return this.playedCards.size();
    }

}
