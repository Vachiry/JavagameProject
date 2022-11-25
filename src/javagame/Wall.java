

package javagame;

import java.awt.*;

public class Wall {
    int x,y,width,height;
    Rectangle HitBox;

    public Wall(int x ,int y,int width,int height){
        this.x=x;
        this.y=y;
        this.width = width;
        this.height = height;

        HitBox = new Rectangle(x,y,width,height);
    }
}

