import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class World
{
	private List<Sprite> sprites;
	private int          width;
	private int          height;

	/** construct a world 600x600 */
	public World() {
		this(600, 600);
	}

	public World(int h, int w)
	{
		height = h;
		width  = w;
		
		sprites = new ArrayList<>();

		StdDraw.setCanvasSize(width, height);
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(0, height);
		StdDraw.clear(Color.BLACK);
		addSprites();
	}

	/** add a sprite to the simulation */
	public void add(Sprite sprite)
	{
		this.sprites.add(sprite);
	}

	/** ask all sprites in simulation to update themselves */
	public void stepAll()
	{
		for (int i = 0; i < sprites.size(); i++)
			this.sprites.get(i).step(this);
	}

	/** get the width of the world */
	public int getWidth()
	{
		return width;
	}

	/** get the height of the world */
	public int getHeight()
	{
		return height;
	}

	/** get the number of sprites in the simulation currently */
	public int getNumSprites()
	{
		return sprites.size();
	}

	/** get the sprite at the given index */
	public Sprite getSprite(int index)
	{
		return sprites.get(index);
	}

	/** run the simulation, i.e. the main game loop */
	public void run()
	{
		int time = 0;
		while (true)
		{
			this.stepAll();
			this.drawAll();
			boolean bad = false;
			StdDraw.show(10); //don't worry about warning if using Eclipse
			StdDraw.clear(Color.BLACK);
			for (int i = 0; i < sprites.size() - 1; i++) {
				time++;
				if (sprites.get(sprites.size() - 1).overlaps(sprites.get(i))) {
					bad = true;
				}
			}
			if (bad) {
				break;
			}
		}
		System.out.println("Final Score: " + time);
	}

	/** draw all sprites in the simulation at their current positions */
	public void drawAll() {
		for (Sprite sprite : this.sprites)
			sprite.draw();
	}

	public static void main(String[] args)
	{
		World world = new World(600, 600);
		world.run();
	}

	private void addSprites() {
		StationarySprite stationarySquare = new StationarySprite(width/2, height/2, 50, 50, "square.png");
		sprites.add(stationarySquare);
		MobileSprite movingSquare = new MobileSprite(width/3, height/3, 25, 25, "square.png", 0.5, 0.5);
		sprites.add(movingSquare);
		BouncingSprite bouncingCircle = new BouncingSprite(width/4, height/4, 50, 50, "circle.png", -1.0, -1.0);
		sprites.add(bouncingCircle);
		for (int i = 0; i < 5; i++) {
			BouncingSprite b = new BouncingSprite((int)(Math.random() * 300), (int)(Math.random() * 600), (int)(Math.random() * 200), (int)(Math.random() * 200), "circle.png", Math.random() * 10 - 5, Math.random() * 10 - 5);
			sprites.add(b);
		}
		HeavySprite hs = new HeavySprite(width * 2 / 3, height * 2 / 3, 100, 100, "triangle.png", 5.0, 0);
		sprites.add(hs);
		ControllableSprite c = new ControllableSprite(450, 300, 50, 50, "sun.png");
		sprites.add(c);
	}
}
