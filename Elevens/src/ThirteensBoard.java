import java.util.List;
import java.util.ArrayList;
public class ThirteensBoard extends Board {
    private static final int BOARD_SIZE = 10;
    private static final int[] POINT_VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0};
    public ThirteensBoard() {
        super();
        cards = new Card[BOARD_SIZE];
        deck = new Deck(RANKS, SUITS, POINT_VALUES);
        dealMyCards();
    }
    public boolean isLegal(List<Integer> selectedCards) {
        if (containsK(selectedCards)) {
            return true;
        }
        if (containsPairSum13(selectedCards)) {
            return true;
        }
        return false;
    }
    private boolean containsK(List<Integer> selectedCards) {
        for (int i = 0; i < selectedCards.size(); i++) {
            if (cardAt(selectedCards.get(i)).rank().equals("king")) {
                return true;
            }
        }
        return false;
    }
    private boolean containsPairSum13(List<Integer> selectedCards) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < selectedCards.size(); i++) {
            for (int j = 0; j < selectedCards.size(); j++) {
                if (cardAt(selectedCards.get(i)).pointValue() + cardAt(selectedCards.get(j)).pointValue() == 13) {
                    return true;
                }
            }
        }
        return false;
    }
}
