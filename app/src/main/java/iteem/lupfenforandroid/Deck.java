package iteem.lupfenforandroid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck extends ArrayList<Card> {

    private String mName;

    public Deck(String aName){
        this.mName = aName;
    }

    public Stack<Card> shuffle() {
        Stack<Card> mCards = new Stack<>();

        Collections.shuffle(this);

        for (Card e : this) {
            mCards.push(e);
        }
        return mCards; 
    }

    public String getName() {
        return this.mName;
    }

    @Override
    public String toString() {
        return this.mName + " " + this.size();
    }
}
