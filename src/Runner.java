
public class Runner {
    public static void main(String[] args) {
        Deck d = new Deck(true);
        d.shuffleDeck();
        d.dealHand(30);
        d.hand = d.divideAndConquer(d.hand);
        d.binaryResult(7);
        d.listHand();
    }
}
