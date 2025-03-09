

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
    private int velx;
    private int vely;
    Tile cabeca;
    ArrayList<Tile> body;

    public Cobrinha(int velx, int vely,int tileSize, Color color){
        this.tileSize = tileSize;
        this.color = color;
        this.velx = velx;
        this.vely = vely;
        body = new ArrayList<Tile>();
        cabeca = new Tile(0,0,tileSize,color);
        body.add(cabeca);
    }
    public void move() {
        int x = cabeca.getX() + velx;
        int y = cabeca.getY() + vely;
        
        cabeca.setX(x); // Atualiza a posição da cabeça
        cabeca.setY(y);
        
        body.add(0, new Tile(x, y, tileSize, color)); // Adiciona nova cabeça
        body.remove(body.size() - 1); // Remove o último segmento
    }
    
    public void draw(Graphics g){
        
        for (Tile tile : body) {
        tile.draw(g);
    }
    }
    public void addTile(Tile tile){
    this.body.add(tile);
    }


    public ArrayList<Tile> getBody() {
        return body;
    }

    public void setBody(ArrayList<Tile> body) {
        this.body = body;
    }
    
    public int getVelocityX() {
        return velx;
    }
    public void setVelocityX(int velocityX) {
        this.velx = velocityX;
    }
    public int getVelocityY() {
        return vely;
    }
    
    public void setVelocityY(int velocityY) {
        this.vely = velocityY;
    }

    public int getSize(){
        return body.size();
    }

    public void grow(){
        Tile tail = this.getTail();
        body.add(new Tile (tail.getX(), tail.getY(), tileSize, color));
    }

    public Tile getTail(){
        
        return body.getLast();
    }
    public Tile getHead(){
        
        return body.getFirst();
        
    }
    
    
    public boolean checkFoodCollision(Food food){
        if (food.checkCollision(this.getHead())){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean checkSelfCollision() {
        for (int i = 1; i < body.size(); i++) {
            if (body.get(i).checkCollision(this.getHead())) {
                return true;
            }
        }
        return false; 
    }
    
}
    



