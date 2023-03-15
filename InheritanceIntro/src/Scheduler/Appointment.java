package Scheduler;
public class Appointment extends Date {
    private String text;
    public String getText() {
        return text;
    }
    public String toString() {
        return super.toString() + " " + text;
    }
    public Appointment() {
        super();
        text = "";
    }
    public Appointment(int month, int day, int year, String text) {
        super(month, day, year);
        this.text = text;
    }

}
