package iteem.lupfenforandroid;

/**
 * Singleton to exchange a player-object
 */
public class ActivePlayer {

    private static Player player;

    public static Player getInstance() {
        if(player == null) {
            player = new Player();
        }
        return player;
    }
}
