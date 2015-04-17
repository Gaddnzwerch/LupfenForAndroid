package iteem.lupfenforandroid;

public class Card {
    private int mValue;
    private String mColour;
    private String mName;
    private String mImage;

    public Card(int aValue, String aName, String mColour) {
        this.mValue = aValue;
        this.mName = aName;
        this.mColour = aColour;
    } 

    @Override
    public String toString() {
        return this.mColour + " " + this.mName;
    }
}
