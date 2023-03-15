// 3
public class Team {
    // fields
    private Player[] players;
    // constructors
    public Team() {
        players = new Player[12];
    }
    public Team(int numPlayers) {
        players = new Player[numPlayers];
    }
    // methods
    public void addPlayer(int index, Player p) {
        players[index] = p;
    }
    public Player getPlayerAtIndex(int i) {
        return players[i];
    }
    public void printTeamStats() {
        for (Player p : players) {
            System.out.printf("%-7s#%-6d average >>> %3s", p.getName(), p.getNumber(), p.getBattingAverageString());
            System.out.println("");
        }
    }
}
