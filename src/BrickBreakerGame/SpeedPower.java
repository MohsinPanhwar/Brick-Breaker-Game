package BrickBreakerGame;

import java.awt.*;

public class SpeedPower {
    public SpeedPower(Graphics2D g, int x , int y)
    {

        PowerDraw( g,  x ,  y);
    }
    public void PowerDraw(Graphics2D g, int x, int y){
        g.setColor(Color.green);
        g.fillRect(x, y, 15,5);
    }

}
