import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class Path {
	private Point[] points;
	private double  minX, minY; //min X and Y values, for setting canvas scale
	private double  maxX, maxY; //maxes
	/** construct a path from a given file */
	public Path(String fileName) throws FileNotFoundException {
		Scanner input = new Scanner(new File(fileName));
		int size = input.nextInt();
		minX = Integer.MAX_VALUE;
		minY = Integer.MAX_VALUE;
		maxX = Integer.MIN_VALUE;
		maxY = Integer.MIN_VALUE;
		points = new Point[size];
		for (int i = 0; i < size; i++) {
			double x = input.nextDouble();
			if (x > maxX) {
				maxX = x;
			}
			if (x < minX) {
				minX = x;
			}
			double y = input.nextDouble();
			if (y > maxY) {
				maxY = y;
			}
			if (y < minY) {
				minY = y;
			}
			Point p = new Point(x, y);
			points[i] = p;
		}
	}
	/** returns the distance traveled going point to point, in order given in file */
	public double getDistance() {
		double ans = 0;
		for (int i = 1; i < points.length; i++) {
			ans += points[i].getDistance(points[i - 1]);
		}
		return ans;
	}
	public double getMinX() {
		return minX;
	}
	public double getMinY() {
		return minY;
	}
	public double getMaxX() {
		return maxX;
	}
	public double getMaxY() {
		return maxY;
	}
	public int getNumPoints() {
		return points.length;
	}
	public Point[] getPath() {
		return points;
	}
	public Point getPoint(int i) {
		return points[i];
	}
	@Override
	public String toString() {
		return "Path of size: " + points.length + ", distance: " + getDistance() + "\n";
	}
}
