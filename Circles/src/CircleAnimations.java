import java.awt.Color;
import java.util.ArrayList;
import java.util.*;
import java.util.Random;
public class CircleAnimations {
	private ArrayList<Circle> circles; //the circles to animate
	private int size;    //canvas width and height (will be square)
	private Random rng;     //use to make random numbers

	/** create a drawing pane of a particular size */
	public CircleAnimations(int s) {
		circles = new ArrayList<>();
		size    = s;
		rng     = new Random();

		//don't mess with this
		StdDraw.setCanvasSize(size, size); //set up drawing canvas
		StdDraw.setXscale(0, size);        //<0, 0> is bottom left.  <size-1, size-1> is top right
		StdDraw.setYscale(0, size);
	}

	public void drawCircles() {
		for (int i = 0; i < circles.size(); i++) {
			circles.get(i).draw();
		}
	}

	public void addCircles() {
		for (int i = 0; i < 3; i++) {
			int r = rng.nextInt(69) + 1; // 1 <= r <= 69
			int x = rng.nextInt(size - 2 * r) + r;
			int y = rng.nextInt(size - 2 * r) + r;
			int red = rng.nextInt(256);
			int green = rng.nextInt(256);
			int blue = rng.nextInt(256);
			Circle c = new Circle(x, y, r, new Color(red, green, blue));
			circles.add(c);
		}
		drawCircles();
	}

	public void addCircles(int n) {
		for (int i = 0; i < n; i++) {
			int r = rng.nextInt(69) + 1; // 1 <= r <= 69
			int x = rng.nextInt(size - 2 * r) + r;
			int y = rng.nextInt(size - 2 * r) + r;
			int red = rng.nextInt(256);
			int green = rng.nextInt(256);
			int blue = rng.nextInt(256);
			Circle c = new Circle(x, y, r, new Color(red, green, blue));
			circles.add(c);
		}
		drawCircles();
	}

	public boolean listOverlap(Circle c) {
		boolean isOverlap = false;
		for (int i = 0; i < circles.size(); i++) {
			if (c.overlaps(circles.get(i))) {
				isOverlap = true;
			}
		}
		return isOverlap;
	}

	public void noOverlapping(int n) {
		for (int i = 0; i < n; i++) {
			Circle c;
			do {
				int r = rng.nextInt(69) + 1; // 1 <= r <= 69
				int x = rng.nextInt(size - 2 * r) + r;
				int y = rng.nextInt(size - 2 * r) + r;
				int red = rng.nextInt(256);
				int green = rng.nextInt(256);
				int blue = rng.nextInt(256);
				c = new Circle(x, y, r, new Color(red, green, blue));
			} while (listOverlap(c));
			circles.add(c);
		}
		drawCircles();
	}

	public void movingCircles(int n) {
		noOverlapping(n);
		StdDraw.clear();
		for (int i = 0; i < circles.size(); i++) {
			circles.get(i).setDx(rng.nextInt(5) + 1); // 1 <= dx <= 5
			circles.get(i).setDy(rng.nextInt(5) + 1); // 1 <= dy <= 5
		}
		while (true) {
			drawCircles();
			for (int i = 0; i < circles.size(); i++) {
				circles.get(i).update(size);
			}
			StdDraw.show(10);
			StdDraw.clear();
			drawCircles();
		}
	}

	public void removeClicked(int n) {
		noOverlapping(n);
		while (true) {
			if (StdDraw.isMousePressed()) {
				for (int i = 0; i < circles.size(); i++) {
					double dist = (Math.sqrt(Math.pow(StdDraw.mouseX() - circles.get(i).getX(), 2) + Math.pow(StdDraw.mouseY() - circles.get(i).getY(), 2)));
					if (dist < circles.get(i).getR()) {
						circles.remove(circles.get(i));
						System.out.println(Arrays.toString(circles.toArray()));
						StdDraw.clear();
						drawCircles();
						i--;
					}
				}
				StdDraw.show(10);
			}
		}
	}
}
