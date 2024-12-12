/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogo_anaconda;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
public class Board extends JPanel implements ActionListener {
    int boardWidth;
    int boardHeight;
    private final int tileSize = 25;
    private Food food;
    private Cobrinha snake;
    
    
    

    public Board(int boardWidth, int boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        super.setBackground(new Color(30,10,20));
        int maxx = boardWidth/tileSize;
        int maxy = boardHeight/tileSize;
        this.food = new Food(maxx, maxy, tileSize, Color.RED);
        food.placeFood();
        Timer timer = new Timer(1500, this);  // 500ms entre cada ciclo
        snake = new Cobrinha(5,5,25,Color.GREEN);
        timer.start();

        
        
        
    }
    @Override
public void actionPerformed(ActionEvent e) {
    snake.move(1,0);
    repaint();         // Redesenha a tela com a nova posição da comida
}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        createGrid(g);
        
        
        
        snake.draw(g);
        food.draw(g);
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
}









