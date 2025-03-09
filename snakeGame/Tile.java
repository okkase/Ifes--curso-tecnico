/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.Graphics;
import java.awt.Color;

public class Tile {
    int x;
    int y;
    Color color;
    int tileSize;
    public Tile(int x, int y, int tileSize,Color color){
        this.x = x;
        this.y = y;
        this.tileSize = tileSize;
        this.color = color;
    }
    public void draw(Graphics g) {
    g.setColor(color);
    g.fill3DRect(this.x*this.tileSize, this.y*this.tileSize, this.tileSize, this.tileSize, true);
}

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean checkCollision(Tile otherTile){
        if (otherTile.getX() == this.getX() && otherTile.getY() == this.getY()){
            return true;
        }
        else{
            return false;
        }
    }

    
}


