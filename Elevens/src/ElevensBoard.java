import java.util.List;
import java.util.ArrayList;
public class ElevensBoard extends Board {
	private static final int BOARD_SIZE = 9;
	private static final int[] POINT_VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};
	private static final boolean I_AM_DEBUGGING = false;
	public ElevensBoard() {
		super();
		cards = new Card[BOARD_SIZE];
		deck = new Deck(RANKS, SUITS, POINT_VALUES);
		if (I_AM_DEBUGGING) {
			System.out.println(deck);
			System.out.println("----------");
		}
		dealMyCards();
	}
	public boolean isLegal(List<Integer> selectedCards) {
		if (containsJQK(selectedCards)) {
			return true;
		}
		if (containsPairSum11(selectedCards)) {
			return true;
		}
		return false;
	}
	private boolean containsPairSum11(List<Integer> selectedCards) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < selectedCards.size(); i++) {
			for (int j = 0; j < selectedCards.size(); j++) {
				if (cardAt(selectedCards.get(i)).pointValue() + cardAt(selectedCards.get(j)).pointValue() == 11) {
					return true;
				}
			}
		}
		return false;
	}
	private boolean containsJQK(List<Integer> selectedCards) {
		boolean containsK = false;
		boolean containsQ = false;
		boolean containsJ = false;
		for (int i = 0; i < selectedCards.size(); i++) {
			if (cardAt(selectedCards.get(i)).rank().equals("jack")) {
				containsJ = true;
			}
			if (cardAt(selectedCards.get(i)).rank().equals("queen")) {
				containsQ = true;
			}
			if (cardAt(selectedCards.get(i)).rank().equals("king")) {
				containsK = true;
			}
		}
		return containsJ && containsQ && containsK;
	}
}
