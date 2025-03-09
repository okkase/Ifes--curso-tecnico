/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import java.awt.Color;

import java.util.Random;

public class Food extends Tile{
private int maxX;
private int maxY;
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
