package UsedCars;
public class VehiclesRunner {
    public static void main(String[] args) {
        Car c = new Car("Tesla Model S", 2021, 69420.69, 235.4);
        Car d = new Car("Random Car", 1945, 0.01, 1);
        Truck t = new Truck("Ford F150", 2008, 34999.99, 1999);
        Truck u = new Truck("Garbage Truck", 2004, 49999.99, 5000);
        System.out.println(c.greatMPG()); // true
        System.out.println(d.greatMPG()); // false
        System.out.println(c.getInfo()); // 2021 Tesla Model S, 235.4 mpg, $69420.69
        System.out.println(d.getInfo()); // 1945 Random Car, 1.0 mpg, $0.01
        System.out.println(t.canTowBoat()); // false
        System.out.println(u.canTowBoat()); // true
        System.out.println(t.getInfo()); // 2008 Ford F150, 1999 lbs. towing, $34999.99
        System.out.println(u.getInfo()); // 2004 Garbage Truck, 5000 lbs. towing, $49999.99
        Inventory i = new Inventory();
        i.addVehicle(c);
        i.addVehicle(d);
        i.addVehicle(t);
        i.addVehicle(u);
        System.out.println();
        i.listInventory(); // 4 lines of output
    }
}
