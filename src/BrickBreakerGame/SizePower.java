package BrickBreakerGame;

import java.awt.*;

public class SizePower {


    public SizePower(Graphics2D g, int x , int y)
    {
        PowerDraw( g,  x ,  y);
    }
    public void PowerDraw(Graphics2D g, int x, int y){
        g.setColor(Color.orange);
        g.fillRect(x, y, 10,10);
    }


}
