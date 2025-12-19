package BrickBreakerGame;

import java.awt.*;

public class GreyBricks {
    public GreyBricks(Graphics2D g, int i , int j,int brickWidth,int brickHeight)
    {
        BrickDraw( g,  i ,  j,brickWidth,brickHeight);
    }
    public void BrickDraw(Graphics2D g,int i, int j, int brickWidth,int brickHeight){
        g.setColor(Color.gray);
        g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
    }


}


