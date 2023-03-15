public class BouncingSprite extends MobileSprite {
    public BouncingSprite(int x, int y, int width, int height, String image, double vy, double vx) {
        super(x, y, width, height, image, vy, vx);
    }
    @Override
    public void step(World world) {
        super.step(world);
        bounce();
    }
    private void bounce() {
        if (super.getX() - getWidth()/2 <= 0 || super.getX() + getWidth()/2 >= 600) {
            super.setVx(super.getVx() * -1);
        }
        if (super.getY() - getHeight()/2 <= 0 || super.getY() + getHeight()/2 >= 600) {
            super.setVy(super.getVy() * -1);
        }
    }
}
