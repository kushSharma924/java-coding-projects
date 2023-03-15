public class MobileSprite extends Sprite {
    private double vy, vx;
    public MobileSprite(int x, int y, int width, int height, String image, double vy, double vx) {
        super(x, y, width, height, image);
        this.vx = vx;
        this.vy = vy;
    }
    public double getVx() {
        return vx;
    }
    public void setVx(double vx) {
        this.vx = vx;
    }
    public double getVy() {
        return vy;
    }
    public void setVy(double vy) {
        this.vy = vy;
    }
    @Override
    public void step(World world) {
        super.setX(super.getX() + vx);
        super.setY(super.getY() + vy);
    }
}
