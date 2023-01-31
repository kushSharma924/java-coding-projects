import java.util.ArrayList;
import java.util.Date;

public class Animal {
    private String name;
    private int birthYear;
    private ArrayList<Toy> collection = new ArrayList<Toy>();
    Animal friend = null;
    private static int currentYear = new Date(2023, 1, 19).getYear();
    public Animal(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }
    public void addToy(Toy t) {
        collection.add(t);
    }
    public void setFriend(Animal friend) {
        this.friend = friend;
    }
    public int getAge() {
        return currentYear - birthYear;
    }
    public String toString() {
        String ans = "Hello, I am " + name + ". I am " + getAge() + " years old. \n";
        if (friend == null) {
            ans += "I have no friends\n";
        }
        else {
            ans += "I have a friend named " + friend.name + "\n";
        }
        ans += "I have the following toys: ";
        ans += collection.toString();
        ans += "\n";
        return ans;
    }
    public ArrayList<Toy> getToys() {
        return collection;
    }
    public void setToys(ArrayList<Toy> t) {
        collection = t;
    }
}
