import javax.swing.*;
import java.awt.*;

public class Background {

    private ImageIcon imagemFundo;

    public Background(String caminhoImagem) {
        imagemFundo = new ImageIcon(App.class.getResource(caminhoImagem));
        if (imagemFundo.getImageLoadStatus() != MediaTracker.COMPLETE) {
            System.err.println("Erro ao carregar a imagem: " + caminhoImagem);
        }
    }
    
     public JLabel getFundoLabel(int largura, int altura) {
        Image imagemRedimensionada = imagemFundo.getImage().getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
        ImageIcon imagemFundoRedimensionada = new ImageIcon(imagemRedimensionada);
        return new JLabel(imagemFundoRedimensionada);
    }
}