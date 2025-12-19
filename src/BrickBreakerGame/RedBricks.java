package BrickBreakerGame;

import java.awt.*;

public class RedBricks {
        public RedBricks(Graphics2D g, int i , int j,int brickWidth,int brickHeight)
        {
            BrickDraw( g,  i ,  j,brickWidth,brickHeight);
        }
        public void BrickDraw(Graphics2D g,int i, int j, int brickWidth,int brickHeight){
            g.setColor(Color.red);
            g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
        }


    }


