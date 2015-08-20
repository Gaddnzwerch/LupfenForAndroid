package iteem.lupfenforandroid;
import java.util.Collections;
import java.util.Stack;

import java.util.Vector;

public class Deck extends Vector<Card> {

    private String name;

    public Deck(String aName) {
        this.name = aName;
    }

    public Stack<Card> shuffle() {
        Stack<Card> cards = new Stack<>();
        Collections.shuffle(this);

        for (Card e : this) {
            cards.push(e);
        }
        return cards; 
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name + " " + this.size();
    }

    public static Deck createDeck() {
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
        return deck;
    }
}
