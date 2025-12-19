package BrickBreakerGame;

import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    private boolean play = true;

    public boolean isNewGame() {
        return NewGame;
    }

    private boolean NewGame = false;
    private boolean Continue = false;

    public boolean isContinue() {
        return Continue;
    }

    private boolean Launch=false;
    private boolean LaunchA=false;
    private boolean LaunchB=false;
    private boolean SizePower=false;
    private boolean SpeedPower=false;
    private boolean LifePower=false;
    private boolean SizePowerActive=false;
    private boolean SpeedPowerActive=false;
    private boolean LifePowerActive=false;
    private boolean FirstHit[][] = new boolean[3][7];
    private boolean redBall = false;
    private boolean Menu = true;

    private int w=700;
    private int h=600;
    private int Breaks=0;
    private int Breaks1=0;
    private int PScore=0;
    private int ScoreSP=2;
    private int score = 0;
    private int totalBricks = 21;
    private int SizePowerPosX;
    private int SizePowerPosY;
    private int SpeedPowerPosX;
    private int SpeedPowerPosY;
    private int LifePowerPosX;
    private int LifePowerPosY;
    private int hits[][]= new int[3][7];
    private int b=0;
    private String text="";

    private Timer timer;
    private int delay = 8;
    private int level = 1;
    private int Lives = 3;

    private int playerX = 310;
    Player p1 = Player.getInstance();

    private int PaddleSpeed = p1.getPaddleSpeed();
    private int PaddleWidth=p1.getPaddleWidth();
    private int ballPosX = playerX + (PaddleWidth/2) -20;
    private int ballPosY = 520;
    private int ballXdir=-2;
    private int ballYdir=-3;
    private MapGenerator map;
    private SizePower SP;
    private GainLife L;
    public Gameplay()
    {

        map = new MapGenerator(3, 7,Continue);
        for (int i = 0; i < map.map.length; i++) {
            for (int j = 0; j < map.map[0].length; j++) {
                FirstHit[i][j] = false;
            }
        }

            addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
     timer = new Timer(delay,this);
    timer.start();

    }



    public void paint(Graphics g)
    {
        //background
        g.setColor(Color.black);
        g.fillRect(1,1,692,592);

        //borders
        g.setColor(Color.yellow);
        g.fillRect(0,0,3,592);
        g.fillRect(0,0,692,3);
        g.fillRect(682,0,3,592);

        if (Menu) {

            //Menu
            g.setColor(Color.blue);
            g.setFont(new Font("serif", Font.ITALIC, 20));
            g.drawString("BRICK BREAKER GAME", 250, 50);

            g.setColor(Color.white);
            g.setFont(new Font("serif", Font.BOLD, 40));
            g.drawString("Press P to start new game.", 130, 200);
            g.drawString("Press C to continue previous progress.", 20, 350);

        }else {


            //the paddle
            g.setColor(Color.green);
            g.fillRect(playerX, 540, PaddleWidth, 8);

            //ball

       /* if(BallPowerActive){
            g.fillOval(ballPosX,ballPosY,20,20);
            g.fillOval(ballPosX_A,ballPosY_A,20,20);
            g.fillOval(ballPosX_B,ballPosY_B,20,20);
            if (ballPosY>580 && ballPosY_A>580 &&ballPosY_B>580){
                BallPowerActive= false;
                if (b==1){
                    b=0;
                }
                else {
                    Lives -= 1;
                }
                if (Lives<1) {
                    Launch=false;
                    Lives = 0;
                    play = false;
                    ballYdir = 0;
                    ballXdir = 0;
                    g.setColor(Color.red);
                    g.setFont(new Font("serif", Font.BOLD, 30));
                    g.drawString("Game Over, Score:" + score, 190, 300);

                    g.setFont(new Font("serif", Font.BOLD, 20));
                    g.drawString("Press enter to restart.", 230, 350);
                    repaint();
                }
                else
                {
                    Launch=false;
                    ballPosY=520;
                    ballPosX = playerX + PaddleWidth/2;
                    if(redBall){
                        g.setColor(Color.red);

                    }else {
                        g.setColor(Color.yellow);
                    }

                    g.fillOval(ballPosX,ballPosY,20,20);
                    repaint();

                }

            }
        }
        else {
            g.fillOval(ballPosX, ballPosY, 20, 20);
        }*/
            if (redBall) {
                g.setColor(Color.red);
            } else {
                g.setColor(Color.yellow);
            }
            g.fillOval(ballPosX, ballPosY, 20, 20);
            if (ballPosY > 580) {
                if (b == 1) {
                    b = 0;
                } else {
                    Lives -= 1;
                }
                if (Lives < 1) {
                    Launch = false;
                    Lives = 0;
                    play = false;
                    ballYdir = 0;
                    ballXdir = 0;
                    g.setColor(Color.red);
                    g.setFont(new Font("serif", Font.BOLD, 30));
                    g.drawString("Game Over, Score:" + score, 190, 300);

                    g.setFont(new Font("serif", Font.BOLD, 20));
                    g.drawString("Press enter to restart.", 230, 350);
                    repaint();
                } else {
                    Launch = false;
                    ballPosY = 520;
                    ballPosX = playerX + PaddleWidth / 2;
                    if (redBall) {
                        g.setColor(Color.red);

                    } else {
                        g.setColor(Color.yellow);
                    }

                    g.fillOval(ballPosX, ballPosY, 20, 20);
                    repaint();

                }

            }
            if (totalBricks <= 0) {
                play = false;
                ballYdir = 0;
                ballXdir = 0;
                g.setColor(Color.green);
                g.setFont(new Font("serif", Font.BOLD, 30));
                g.drawString("You Won", 250, 300);

                g.setFont(new Font("serif", Font.BOLD, 20));
                g.drawString("Press enter to restart.", 230, 350);

                repaint();
            }
            //drawing map

            map.draw((Graphics2D) g);

            //Scores
            g.setColor(Color.white);
            g.setFont(new Font("serif", Font.BOLD, 25));
            g.drawString("" + score, 592, 30);

            //level
            g.setColor(Color.white);
            g.setFont(new Font("serif", Font.BOLD, 25));
            g.drawString("Level: " + level, 50, 30);

            //Lives
            g.setColor(Color.white);
            g.setFont(new Font("serif", Font.BOLD, 25));
            g.drawString("Lives:" + Lives, 286, 30);

            //Size PowerUp
            if (SizePower) {
                PowerUpFactory size = new PowerUpFactory("Size", (Graphics2D) g, SizePowerPosX, SizePowerPosY);
            }

            // Speed PowerUp
            if (SpeedPower) {
                PowerUpFactory speed = new PowerUpFactory("Speed", (Graphics2D) g, SpeedPowerPosX, SpeedPowerPosY);
            }

            //GainLife PowerUp

            if (LifePower) {
                PowerUpFactory size = new PowerUpFactory("Life", (Graphics2D) g, LifePowerPosX, LifePowerPosY);
            }


        }
        g.dispose();

    }
    public void ReadFile(String FileName) {
        String html = "";
        try {
            File file = new File(FileName);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                data = data.toUpperCase();
                String[] bricks = data.split("_");
                for (int i = 0; i < bricks.length; i++) {
                    String[] brickData = bricks[i].split(" ");
                    for (int j = 0; i < brickData.length; j++) {
                        if (brickData[j].equals("0")) {
                            map.setBrickValue(0, Integer.parseInt(bricks[1]), Integer.parseInt(bricks[2]));
                        } else if (brickData[j].equals("1")) {
                            map.setBrickValue(1, Integer.parseInt(bricks[1]), Integer.parseInt(bricks[2]));
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
        public void WriteFile(String text) {
    try {
        File myObj = new File("SaveFile.txt");
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else {
            System.out.println(text+"has been written to " + myObj.getName() + ".");
        }
        FileWriter myWriter = new FileWriter("SaveFile.txt");
        myWriter.write(text);
        myWriter.close();
    } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();

    }
}
    @Override
    public void actionPerformed(ActionEvent e) {
            NewGame();

    }
    public void NewGame(){
        timer.start();
        if(play){
            Rectangle Paddle = new Rectangle(playerX,540,PaddleWidth,8);
            if(new Rectangle(ballPosX,ballPosY,20,20).intersects(Paddle) )
            {
                int first = playerX + PaddleWidth/5;
                int second = playerX + 2*PaddleWidth/5;
                int third = playerX + 3*PaddleWidth/5;
                int fourth = playerX + 4*PaddleWidth/5;

                if (ballPosX < first) {

                    ballXdir=-2;
                    ballYdir=-1*ballYdir;
                }

                if (ballPosX >= first && ballPosX < second) {

                    ballXdir=-1;
                    ballYdir=-1 * ballYdir;
                }

                if (ballPosX >= second && ballPosX < third) {

                    ballXdir=1*ballXdir;
                    ballYdir=-1*ballYdir;
                }

                if (ballPosX >= third && ballPosX < fourth) {

                    ballXdir=1;
                    ballYdir=-1 * ballYdir;
                }

                if (ballPosX > fourth) {

                    ballXdir=2;
                    ballYdir=-1*ballYdir;
                }

            }
            A: for (int i = 0; i<map.map.length;i++) {
                for (int j = 0; j < map.map[0].length; j++) {
                if (Continue)
                    {
                        ReadFile("String.txt");
                    }
                    if (map.map[i][j] > 0) {
                        int brickX = j * map.brickWidth + 80;
                        int brickY = i * map.brickHeight + 50;
                        int brickWidth = map.brickWidth;
                        int brickHeight = map.brickHeight;
                        Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ball1Rect = new Rectangle(ballPosX, ballPosY, 20, 20);

                        Rectangle brickRect = rect;


                        if (ball1Rect.intersects(brickRect)) {

                            if (map.getBrickColor(i,j).equals("Red")&& !FirstHit[i][j] ) {
                                hits[i][j] = 3;
                                FirstHit[i][j]=true;
                            }
                            if (map.getBrickColor(i,j).equals("Blue")&& !FirstHit[i][j]) {
                                hits[i][j] = 2;
                                FirstHit[i][j]=true;

                            }
                            if (map.getBrickColor(i,j).equals("White")&& !FirstHit[i][j]) {
                                hits[i][j] = 1;
                                FirstHit[i][j]=true;

                            }

                            if (map.getBrickColor(i,j).equals("gray")&& redBall ) {
                                hits[i][j] = 1;
                                FirstHit[i][j] = true;
                            }
                            hits[i][j]-=1;
                            if (hits[i][j] == 0) {
                                map.setBrickValue(0, i, j);
                                System.out.println("0 "+i+" "+ j);
                                text += "0 "+String.valueOf(i)+" "+String.valueOf(j)+"_";
                                totalBricks--;
                                if (totalBricks <= 2){
                                    redBall=true;
                                }
                                score += 5;

                                PScore++;
                                ScoreSP++;
                                Random r = new Random();

                                int ran1 = r.nextInt(5) + 1;

                                if (ran1 == 1 && !SpeedPower && !SpeedPowerActive) {
                                    SpeedPower = true;
                                    SpeedPowerPosX = brickX + brickWidth / 2;
                                    SpeedPowerPosY = brickY + brickHeight / 2;
                                } else if (ran1 == 3 && !SizePower && !SizePowerActive) {
                                    SizePower = true;
                                    SizePowerPosX = brickX + brickWidth / 2;
                                    SizePowerPosY = brickY + brickHeight / 2;
                                } else if (ran1 == 5 && !LifePower && !LifePowerActive) {
                                    LifePower = true;
                                    LifePowerActive = false;
                                    LifePowerPosX = brickX + brickWidth / 2;
                                    LifePowerPosY = brickY + brickHeight / 2;
                                }
                            }
                            else{
                                 text += "1 "+String.valueOf(i)+" "+String.valueOf(j)+"_";
                                 WriteFile(text);

                            }
                            WriteFile(text);
                            if (ballPosX + 19 <= brickRect.x || ballPosX + 1 >= brickRect.x + brickRect.width) {
                                ballXdir = -ballXdir;
                            } else {
                                ballYdir = -ballYdir;
                            }


                            if (SizePowerPosY > playerX) {
                                SizePower = false;
                            }
                            break A;
                        }

                    }


                    Rectangle SizePowerRect = new Rectangle(SizePowerPosX, SizePowerPosY, 10, 10);
                    Rectangle SpeedPowerRect = new Rectangle(SpeedPowerPosX, SpeedPowerPosY, 15, 5);
                    Rectangle LifePowerRect = new Rectangle(LifePowerPosX, LifePowerPosY, 5, 15);

                    Player p = new Player();

                    if (SizePowerRect.intersects(Paddle) && !SizePowerActive && SizePower) {
                        SizePowerActive = true;
                        SizePower = false;
                        Launch = false;
                        PaddleWidth = p.increasePaddleSize();
                        PScore = 0;
                    }
                    if (SpeedPowerRect.intersects(Paddle) && !SpeedPowerActive && SpeedPower) {
                        SpeedPowerActive = true;
                        SpeedPower = false;
                        Launch = false;
                        PaddleSpeed = p.increasePaddleSpeed();
                        ScoreSP = 0;
                    }
                    if (LifePowerRect.intersects(Paddle) && !LifePowerActive && LifePower) {
                        Lives = Lives + 1;
                        LifePowerActive = true;
                        LifePower = false;
                        Launch = false;
                    }


                }
            }

            if(SizePowerActive && PScore==4){
                SizePowerActive=false;
                PaddleWidth= p1.decreasePaddleSize();
            }
            if(SpeedPowerActive && ScoreSP==4){
                SpeedPowerActive=false;
                PaddleSpeed= p1.decreasePaddleSpeed();
            }
            if (SizePower)
            {
                SizePowerPosY += 4;
            }
            if(LifePower)
            {
                LifePowerPosY+=4;
            }
            if (SpeedPower)
            {
                SpeedPowerPosY += 4;
            }

            if (!Launch)
            {
                play=true;
                ballPosX=playerX-10+PaddleWidth/2;
                ballPosY=520;
                ballXdir=-2;
                ballYdir=-3;
            }
            if (Launch) {
                ballPosX += ballXdir;
                ballPosY += ballYdir;
            }
            if (ballPosX<0)
            {
                ballXdir = -ballXdir;
            }

            if (ballPosY<0)
            {
                ballYdir = -ballYdir;
            }
            if (ballPosX>660)
            {
                ballXdir = -ballXdir;
            }
        }
        repaint();

    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_P)
        {
            Menu = false;
            NewGame = true;
            Continue=false;
        }
        if (e.getKeyCode()==KeyEvent.VK_C)
        {
            Menu = false;
            NewGame=false;
            Continue = true;
        }

        if (e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            if (playerX >= 680-PaddleWidth){
                playerX =680-PaddleWidth;
            }
            else{
                moveRight();
            }
            if(ballPosY==520 && !Launch)
            {
                ballPosX+=20;
            }
        }
        if (e.getKeyCode()==KeyEvent.VK_LEFT)
        {

            if (playerX < 10){
                playerX = 10;
            }
            else{
                moveLeft();
            }

            if(ballPosY==520 && !Launch)
            {
                ballPosX -= 20;
            }
        }
        if (e.getKeyCode()==KeyEvent.VK_SPACE)
        {
                Launch=true;
        }
    if( e.getKeyCode()==KeyEvent.VK_ENTER)
        {
            if(!play){
                play=true;
                NewGame=false;
                Continue=false;
                SizePower=false;
                SpeedPower=false;
                Launch = false;
                redBall=false;
                PaddleWidth=100;
                ballPosY=520;
                ballXdir=-2;
                ballYdir=-3;
                score=0;
                Lives=3;
                totalBricks =21;
                ballPosX=playerX+40;
                for (int i = 0; i<map.map.length;i++) {
                    for (int j = 0; j < map.map[0].length; j++) {
                        FirstHit[i][j] = false;
                    }
                }
                map=new MapGenerator(3,7,Continue);

                repaint();
            }
        }
    }


    public void moveRight()
    {
        play =true;
        playerX+=PaddleSpeed;
    }

    public void moveLeft()
    {
        play =true;
        playerX-=PaddleSpeed;
    }

    @Override
    public void keyTyped(KeyEvent e) { }


    @Override
    public void keyReleased(KeyEvent e) { }
}
