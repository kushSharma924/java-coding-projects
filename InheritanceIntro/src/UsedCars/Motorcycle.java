package UsedCars;
public class Motorcycle extends Vehicle {
    private String color;
    public Motorcycle(String type, int year, double price, String color) {
        super(type, year, price);
        this.color = color;
    }
    @Override
    public String getInfo() {
        return super.getInfo() + ", " + color + ", $" + super.getPrice();
    }
}
