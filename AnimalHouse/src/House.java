import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class House {
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    public void add(Animal a) {
        animals.add(a);
    }
    public void printAnimals() {
        for (Animal a : animals) {
            System.out.println(a);
        }
    }
    public void cleanHouse() {
        for (int i = 0; i < animals.size(); i++) {
            Animal a = animals.get(i);
            ArrayList<Toy> t = a.getToys();
            for (int j = 0; j < t.size(); j++) {
                for (int k = 0; k < t.size(); k++) {
                    if (j != k && t.get(k).equals(t.get(j))) {
                        t.remove(t.get(k));
                    }
                }
            }
            a.setToys(t);
        }
    }
}
