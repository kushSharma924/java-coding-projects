package CombinationLock;
public class Lock {
    private boolean locked;
    public Lock() {
        locked = false;
    }
    public void open() {
        locked = false;
    }
    public void close() {
        locked = true;
    }
    public boolean isLocked() {
        return locked;
    }
    public String toString() {
        return "Lock is " + ((locked) ? "closed" : "open");
    }
}
