package UsedCars;
public class Truck extends Vehicle{
    private int towing;
    public Truck(String type, int year, double price, int towing) {
        super(type, year, price);
        this.towing = towing;
    }
    public boolean canTowBoat() {
        return (towing >= 2000) ? true : false;
    }
    @Override
    public String getInfo() {
        return super.getInfo() + ", " + towing + " lbs. towing, $" + super.getPrice();
    }
}
