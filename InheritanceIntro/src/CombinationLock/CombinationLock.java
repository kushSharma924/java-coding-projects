package CombinationLock;
import java.util.Scanner;
public class CombinationLock extends Lock {
    private String combination;
    public void open() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the combination: ");
        String userCombo;
        userCombo = input.next();
        if (combination.equals(userCombo)) super.open();
    }
    public String toString() {
        return super.toString() + "\nCombination = " + combination + "\n";
    }
    public void setCombination(String combination) {
        this.combination = combination;
    }
    public String getCombination() {
        return combination;
    }
    public CombinationLock() {
        super();
        combination = "";
    }
    public CombinationLock(String combo) {
        super();
        combination = combo;
    }
}
