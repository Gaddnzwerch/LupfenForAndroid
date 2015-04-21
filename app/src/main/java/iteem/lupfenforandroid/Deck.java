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
}
