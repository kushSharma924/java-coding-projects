public class Dog extends Animal {
    private boolean goodBoy;
    public Dog(String name, int birthYear, boolean goodBoy) {
        super(name, birthYear);
        this.goodBoy = goodBoy;
    }
    public String toString() {
        String ans = super.toString();
        if (goodBoy) {
            ans += "I am a good boy.\n";
        }
        else {
            ans += "I am not a good boy.\n";
        }
        return ans;
    }
}
