import java.util.*;
import java.io.*;
public class Cemetery {
    public ArrayList<Tombstone> tombstones;
    public Cemetery (String filename) throws FileNotFoundException{
        tombstones = new ArrayList<Tombstone>();
        Scanner lbl = new Scanner(new File(filename));
        while (lbl.hasNext()) {
            String line = lbl.nextLine();
            Scanner reader = new Scanner(line);
            String name = "";
            while (!reader.hasNextInt()) {
                name += reader.next() + " ";
            }
            String dateOfBurial = "";
            for (int i = 0; i < 3; i++) {
                dateOfBurial += reader.next() + " ";
            }
            String ageString = reader.next();
            int ageInDays = parseAge(ageString);
            int age = (int) Math.round(ageInDays/365.0);
            String address = "";
            while (reader.hasNext()) {
                address += reader.next() + " ";
            }
            tombstones.add(new Tombstone(name, dateOfBurial, age, address));
        }
    }

    public ArrayList<Tombstone> getTombstones() {
        return tombstones;
    }

    public static int parseAge(String ageString) {
        if (ageString.contains("d")) { //age supplied in days
            ageString = ageString.replaceAll("d", "");
            return Integer.parseInt(ageString);
        }
        int result = 0;
        boolean done = true;
        try { result = Integer.parseInt(ageString); } //is the String a whole number of years?
        catch (NumberFormatException n) { done = false; }
        if (done) //successfully parsed as an int, return value
            return 365 * result; //ignoring leap years
        double ageDouble = 0;
        done = true;
        try { ageDouble = Double.parseDouble(ageString); } //is the String a floating point number of years?
        catch (NumberFormatException n) { done = false; }
        if (done) { //successfully parse as a double, String doesn't contain any text
            return (int)(ageDouble * 365); //ignoring leap years, using 30 for days in a month
        }
        if (ageString.contains("w")) { //age is supplied in weeks, return appropriately
            ageString = ageString.replaceAll("w", "");
            return Integer.parseInt(ageString) * 7;
        }
        return 0;
    }
}
