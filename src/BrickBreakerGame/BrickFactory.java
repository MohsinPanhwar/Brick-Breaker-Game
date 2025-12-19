package BrickBreakerGame;

import java.awt.*;

public class BrickFactory {
    public BrickFactory(String BrickColor,Graphics2D g, int x , int y,int BW,int BH)
    {
        if (BrickColor.equalsIgnoreCase("Red")){
            CreateRedBrick( g,  x ,  y,BW,BH);
        }
        else if (BrickColor.equalsIgnoreCase("Blue")){
            CreateBlueBrick( g,  x ,  y,BW,BH);
        }

        else if (BrickColor.equalsIgnoreCase("White")){
            CreateWhiteBrick( g,  x ,  y,BW,BH);
        }

        else if (BrickColor.equalsIgnoreCase("gray")){
            CreateGreyBrick( g,  x ,  y,BW,BH);
        }
    }
    public RedBricks CreateRedBrick(Graphics2D g, int x , int y,int BW,int BH){
        return new RedBricks( g,  x ,  y,BW,BH);
    }
    public GreyBricks CreateGreyBrick(Graphics2D g, int x , int y,int BW,int BH){
        return new GreyBricks( g,  x ,  y,BW,BH);
    }

    public BlueBricks CreateBlueBrick(Graphics2D g, int x , int y,int BW,int BH){
        return new BlueBricks( g,  x ,  y,BW,BH);
    }
    public WhiteBricks CreateWhiteBrick(Graphics2D g, int x , int y,int BW,int BH){
        return new WhiteBricks( g,  x ,  y,BW,BH);
    }
}
