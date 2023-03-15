public class Point {
	private double  x, y;
	private boolean visited;
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
		visited = false;
	}
	/** get the Euclidean distance between two points */
	public double getDistance(Point other) {
		return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
	}
	@Override
	public String toString() {
		return "x: " + x + ", y: " + y + "\n";
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public boolean getVisited() {
		return visited;
	}
	public void setVisited(boolean b) {
		visited = b;
	}
}
