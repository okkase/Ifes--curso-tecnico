

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.io.*;


import javax.swing.Timer;
public class Board extends JPanel implements ActionListener, KeyListener {
    private int boardWidth;
    private int boardHeight;
    private final int tileSize = 25;
    private Food food;
    private Cobrinha snake;
    private Timer gameLoop;
    private boolean gameOver;
    private boolean pause;
    private AudioPlayer sound;
    private int delay;


    
    
    



    public Board(int boardWidth, int boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
  
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(new Color(30, 10, 20));
        delay = 150;
        this.food = new Food(boardWidth / tileSize, boardHeight / tileSize, tileSize, Color.RED);
        food.placeFood();
        this.gameLoop = new Timer(delay, this);
        snake = new Cobrinha(1, 0, 25, Color.GREEN);
        gameOver = false;
        pause = false;
        this.sound = new AudioPlayer();





        setFocusable(true);
        addKeyListener(this);
    }
    @Override
public void actionPerformed(ActionEvent e) {
    if(gameOver){

        gameLoop.stop();
        this.sound.play("gameover.wav");
        
        saveScore();
       
    }
    else{

    
    snake.move();
    this.checkBoardCollision();
    this.checkSnakeSelfCollision();
    this.checkSnakeCollisionFood();
    
    repaint();      
 
    }
    
     
    
}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        createGrid(g);
        
        
       
        snake.draw(g);
        food.draw(g);
        drawScore(g);
        drawInfo(g);
        
    }

    public void createGrid(Graphics g) {
        
        g.setColor(new Color(208, 0, 80));
        for (int i = 0; i <= boardWidth / tileSize; i++) {
            g.drawLine(i * tileSize, 0, i * tileSize, boardHeight);
        }
        for (int i = 0; i <= boardHeight / tileSize; i++) {
            g.drawLine(0, i * tileSize, boardWidth, i * tileSize);
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        System.out.println(tecla);
        if (tecla == 37 && snake.getVelocityX()!=1){
            snake.setVelocityX(-1);
            snake.setVelocityY(0);
        }
        if (tecla == 38 && snake.getVelocityY()!=1){

            snake.setVelocityX(0);
            snake.setVelocityY(-1);
        }
        if (tecla == 39 && snake.getVelocityX()!=-1){
  
            snake.setVelocityX(1);
            snake.setVelocityY(0);
        }
        if (tecla == 40 && snake.getVelocityY()!=-1){

            snake.setVelocityX(0);
            snake.setVelocityY(1);
        }
        if(tecla == 32){
            if (gameOver){
                this.resetGame();
            }
            else{
            if(pause){
                gameLoop.start();
                sound.resumeAll();
                pause = false;
            }
            else{
                gameLoop.stop();
                sound.pauseAll();
                pause = true;
            }
        }
    }
        
        
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    @Override
    public void keyReleased(KeyEvent e) {
        
    

}
public boolean isTileInsideBoard(Tile tile){
    if(tile.getX()>23 || tile.getY()>23|| tile.getX()<0 || tile.getY()<0){
        return false;
    }
    else{
        return true;
    }
}
public void checkBoardCollision(){
    if(this.isTileInsideBoard(snake.getHead()) == false){

        gameOver = true;
    }
}
public void checkSnakeSelfCollision(){
    if (snake.checkSelfCollision()){

        gameOver = true;
    }
}
public void checkSnakeCollisionFood(){
    if(snake.checkFoodCollision(food)){
        sound.stop("item.wav");
        sound.play("item.wav");
        snake.grow();
        food.placeFood();
        controlaDificuldade();
        

        
    } 
}
public void drawScore(Graphics g){
    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.PLAIN, 16));
    int score = snake.getSize(); 
    if(gameOver){
        g.drawString("Game Over! Score: " + score, 10, 20);
    }
    else{
   
    g.drawString("Score: " + score, 10, 20);
    }

}

public void drawInfo(Graphics g){
    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.PLAIN, 16));
    
    if(gameOver){
        g.drawString("Espaço - Reset", 10, 40);
    }
    else{
        g.drawString("Espaço - Pause", 10, 40);
    }

}
public void resetGame() {
    
    // Redefine o estado da cobra
    snake = new Cobrinha(1, 0, tileSize, Color.GREEN);  
    
    // Redefine o estado do alimento
    food.placeFood();  // Coloca um novo alimento no tabuleiro
    
    // Reseta o estado do jogo
    gameOver = false;  
    
    // Reinicia o loop do jogo
    gameLoop.restart(); 
    controlaDificuldade();
}


public void saveScore() {
    // Obtém o nome do jogador (aqui podemos fazer um JOptionPane para pegar o nome)
    String playerName = JOptionPane.showInputDialog("Digite seu nome: ");
    if (playerName != null && !playerName.trim().isEmpty()) {
        // Salva a pontuação no arquivo
        int score = snake.getSize(); // Aqui você pega a pontuação da cobra
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ranking.txt", true))) {
            writer.write(score + ";" + playerName);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





//Forma que encontrei para que o jogo apenas rode depois do play ser precionado
public void startGame(){
    gameLoop.start();
    sound.play("pou.wav");

}
public void controlaDificuldade() {
    int snakeSize = snake.getSize();

    if (snakeSize == 1) {

        gameLoop.setDelay(150);
        sound.stopAll();
        sound.play("pou.wav");
    } else if (snakeSize == 18) {

        gameLoop.setDelay(120);
        sound.stop("pou.wav");
        sound.play("musica1.wav");
    } else if (snakeSize == 25) {

        gameLoop.setDelay(110);
        sound.stop("musica1.wav");
        sound.play("musica2.wav");
    } else if (snakeSize == 35) {

        gameLoop.setDelay(90);
        sound.stop("musica2.wav");
        sound.play("musica3.wav");
    }
}

}
    








