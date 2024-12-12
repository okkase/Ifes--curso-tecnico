/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogo_anaconda;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

public class Food extends Tile{
private int maxX;
private int maxY;
private int tileSize;
private Color color;
private Random random;

public Food(int maxX, int maxY, int tileSize, Color color){
super(0,0, tileSize, color);
this.maxX = maxX;
this.maxY = maxY;
this.tileSize = tileSize;
this.color = color;
this.random = new Random();
}
public void placeFood(){
int x = random.nextInt(maxX);
int y = random.nextInt(maxY);
setX(x);
setY(y);
}



}
