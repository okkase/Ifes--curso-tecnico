/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogo_anaconda;

import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
/**
 *
 * @author 20231TIIMI0120
 */
public class Cobrinha{
    Color color;
    int tileSize;
    int x;
    int y;
    Tile cabeca;
    ArrayList<Tile> body;

    public Cobrinha(int x, int y,int tileSize, Color color){
        this.tileSize = tileSize;
        this.color = color;
        this.x = x;
        this.y = y;
        body = new ArrayList<Tile>();
        cabeca = new Tile(x,y,tileSize,color);
        body.add(cabeca);
    }
    public void move(int addX, int addY){
        x = x+addX;
        y = y+addY;
        
        body.add(0,new Tile(x,y,tileSize,color));
        body.remove(body.size()-1);
    }
    public void draw(Graphics g){
        
        for (Tile tile : body) {
        tile.draw(g);
    }
    }
    public void addTile(Tile tile){
    this.body.add(tile);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ArrayList<Tile> getBody() {
        return body;
    }

    public void setBody(ArrayList<Tile> body) {
        this.body = body;
    }
    
}
    



