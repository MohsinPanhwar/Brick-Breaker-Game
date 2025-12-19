package BrickBreakerGame;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class MapGenerator {
    boolean Continue1;
    public int brickWidth;
    public int brickHeight;
    public int map[][];
    public String BrickColor[][];
    Random r = new Random();



    public MapGenerator(int row, int col,boolean Continue) {
    map = new int[row][col];
    BrickColor = new String[row][col];
    for (int i = 0; i < map.length; i++) {
        for (int j = 0; j < map[0].length; j++) {
            map[i][j] = 1;
        }
    }

       brickWidth = 540 / col;
        brickHeight = 150 / row;
    }


    int ran= r.nextInt(7)+1;
    int ran1 = r.nextInt(7)+1;
    public void draw(Graphics2D g) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0)
                {
                    if (j == ran + 3 && i==0) {
                        BrickFactory RedBricks = new BrickFactory("red",g,i,j,brickWidth,brickHeight);
                        BrickColor[i][j] = "Red";
                    }

                    else if (j==ran && i == 0)
                    {
                        BrickFactory RedBricks = new BrickFactory("red",g,i,j,brickWidth,brickHeight);
                        BrickColor[i][j] = "Red";
                    }
                    else if (j == ran - 3 && i==0){
                        BrickFactory RedBricks = new BrickFactory("red",g,i,j,brickWidth,brickHeight);
                        BrickColor[i][j] = "Red";

                    }
                    else if (j == ran +1 && i<=2){
                        BrickFactory BlueBricks = new BrickFactory("Blue",g,i,j,brickWidth,brickHeight);
                        BrickColor[i][j] = "Blue";

                    }
                    else if (j == ran - 4 && i>=2){
                        BrickFactory BlueBricks = new BrickFactory("blue",g,i,j,brickWidth,brickHeight);
                        BrickColor[i][j] = "Blue";

                    }
                    else if (j == ran  && i==2) {
                        BrickFactory GreyBricks = new BrickFactory("gray", g, i, j, brickWidth, brickHeight);
                        BrickColor[i][j] = "gray";

                    }
                    else if (j==ran && i == 1)
                    {
                    BrickFactory GreyBricks = new BrickFactory("gray", g, i, j, brickWidth, brickHeight);
                    BrickColor[i][j] = "gray";
                    }

                    else {
                        BrickFactory WhiteBricks = new BrickFactory("white",g,i,j,brickWidth,brickHeight);
                        BrickColor[i][j] = "White";


                    }
                        //brick border
                        g.setStroke(new BasicStroke(3));
                        g.setColor(Color.black);
                        g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);

                }
            }
        }
    }
    public void setBrickValue(int value,int row, int col)
    {
        map[row][col]= value;
    }
    public String getBrickColor(int row,int col)
    {
        return BrickColor[row][col];
    }

}

