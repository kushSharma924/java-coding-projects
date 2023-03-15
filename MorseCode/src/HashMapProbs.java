import java.util.*;
import java.io.*;
public class HashMapProbs {
    public static void main(String[] args) throws FileNotFoundException{
        HashMap<String, String> animalSounds = new HashMap<String, String>();
        animalSounds.put("Dog", "Bark");
        animalSounds.put("Cat", "Meow");
        animalSounds.put("Lion", "Roar");
        animalSounds.put("Cow", "Moo");
        System.out.println(animalSounds);
        System.out.print("Enter a word: ");
        Scanner input = new Scanner(System.in);
        String s = input.next();
        System.out.println(animalSounds.get(s));
        System.out.println(animalSounds.keySet().size());
        System.out.print("Enter the name of an animal: ");
        String newAnimal = input.next();
        System.out.print("Enter the name of it's sound: ");
        String newSound = input.next();
        animalSounds.put(newAnimal, newSound);
        System.out.println(animalSounds);
        System.out.println(takeBefore("str", "bye"));
        System.out.println(multiple("hello"));
        System.out.println(charWord(new String[] {"tea", "salt", "soda", "taco"}));
        highestFrequencyWordInDreamTxt();
        MorseCode mc = new MorseCode();
        System.out.println(mc.encode("hello world"));
        System.out.println(mc.decode("--- -- --. | .. - | .-- --- .-. -.- . -.. "));
    }

    public static HashMap<String, String> takeBefore(String a, String b) {
        HashMap<String, String> hm = new HashMap<String, String>();
        for (int i = 0; i < a.length(); i++) {
            boolean alessb = a.charAt(i) < b.charAt(i);
            if (alessb) {
                hm.put(a.substring(i, i + 1), b.substring(i, i + 1));
            }
            else {
                hm.put(b.substring(i, i+1), a.substring(i, i + 1));
            }
        }
        return hm;
    }

    public static HashMap<String, Boolean> multiple(String s) {
        HashMap<String, Boolean> hm = new HashMap<String, Boolean>();
        for (int i = 0; i < s.length(); i++) {
            if (hm.put(s.substring(i, i + 1), false) != null) {
                hm.put(s.substring(i, i + 1), true);
            }
        }
        return hm;
    }

    public static HashMap<String, String> charWord(String[] words) {
        HashMap<String, String> hm = new HashMap<String, String>();
        for (String word : words) {
            String s = word.substring(0, 1);
            if (hm.get(s) == null) {
                hm.put(s, word);
            }
            else {
                hm.put(s, hm.get(s) + word);
            }
        }
        return hm;
    }

    public static void highestFrequencyWordInDreamTxt() throws FileNotFoundException {
        Scanner reader = new Scanner(new File("dream.txt"));
        HashMap<String, Integer> freq = new HashMap<String, Integer>();
        while (reader.hasNext()) {
            String word = reader.next().toLowerCase();
            if (freq.get(word) == null) {
                freq.put(word, 0);
            }
            else {
                freq.put(word, freq.get(word)+1);
            }
        }
        int max = Collections.max(freq.values()); // the largest value in the map

        // we will assume there is only one maximum
        for (String key : freq.keySet()) // iterate through all the keys in the map
            if (freq.get(key) == max) //if this key's value matches max...
                System.out.println("Highest frequency word: " + key + ", " + max);
    }
}
