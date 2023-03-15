// 1
public class Player {
    // fields
    private String name;
    private int number;
    private int atBats;
    private int hits;
    // constructors
    public Player(String pName, int pNum) {
        name = pName;
        number = pNum;
        atBats = 0;
        hits = 0;
    }
    public Player(String pName, int pNum, int atB, int pHit) {
        name = pName;
        number = pNum;
        atBats = atB;
        hits = pHit;
    }
    // methods
    public String getName() {
        return name;
    }
    public int getNumber() {
        return number;
    }
    public int getAtBats() {
        return atBats;
    }
    public int getHits() {
        return hits;
    }
    public double getBattingAverage() {
        if (atBats == 0)
            return 0.0;
        return (double) hits / atBats;
    }
    public String getBattingAverageString() {
        int battingAverage = (int) Math.round(getBattingAverage() * 1000);
        return Integer.toString(battingAverage);
    }
    // 2 You are a plant
}
