
public class Card {

    String Suit;
    String Value;
    int Num;
    String Name;

    public Card(String suit, String value, int num) {
        this.Suit = suit;
        this.Value = value;
        this.Num = num;
        this.Name = value + " of " + suit;
    }

}

