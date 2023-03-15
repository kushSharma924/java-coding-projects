import java.awt.Color;
public class Circle {
    private int x;
    private int y;
    private int radius;
    private Color color;
    private int dx;
    private int dy;

    public Circle(int x, int y, int radius, Color color, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.dx = dx;
        this.dy = dy;
    }
    public Circle(int x, int y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getR() {
        return radius;
    }
    public void draw() {
        StdDraw.setPenColor(color);//set the current color of the drawing window
        StdDraw.filledCircle(x, y, radius);//draw a filled circle at <x, y>,diam of radius*2
    }
    public static void main(String[] args) {
        new Circle(0, 0, 1, new Color(255, 0, 0)).draw();//x, y, rad, colo
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public boolean overlaps(Circle other) {
        return ((Math.sqrt(Math.pow(other.getX() - this.getX(), 2) + Math.pow(other.getY() - this.getY(), 2))) < this.getR() + other.getR());
    }

    public void update(int screenSize) {
        x += dx;
        y += dy;
        bounce(screenSize);
    }

    public void bounce(int s) {
        if (x > s - radius) {
            x -= dx;
            dx = -dx;
        }
        if (y > s - radius) {
            y -= dy;
            dy = -dy;
        }
        if (y < 0 + radius) {
            y -= dy;
            dy = -dy;
        }
        if (x < 0 + radius) {
            x -= dx;
            dx = -dx;
        }
    }
}
