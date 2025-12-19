package BrickBreakerGame;

public class Player
{


    private static Player player;
    private int paddleWidth=100;
    private int paddleSpeed=15;
    private int Lives=3;

    Player()
        {
            super();
        }
        public static Player getInstance() {
            if (player == null) {
                player = new Player();
            }
            return player;
        }

    public int getLives() {
        return Lives;
    }
    public int incrementLives() {
        Lives=Lives+1;
        return Lives;
    }
    public int decreaseLives() {
        Lives=Lives-1;
        return Lives;
    }


    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Player.player = player;
    }

    public int getPaddleSpeed() {
        return paddleSpeed;
    }

    public void setPaddleSpeed(int paddleSpeed) {
        this.paddleSpeed = paddleSpeed;
    }


    public int getPaddleWidth() {
        return paddleWidth;
    }

    public void setPaddleWidth(int paddleWidth) {
        this.paddleWidth = paddleWidth;
    }
    public int increasePaddleSize()
    {
        return paddleWidth += 50;
    }

    public int decreasePaddleSize()
    {

        return paddleWidth;
    }

    public int increasePaddleSpeed()
    {
        return paddleSpeed += 15;
    }

    public int decreasePaddleSpeed()
    {
        return paddleSpeed;
    }
}
