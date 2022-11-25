

package javagame;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.net.URL;

public class Medicine {
    Image img;
    public int y = (int) (Math.random() * 100) + 20;
    public int x = (int) (Math.random() * 1000) + 20;

    Medicine() {
        String imageLocation = "img/medicine.png";
        URL imageURL = this.getClass().getResource(imageLocation);
        img = Toolkit.getDefaultToolkit().getImage(imageURL);
        runner.start();
    }

    Thread runner = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                y += 2;
                if (y >= 500) {
                    img = null;
                    runner = null;
                    x = -500;
                    y = -500;
                }
                try {
                    runner.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }
    });
    public Image getImage() {
        return img;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Rectangle2D HitBox() {
        return (new Rectangle2D.Double(x, y, 50, 50));
    }
}

