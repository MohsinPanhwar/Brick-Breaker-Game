package BrickBreakerGame;

import java.awt.*;

public class WhiteBricks {
    public WhiteBricks(Graphics2D g, int i , int j,int brickWidth,int brickHeight)
    {
        BrickDraw( g,  i ,  j,brickWidth,brickHeight);
    }
    public void BrickDraw(Graphics2D g,int i, int j, int brickWidth,int brickHeight){
        g.setColor(Color.white);
        g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
    }


}


