package iteem.lupfenforandroid;

import java.util.Stack;
import java.util.Vector;

/**
 * Created by Gaddnzwerch on 18.04.2015.
 */
public class Trick  {

    private Card mTrump;
    private PlayerCard mTrick; // the card currently
    private Card mFirstCard; // important for the following players
    private Stack<PlayerCard> mPlayedCards;
    private Boolean mTrumpPlayed;

    public Trick (Card aTrump) {
        this.mTrumpPlayed = false;
        this.mTrump = aTrump;
    }

    public String getColur() {
        return this.mFirstCard.getColour();
    }

    public void play (Player aPlayer, Card aCard) {
        PlayerCard mPlayerCard = new PlayerCard(aPlayer, aCard);
        this.mPlayedCards.add(mPlayerCard);
        Boolean mCardIsTrump = aCard.getColour() == mTrump.getColour();

        if(this.mPlayedCards.empty()){
            this.mFirstCard = aCard;
            // first Card played is always the trick
            this.mTrick = mPlayerCard;
        } else {
            if(this.mTrumpPlayed && mCardIsTrump){
                // a played trump can just be overtrumped by another trump
                if(aCard.getValue() > this.mTrick.mCard.getValue()){
                    this.mTrick = mPlayerCard;
                }
            } else {
                if(mCardIsTrump){
                    // every no-trump-card is overtrumped by a trump
                    this.mTrick = mPlayerCard;
                } else if (aCard.getColour() == this.mTrick.mCard.getColour() ) {
                    // cards of the same colour can be overtrumped by value
                    if(aCard.getValue() > this.mTrick.mCard.getValue()){
                        this.mTrick = mPlayerCard;
                    }
                }
            }
        }

        if(mCardIsTrump) {
            this.mTrumpPlayed = true;
        }
    }

    public Player getWinner() {
        return this.mTrick.mPlayer;
    }

    class PlayerCard {
        Player mPlayer;
        Card mCard;

        protected PlayerCard (Player aPlayer, Card aCard) {
            this.mPlayer = aPlayer;
            this.mCard = aCard;
        }
    }
}
