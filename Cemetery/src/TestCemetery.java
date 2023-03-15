import java.io.*;
public class TestCemetery {
    public static void main(String[] args) throws FileNotFoundException{
        Cemetery cemetery = new Cemetery("cemetery.txt");
        int sum = 0;
        int count = 0;
        for (int i = 0; i < cemetery.tombstones.size(); i++) {
            if (cemetery.getTombstones().get(i).getAddress().indexOf("Little Carter Lane") != -1) {
                sum += cemetery.tombstones.get(i).getAge();
                count++;
            }
        }
        System.out.println("The average age of all people that lived on Little Carter Lane is: " + Math.round((sum + 0.0)/count * 10.0)/10.0);
    }
}
