package iteem.lupfenforandroid;

import java.util.Vector;
import java.util.Stack;
import java.util.Iterator;

public class Table {
    private Player dealer;
    private Player player;
    private Deck deck;
    private Stack<Card> stack;
    private Playround players; 
    private Trick trick;

    public Table(Deck aDeck) {
        this.deck = aDeck;
        this.players = new Playround();
    }

    public void startRound() {
        this.stack = this.deck.shuffle();
        this.deal(3); 
    }

    public void lupf() {
        this.trick = new Trick(this.stack.pop());
        // DEBUG
        System.out.println("Es ist " + this.trick.getTrumpColour());
    }

    private void deal(int aNoOfCards) {
        this.players.lastPlayer(this.dealer);

        for(int i = 1; i <= aNoOfCards; i++) {
            for (Player player: this.players) {
                // DEBUG
                System.out.println(player);
                player.receiveCard(this.stack.pop());
            }
        }
        // DEBUG
        System.out.println(this.stack);
    }

    public void addPlayer(Player aPlayer) { 
        this.players.add(aPlayer);
        if (this.dealer == null) {
            this.dealer = aPlayer;
        }
    }

    private class Playround extends Vector<Player>{
       int currentPlayer;
       int starting;
       int lastIndex;
       
       public Playround() {
           super();
           this.currentPlayer = 0;
           this.lastIndex = 0;
       }
       public void lastPlayer(Player aPlayer) {
           this.lastIndex = this.indexOf(aPlayer);
       }
       public void firstPlayer(Player aPlayer) {
           int index = this.indexOf(aPlayer) - 1;
           if(index<0) {
               index = 0;
           }

           this.lastIndex = index;
       }

       @Override
       public Iterator<Player> iterator() {
           return new PlayerIterator(this, this.lastIndex);
       }

       private class PlayerIterator implements Iterator<Player> {

           Playround data;
           int currentIndex;
           int lastIndex;

           public PlayerIterator(Playround aData, int aLastIndex) {
               this.data = aData;
               this.currentIndex = aLastIndex;
               this.currentIndex = this.getNextIndex();
               this.lastIndex = aLastIndex;
               // DEBUG
               System.out.println(aLastIndex);
           }
            
           @Override
           public boolean hasNext() {
               return (this.currentIndex != this.lastIndex); 
           }
           
           @Override
           public Player next() {
               this.currentIndex = this.getNextIndex();
               return this.data.elementAt(this.currentIndex); 
           }
           
           private int getNextIndex() {
               int nextIndex = this.currentIndex + 1;
               if (nextIndex >= this.data.size()) {
                   nextIndex = 0;
               }
               return nextIndex;
           }

           @Override
           public void remove() {
               throw new UnsupportedOperationException();
           }

       }
    }

    
}
