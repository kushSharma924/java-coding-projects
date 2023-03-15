import java.util.*;
public class Bookstore {

    private ArrayList<Book> inventory;

    public Bookstore() {
        inventory = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        inventory.add(book);
    }

    public ArrayList<Book> getInventory() {return inventory;}

    public int numBooks() {
        return inventory.size();
    }

    public Book getBook(int index) {
        return (0 <= index && index < numBooks()) ? inventory.get(index) : null;
    }

}
