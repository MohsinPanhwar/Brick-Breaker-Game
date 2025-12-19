package BrickBreakerGame;

import java.awt.*;

public class GainLife {


    public GainLife(Graphics2D g, int x , int y)
    {
        PowerDraw( g,  x ,  y);
    }
    public void PowerDraw(Graphics2D g, int x, int y){
        g.setColor(Color.red);
        g.fillRect(x, y, 5,15);
    }

}
