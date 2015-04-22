package iteem.lupfenforandroid;

import java.util.Stack;

public class Round {
    private Playround players; // the active players for this round
    private Boolean isObligatory; // if true, all players must play 
    private Stack<Card> stack;
    private Trick trick; 

    public Round(Stack<Card> aShuffledCards) {
        this.stack = aShuffledCards;
        this.players = new Playround();
    }

    public void addPlayer(Player aPlayer) {
        this.players.add(aPlayer);
    }

    public void addPlayer(Playround aPlayround) {
        this.players = aPlayround;
    }
    public void lupf() { 
        this.trick = new Trick(this.stack.pop());
        // DEBUG 
        System.out.println("Es ist " + this.trick.getTrumpColour());
    }

    public Player playTrick() {
        for(Player player:this.players) {
            player.calculatePlayableCards(this.trick);
            this.trick.play(player, player.playCard());
        }
        Player winner = this.trick.getWinner();
        winner.addTrick(this.trick);
        this.players.firstPlayer(winner);
        return winner; 
    }

    public void play() {
        // TODO avoid magic numbers
        for (int i = 1; i <= 3; i++) {
            // DEBUG
            System.out.println("Playing trick :" + i);
            this.trick = new Trick(this.trick.getTrump());
            System.out.println("Stich geht an: " + this.playTrick());
        }
    }

    public Boolean isObligatory() {
        return this.isObligatory;
    }
    
    public void setObligatory(Boolean aObligatory) {
        this.isObligatory = aObligatory;
    } 

    public Playround getPlayers() {
        return this.players;
    }
}
