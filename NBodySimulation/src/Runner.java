import java.io.FileNotFoundException;
import java.io.IOException;

public class Runner 
{
	public static void main(String[] args)
	{
		final double T = 1_000_000_000; //simulation time in seconds
		
		final double dt = 25_000; //time step in seconds, one day
		
		final String fileName = "planets.txt";
		NBodySimulation sim = null;
		try {
			sim = new NBodySimulation(fileName);
		} catch(FileNotFoundException e) {
			;
		}

		sim.run(T, dt);
	}
}
