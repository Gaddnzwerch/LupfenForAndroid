package iteem.lupfenforandroid;

public class Card {
    private int mValue;
    private String mColour;
    private String mName;
    private String mImage;

    public Card(int aValue, String aName, String aColour) {
        this.mValue = aValue;
        this.mName = aName;
        this.mColour = aColour;
    }

    public int getValue() {
        return mValue;
    }

    public String getColour() {
        return mColour;
    }

    public String getName() {
        return mName;
    }

    @Override
    public String toString() {
        return this.mColour + " " + this.mName;
    }
}
