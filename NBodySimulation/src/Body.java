public class Body
{
//	fields
	public static final double G = 6.67E-11;  //Newtons' gravitational constant

	private double x, y; //planet's x and y coordinate position
	private double xVelocity, yVelocity;
	private double mass;
	private double xNetForce, yNetForce; //net forces action on this planet
	private double xAccel, yAccel;
	private String image; //image of this planet (for drawing)
//	constructors
	public Body(double x, double y, double xVelocity, double yVelocity, double mass, String image) {
		this.x = x;
		this.y = y;
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
		this.mass = mass;
		this.image = image;
		xAccel = 0;
		yAccel = 0;
		xNetForce = 0;
		yNetForce = 0;
	}
//	methods
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getMass() {
		return mass;
	}
	private double getDistance(Body other) {
		double dx = other.x - this.x;
		double dy = other.y - this.y;
		return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
	}
	private double getPairwiseForce(Body other) {
		double force = (G * this.mass * other.mass)/(Math.pow(this.getDistance(other), 2));
		return force;
	}
	private double getPairwiseForceX(Body other) {
		double cosTheta = (other.x - this.x)/this.getDistance(other);
		double xForce = this.getPairwiseForce(other) * cosTheta;
		return xForce;
	}
	private double getPairwiseForceY(Body other) {
		double sinTheta = (other.y - this.y)/this.getDistance(other);
		double yForce = this.getPairwiseForce(other) * sinTheta;
		return yForce;
	}
	/** calculates / sets the net force exerted on this body by all the (input) bodies */
	public void setNetForce(Body[] bodies)
	{
		this.xNetForce = 0; this.yNetForce = 0;
		for (int i = 0; i < bodies.length; i++) {
			if (bodies[i] == this) {
				continue;
			}
			this.xNetForce += this.getPairwiseForceX(bodies[i]);
			this.yNetForce += this.getPairwiseForceY(bodies[i]);
		}
	}

	/** updates this body's accel, vel, and position, given the time step */
	public void update(double dt)
	{
		xAccel = xNetForce/mass;
		yAccel = yNetForce/mass;
		xVelocity += xAccel * dt;
		yVelocity += yAccel * dt;
		x += xVelocity * dt;
		y += yVelocity * dt;




	}

	/** Draws the body using the StdDraw library file's drawing method */
	public void draw()
	{
		StdDraw.picture(x, y, image);
	}

	public static void main(String[] args) {
		Body earth = new Body(0.5, 0.5, 0, 0, 0, "earth.gif");
		earth.draw();
		Body mars = new Body(1, 1, 0, 0, 0, "mars.gif");
		System.out.println(earth.getDistance(mars));
		Body forceTest1 = new Body(0, 0, 0, 0, 6e24, "");
		Body forceTest2 = new Body(1, 1, 0, 0, 7e24, "");
		System.out.println(forceTest1.getPairwiseForce(forceTest2));
		System.out.println(forceTest1.getPairwiseForceX(forceTest2));
		System.out.println(forceTest1.getPairwiseForceY(forceTest2));
		System.out.println(Math.sqrt((Math.pow(forceTest1.getPairwiseForceX(forceTest2), 2)) + (Math.pow(forceTest1.getPairwiseForceY(forceTest2), 2))));

	}
}
