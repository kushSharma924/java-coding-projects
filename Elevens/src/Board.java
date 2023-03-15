import java.util.ArrayList;
import java.util.List;

public abstract class Board {
    public static final String[] RANKS = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
    public static final String[] SUITS = {"spades", "hearts", "diamonds", "clubs"};
    public Card[] cards;
    public Deck deck;
    public Board() {
        ;
    }
    public int size() {
        return cards.length;
    }
    public boolean isEmpty() {
        for (int k = 0; k < cards.length; k++) {
            if (cards[k] != null) {
                return false;
            }
        }
        return true;
    }
    public void deal(int k) {
        cards[k] = deck.deal();
    }
    public int deckSize() {
        return deck.size();
    }
    public Card cardAt(int k) {
        return cards[k];
    }
    public void replaceSelectedCards(List<Integer> selectedCards) {
        for (Integer k : selectedCards) {
            deal(k.intValue()); //intValue() returns the int value for an Integer object
        }
    }
    public void newGame() {
        deck.shuffle();
        dealMyCards();
    }
    public List<Integer> cardIndexes() {
        List<Integer> l = new ArrayList<Integer>();
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != null) {
                l.add(i);
            }
        }
        return l;
    }
    public String toString() {
        String s = "";
        for (int k = 0; k < cards.length; k++) {
            s = s + k + ": " + cards[k] + "\n";
        }
        return s;
    }
    public boolean gameIsWon() {
        if (deck.isEmpty()) {
            for (Card c : cards) {
                if (c != null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public boolean anotherPlayIsPossible() {
        ArrayList<Integer> a = (ArrayList<Integer>) cardIndexes();
        if (isLegal(a)) {
            return true;
        }
        return false;
    }
    public abstract boolean isLegal(List<Integer> selectedCards);
    public void dealMyCards() {
        for (int k = 0; k < cards.length; k++) {
            cards[k] = deck.deal();
        }
    }

}
