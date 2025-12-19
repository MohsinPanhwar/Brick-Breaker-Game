package BrickBreakerGame;

import java.awt.*;

public class PowerUpFactory {
    String PowerName;
    public PowerUpFactory(String PowerUp,Graphics2D g, int x , int y)
    {
        if (PowerUp.equalsIgnoreCase("Size")){
            CreateSizePower( g,  x ,  y);
        }
        else if (PowerUp.equalsIgnoreCase("Speed")){
            CreateSpeedPower( g,  x ,  y);
        }

        else if (PowerUp.equalsIgnoreCase("Life")){
            CreateLifePower( g,  x ,  y);
        }
    }
    public SizePower CreateSizePower(Graphics2D g, int x , int y){
        return new SizePower( g,  x ,  y);
}
    public SpeedPower CreateSpeedPower(Graphics2D g, int x , int y){
        return new SpeedPower( g,  x ,  y);
}
    public GainLife CreateLifePower(Graphics2D g, int x , int y){
        return new GainLife( g,  x ,  y);
    }
}
