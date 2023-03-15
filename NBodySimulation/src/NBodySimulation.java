import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class NBodySimulation
{
	private Body[] bodies;    //stores all the bodies in the simulation
	private int    numBodies; //number of bodies in this simulation
	private double uRadius;   //radius of the universe
	private String fileName;  //file providing the input

	public NBodySimulation(String nameOfFile) throws FileNotFoundException
	{
		fileName = nameOfFile;
		File file = new File(fileName);
		Scanner in = new Scanner(file);
		numBodies = in.nextInt();
		uRadius = in.nextDouble();
		bodies = new Body[numBodies];
		for (int i =0; i < bodies.length; i++) {
			double x = in.nextDouble();
			double y = in.nextDouble();
			double xVelocity = in.nextDouble();
			double yVelocity = in.nextDouble();
			double mass = in.nextDouble();
			String imageName = in.next();
			bodies[i] = new Body(x, y, xVelocity, yVelocity, mass, imageName);
		}
		initCanvas(); //don't move, should be the last line of the constructor
	}
//	90 = Degrees in a Right Angle
	/** initialize the drawing canvas */
	private void initCanvas()
	{
		StdDraw.setScale(-uRadius, uRadius); //set canvas size / scale
		StdDraw.picture(0, 0, "starfield.jpg"); //paint background

		//below is a for-each loop, which we will cover in the next lab
		//more info is available in the powerpoints, for the curious
		for (Body body : bodies)
			body.draw();
	}

	/**
	 * run the n-bodies simulation
	 * @param T total time to run the simulation, in seconds
	 * @param dt time step, in seconds
	 */
	public void run(double T, double dt)
	{
		for (int t = 0; t < T; t += dt) {
			for (Body b : bodies) {
				b.setNetForce(bodies);
				b.update(dt);
				StdDraw.picture(0, 0, "starfield.jpg");
				for (Body body : bodies) {
					body.draw();
				}
				StdDraw.show(10);
			}
		}
	}
}
