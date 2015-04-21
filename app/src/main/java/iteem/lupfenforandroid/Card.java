package iteem.lupfenforandroid;

public class Card {
    private int value;
    private String colour;
    private String name;
    private String image;

    public Card(int aValue, String aName, String aColour) {
        this.value = aValue;
        this.name = aName;
        this.colour = aColour;
    }

    @Override
    public String toString() {
        return this.colour + " " + this.name;
    }

    public String getColour() {
        return this.colour;
    }
    public String getName() {
        return this.name;
    }
    public int getValue() {
        return this.value;
    }

}
