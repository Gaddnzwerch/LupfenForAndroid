package iteem.lupfenforandroid;

import java.util.Stack;

public class Table {
    private Player dealer;
    private Deck deck;
    private Stack<Card> stack;
    private Playround players; 
    private Trick trick;
    protected final int NOOFCARDS = 3;
    private final int BET = 5;
    private int pot;
    private iteem.lupfenforandroid.Round round;

    public Table(Deck aDeck) {
        this.deck = aDeck;
        this.players = new Playround();
        this.pot = 0;
    }

    public void startRound() {
        //DEBUG
        System.out.println("Am Tisch: " + this.players);

        Stack<Card> stack = this.deck.shuffle();
        this.deal(NOOFCARDS, stack);
        this.round = new iteem.lupfenforandroid.Round(stack);
        this.round.setObligatory(this.pot == 0);
    }

    public void preLupf() {
        if(this.round.isObligatory()) {
            for(Player player:this.players) {
                player.newRound();
                player.pay(BET);
                this.pot += BET;
                this.round.lupf();
                this.round.addPlayer(players);
            }
        } else {
            for(Player player:this.players) {
                if (player.decideToLupf(this.round)) {
                    // DEBUG
                    System.out.println(player + " hat gelupft!");
                    this.round.lupf();
                    this.round.addPlayer(player);
                    this.round.getPlayers().firstPlayer(player);
                    break;
                }
            }
        }
        this.players.lastPlayer(this.dealer);

        // DEBUG
        System.out.println("Pot: " + this.pot);
        System.out.println("dabei: " + this.round.getPlayers());
    }

    public void prePlay() {
        //TODO add obligatory colours here
        if(this.round.isObligatory()) {
            for(Player player:this.players) {
                this.round.addPlayer(players);
        }
        } else {
            for(Player player:this.players) {
                if (player.decideToPlay(this.round)) {
                    // TODO avoid adding the player that lupfed…
                    // DEBUG
                    System.out.println(player + " ist dabei!");
                    this.round.addPlayer(player);
                }
            }
        }
    }

    public void playRound() {
        this.round.play();
    }

    public void finishRound() {
        int oldPotSize = this.pot;
        int share = this.pot / 3;
        this.pot = 0;
        Playround players = this.round.getPlayers();
        for(Player player : players) {
            if(player.getTrickCount() == 0) {
                this.pot += oldPotSize;
                player.pay(oldPotSize);
            } else {
                player.win(player.getTrickCount() * share);
            }
            // DEBUG
            System.out.println(player + " : " + player.getWealth());
        }
        System.out.println("Pot: " + this.pot);
    }
    
    private void deal(int aNoOfCards, Stack<Card> aStack) {
        this.players.lastPlayer(this.dealer);

        for(int i = 1; i <= aNoOfCards; i++) {
            for (Player player: this.players) {
                player.receiveCard(aStack.pop());
            }
        }
    }

    public void addPlayer(Player aPlayer) { 
        this.players.add(aPlayer);
        if (this.dealer == null) {
            this.dealer = aPlayer;
        }
    }

    public int getPot() {
        return this.pot;
    }
}
