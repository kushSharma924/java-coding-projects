import java.util.*;
public class ArrayListProbs {
    public ArrayListProbs() {
        ;
    }

    public void makeListAndPrint(int num, int limit) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < num; i++) {
            int randInt = (int)(Math.random() * limit) + 1;
            a.add(randInt);
        }
        System.out.println(a.toString());
    }

    public ArrayList<Integer> addOne(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + 1);
        }
        return list;
    }

    public ArrayList<Integer> minToFront(ArrayList<Integer> list) {
        int min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
        }
        list.add(0, min);
        return list;
    }

    public ArrayList<String> removeDupes(ArrayList<String> list) {
        Set<String> s = new LinkedHashSet<String>(list);
        list = new ArrayList<String>(s);
        return list;
    }

    public ArrayList<Integer> swapPairs(ArrayList<Integer> list) {
        for (int i = 1; i < list.size(); i += 2) {
            int temp = list.get(i);
            list.set(i, list.get(i - 1));
            list.set(i - 1, temp);
        }
        return list;
    }

    public ArrayList<String> removeLenN(ArrayList<String> list, int n) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == n) {
                list.remove(i);
                i--;
            }
        }
        return list;
    }

    // e

    public int dumbestPerson(ArrayList<Person> list) {
        int dumbestIQ = list.get(0).getIQ();
        int dumbestPerson = 0;
        for (int i = 1; i < list.size(); i++) {
            if (dumbestIQ > list.get(i).getIQ()) {
                dumbestIQ = list.get(i).getIQ();
                dumbestPerson = i;
            }
        }
        return dumbestPerson;
    }

    public Book highestPricedBook(ArrayList<Book> list) {
        double highestPrice = list.get(0).getPrice();
        Book highestPricedBook = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (highestPrice < list.get(i).getPrice()) {
                highestPrice = list.get(i).getPrice();
                highestPricedBook = list.get(i);
            }
        }
        return highestPricedBook;
    }

    public ArrayList<Book> banBook(ArrayList<Book> list, Book book) {
        for (int i = 0; i < list.size(); i++) {
            if (book.getTitle().equals(list.get(i).getTitle())) {
                list.remove(i);
                i--;
            }
        }
        return list;
    }

    public double bookstoreValue(Bookstore store) {
        double sum = 0;
        for (int i = 0; i < store.getInventory().size(); i++) {
            sum += store.getInventory().get(i).getPrice();
        }
        return sum;
    }
}
