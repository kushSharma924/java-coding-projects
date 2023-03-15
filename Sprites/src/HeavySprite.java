public class HeavySprite extends BouncingSprite {
    public HeavySprite(int x, int y, int width, int height, String image, double vy, double vx) {
        super(x, y, width, height, image, vy, vx);
    }
    @Override
    public void step(World world) {
        super.step(world);
        super.setVy(super.getVy() - 0.1);
    }
}