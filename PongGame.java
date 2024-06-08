import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PongGame extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int PADDLE_WIDTH = 10;
    private static final int PADDLE_HEIGHT = 100;
    private static final int BALL_SIZE = 20;
    private static final int PADDLE_SPEED = 30;
    private static final int BALL_SPEED_X = 3;
    private static final int BALL_SPEED_Y = 3;

    private int paddle1Y, paddle2Y;
    private int ballX, ballY;
    private int ballSpeedX, ballSpeedY;
    private boolean running;

    public PongGame() {
        setTitle("Pong Game");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        addKeyListener(new GameKeyListener());

        paddle1Y = HEIGHT / 2 - PADDLE_HEIGHT / 2;
        paddle2Y = HEIGHT / 2 - PADDLE_HEIGHT / 2;
        ballX = WIDTH / 2 - BALL_SIZE / 2;
        ballY = HEIGHT / 2 - BALL_SIZE / 2;
        ballSpeedX = BALL_SPEED_X;
        ballSpeedY = BALL_SPEED_Y;
        running = true;

        Timer timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (running) {
                    movePaddles();
                    moveBall();
                    checkCollision();
                    repaint();
                }
            }
        });
        timer.start();
    }

    private void movePaddles() {
        if (paddle1Y < 0) {
            paddle1Y = 0;
        } else if (paddle1Y > HEIGHT - PADDLE_HEIGHT) {
            paddle1Y = HEIGHT - PADDLE_HEIGHT;
        }

        if (paddle2Y < 0) {
            paddle2Y = 0;
        } else if (paddle2Y > HEIGHT - PADDLE_HEIGHT) {
            paddle2Y = HEIGHT - PADDLE_HEIGHT;
        }
    }

    private void moveBall() {
        ballX += ballSpeedX;
        ballY += ballSpeedY;

        if (ballY <= 0 || ballY >= HEIGHT - BALL_SIZE) {
            ballSpeedY = -ballSpeedY;
        }

        if (ballX <= PADDLE_WIDTH && ballY + BALL_SIZE >= paddle1Y && ballY <= paddle1Y + PADDLE_HEIGHT) {
            ballSpeedX = -ballSpeedX;
        }

        if (ballX >= WIDTH - PADDLE_WIDTH - BALL_SIZE && ballY + BALL_SIZE >= paddle2Y && ballY <= paddle2Y + PADDLE_HEIGHT) {
            ballSpeedX = -ballSpeedX;
        }

        if (ballX < 0 || ballX > WIDTH - BALL_SIZE) {
            gameOver();
        }
    }

    private void checkCollision() {
        // To be extended if needed
    }

    private void gameOver() {
        running = false;
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.WHITE);
        g.fillRect(PADDLE_WIDTH, paddle1Y, PADDLE_WIDTH, PADDLE_HEIGHT);
        g.fillRect(WIDTH - 2 * PADDLE_WIDTH, paddle2Y, PADDLE_WIDTH, PADDLE_HEIGHT);

        g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
    }

    private class GameKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_W) {
                paddle1Y -= PADDLE_SPEED;
            } else if (key == KeyEvent.VK_S) {
                paddle1Y += PADDLE_SPEED;
            } else if (key == KeyEvent.VK_UP) {
                paddle2Y -= PADDLE_SPEED;
            } else if (key == KeyEvent.VK_DOWN) {
                paddle2Y += PADDLE_SPEED;
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            PongGame game = new PongGame();
            game.setVisible(true);
        });
    }
}
