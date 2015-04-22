package iteem.lupfenforandroid;
import java.util.Stack;

public class Test {

    public static void main(String[] args){
        Deck deck = new Deck("Deutsches Blatt");
        deck.add(new Card(2,"Unter","Schellen"));
        deck.add(new Card(3,"Ober","Schellen"));
        deck.add(new Card(4,"K�nig","Schellen"));
        deck.add(new Card(10,"10","Schellen"));
        deck.add(new Card(11,"Ass","Schellen"));
        deck.add(new Card(2,"Unter","Gras"));
        deck.add(new Card(3,"Ober","Gras"));
        deck.add(new Card(4,"K�nig","Gras"));
        deck.add(new Card(10,"10","Gras"));
        deck.add(new Card(11,"Ass","Gras"));
        deck.add(new Card(2,"Unter","Herz"));
        deck.add(new Card(3,"Ober","Herz"));
        deck.add(new Card(4,"K�nig","Herz"));
        deck.add(new Card(10,"10","Herz"));
        deck.add(new Card(11,"Ass","Herz"));
        deck.add(new Card(2,"Unter","Eichel"));
        deck.add(new Card(3,"Ober","Eichel"));
        deck.add(new Card(4,"K�nig","Eichel"));
        deck.add(new Card(10,"10","Eichel"));
        deck.add(new Card(11,"Ass","Eichel"));

        Table table = new Table(deck);
        Stack<Card> cardStack = deck.shuffle();
        table.addPlayer(new Player());
        table.addPlayer(new Player());
        table.addPlayer(new Player());
        table.addPlayer(new Player());
        table.addPlayer(new Player());
        table.startRound();
        table.lupf();
        table.playRound();
        table.finishRound();
        /*
        for (int i = 0; i<3; i++) {
            player1.receiveCard(cardStack.pop());
            player2.receiveCard(cardStack.pop());
            player3.receiveCard(cardStack.pop());
        }
        Trick trick = new Trick(cardStack.pop());
        // DEBUG
        System.out.println(trick.getTrumpColour() + " ist Trumpf");
        player1.calculatePlayableCards(trick);
        trick.play(player1, player1.playCard());
        player2.calculatePlayableCards(trick);
        trick.play(player2, player2.playCard());
        player3.calculatePlayableCards(trick);
        trick.play(player3, player3.playCard());
        System.out.println(trick.getWinner());
        System.out.println(cardStack);
        */
    }
}
