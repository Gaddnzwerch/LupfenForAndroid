package iteem.lupfenforandroid;
import java.util.ArrayList;
import java.util.Collections;

public class Deck extends ArrayList<Card> {

    private String mName;

    public Deck(aName){
        this.mName = aName;
    }

    public Stack<Card> shuffle() {
        Stack<Card> mCards = new Stack<Card>();

        for (Card e : Collections.shuffle(this)) {
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
