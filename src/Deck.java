import java.util.Random;

public class Deck {

    Card[] allCards;
    Card[] hand;
    String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    String[] cardz = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};


    public Deck(boolean x) {
        int i = 1;
        int y = 0;
        if (x) {
            i = 4;
        }
        int n = 13 * i;
        this.allCards = new Card[n];
        for (int k = 0; k < i; k++) {
            for (int j = 0; j < cardz.length; j++) {
                Card card = new Card(suits[k], cardz[j], y);
                this.allCards[y] = card;
                y++;
            }
        }
    }


    public void swap(Card[] arr, int first, int second) {
        Card x = arr[first];
        arr[first] = arr[second];
        arr[second] = x;
    }

    public void dealHand(int numCards) {
        hand = new Card[numCards];
        for (int i = 0; i < numCards; i++) {
            hand[i] = allCards[i];
        }
    }

    public void listHand() {
        for (int i = 0; i < hand.length; i++) {
            System.out.println(hand[i].Num);
        }
    }

    public void shuffleDeck() {
        Random rand = new Random();
        for (int i = allCards.length - 1; i > 0; i--) {
            int ind = rand.nextInt(i + 1);
            swap(allCards, i, ind);
        }
    }

    public void bubbleSortHand() {
        int n = hand.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (hand[j - 1].Num > hand[j].Num) {
                    swap(hand, j - 1, j);
                }
            }
        }
    }

    public void selectionSortHand() {
        int n = hand.length;
        for (int j = 0; j < n - 1; j++) {
            int ind = j;
            for (int i = j + 1; i < n; i++) {
                if (hand[i].Num < hand[ind].Num) {
                    ind = i;
                }
            }
            swap(hand, j, ind);
        }

    }

    //MERGESORT
    public Card[] divideAndConquer(Card[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr;
        }
        int mid = n / 2;
        Card[] leftArray = new Card[mid];
        Card[] rightArray = new Card[n - mid];
        System.arraycopy(arr, 0, leftArray, 0, leftArray.length);
        System.arraycopy(arr, leftArray.length, rightArray, 0, rightArray.length);
        divideAndConquer(leftArray);
        divideAndConquer(rightArray);
        merge(leftArray, rightArray, arr);
        return arr;
    }

    public void merge(Card[] leftArray,
                      Card[] rightArray,
                      Card[] sortedArray) {
        int leftArrayLength = leftArray.length;
        int rightArrayLength = rightArray.length;
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftArrayLength && j < rightArrayLength) {
            if (leftArray[i].Num < rightArray[j].Num) {
                sortedArray[k] = leftArray[i];
                i++;
            } else {
                sortedArray[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < leftArrayLength) {
            sortedArray[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightArrayLength) {
            sortedArray[k] = rightArray[j];
            j++;
            k++;
        }
    }


    public int binarySearch(Card[] arr, int i, int f, int x) {
        int mid = i + (f - 1) / 2;
        while(i <= f){
            if (hand[mid].Num == x) {
                return mid;
            }
            if (hand[mid].Num > x) {
                return binarySearch(arr, i, mid - 1, x);
            }
            if (hand[mid].Num < x) {
                return binarySearch(arr, mid + 1, f, x);
            }
        }
        return -1;
    }

    public void binaryResult(int num){
        int res = binarySearch(hand, 0, hand.length - 1, num);
        if (res == -1) {
            System.out.println("Element not present");
        }else{
            System.out.println("Element found at index " + res);
        }
    }
}
