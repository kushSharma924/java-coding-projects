import java.io.FileNotFoundException;
public class GreedyPath extends Path {
    private Point[] greedy;
    public GreedyPath(String fileName) throws FileNotFoundException {
        super(fileName);
        greedy = new Point[super.getPath().length];
        greedy[0] = super.getPoint(0);
        greedy[0].setVisited(true);
        for (int i = 1; i < greedy.length; i++) {
            Point minDistancePoint = new Point(2 * getMaxX() + 1, 2 * getMaxY() + 1);
            for (int j = 0; j < greedy.length; j++) {
                if ((greedy[i - 1].getDistance(minDistancePoint) > greedy[i - 1].getDistance(super.getPoint(j))) && !super.getPoint(j).getVisited()) {
                    minDistancePoint = super.getPoint(j);
                }
            }
            greedy[i] = minDistancePoint;
            greedy[i].setVisited(true);

        }
    }
    public double getDistance() {
        double ans = 0;
        for (int i = 1; i < greedy.length; i++) {
            ans += greedy[i].getDistance(greedy[i - 1]);
        }
        return ans;
    }
    public Point getPoint(int i) {
        return greedy[i];
    }
    public String toString() {
        return "Greedy Path of size: " + greedy.length + ", distance: " + getDistance() + "\n";
    }
}
