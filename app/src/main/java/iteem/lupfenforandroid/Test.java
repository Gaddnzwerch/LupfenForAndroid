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
        do {
            table.startRound();
            table.lupf();
            table.playRound();
            table.finishRound();
        } while (table.getPot() != 0);
    }
}
