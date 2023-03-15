// 4
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Runner {
    public static void main(String[] args) throws FileNotFoundException{
//      a
        Scanner in = new Scanner(new File("players.txt"));
//      b
        int p = in.nextInt();
        Team liberty = new Team(p);
//      c
        for (int i = 0; i < p; i++) {
            String name = in.next();
            int number = in.nextInt();
            int atBats = in.nextInt();
            int hits = in.nextInt();
            Player player = new Player(name, number, atBats, hits);
            liberty.addPlayer(i, player);
        }
//      d
        liberty.printTeamStats();
    }
}
