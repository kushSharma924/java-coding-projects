import java.awt.event.KeyEvent;

public class ControllableSprite extends MobileSprite {
    public ControllableSprite(int x, int y, int width, int height, String image) {
        super(x, y, width, height, image, 0, 0);
    }
    @Override
    public void step(World world) {
        checkEdges();
        checkVelocity();
        super.step(world);
    }
    public void checkVelocity() {
        if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
            super.setVy(super.getVy() + 0.1);
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
            super.setVy(super.getVy() - 0.1);
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
            super.setVx(super.getVx() - 0.1);
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
            super.setVx(super.getVx() + 0.1);
        }
    }
    public void checkEdges() {
        if (super.getX() <= 0 || super.getX() >= 600) {
            super.setVx(0.0);
        }
        if (super.getY() <= 0 || super.getY() >= 600) {
            super.setVy(0.0);
        }
    }
}
