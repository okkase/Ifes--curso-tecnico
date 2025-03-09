import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class MenuPanel extends JPanel {
    private JButton playButton;
   



    public MenuPanel(int larguraJanela, int alturaJanela, int larguraPainel, int alturaPainel, JFrame janela, ActionListener iniciar) {
        // Define o tamanho do painel para ocupar toda a janela
        setPreferredSize(new Dimension(larguraJanela, alturaJanela));
        setLayout(null);

        JLabel title = new JLabel("Snake Game");
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setForeground(Color.WHITE);
        title.setBounds((larguraJanela / 2) - 120, (alturaJanela / 2)-150, 300, 40);
        add(title);

        // Botão Play
        playButton = new JButton("Play");
        playButton.setBounds((larguraJanela - 100) / 2, alturaJanela / 2, 100, 50);
        playButton.setFont(new Font("Arial", Font.BOLD, 16));
        playButton.setBackground(new Color(0, 128, 0));
        playButton.setForeground(Color.WHITE);
        playButton.addActionListener(iniciar);
        add(playButton);

        // Cor de fundo do painel de menu
        setBackground(new Color(30, 10, 20));
    }

}
