package iteem.lupfenforandroid;

import android.content.Intent;

/**
 * Singleton to exchange a player-object
 */
public class ActivePlayer extends Player {

    private static ActivePlayer player;
    private static Card cardToPlay;

    public static Player getInstance() {
        if(player == null) {
            player = new ActivePlayer();
        }
        return player;
    }

    @Override
    public Card playCard() {
        //DEBUG System.out.println
        System.out.println("ActivePlayer::playCard()");
        cardToPlay = null;
        // work with Intents?
        return this.playableCards.get(0);
    }
}
