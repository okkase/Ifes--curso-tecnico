import javax.swing.*;
import java.awt.*;

public class App {

    private static JFrame janela;
    private static int larguraJanela = 800;
    private static int alturaJanela = 800;
    private static int larguraPainel = 600;
    private static int alturaPainel = 600;
    private static Board board;
    private static MenuPanel menuPanel;
    private static JLabel fundoLabel;
    private static JPanel painelGIF;
    private static Background background;

    public static void main(String[] args) {
        // Cria a janela principal do jogo
        janela = new JFrame("Jogo Betânio da Cobrinha");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);
        janela.setSize(larguraJanela, alturaJanela);

        // Cria o painel que irá conter a imagem de fundo
        painelGIF = new JPanel(new BorderLayout());

        // Cria o objeto Background e carrega a imagem de fundo
        background = new Background("imagens/fundo_fase4.png"); // Substitua pelo caminho da sua imagem

        // Obtém o JLabel que contém a imagem de fundo e define o tamanho para preencher a tela
        fundoLabel = background.getFundoLabel(larguraJanela, alturaJanela);

        // Adiciona o JLabel ao painelGIF
        painelGIF.add(fundoLabel, BorderLayout.CENTER);

        // Adiciona o painelGIF à janela
        janela.add(painelGIF);

        // Cria o tabuleiro do jogo (sem o painelGIF)
        board = new Board(larguraPainel, alturaPainel);

        // Configura o double buffering para melhorar o desempenho
        painelGIF.setDoubleBuffered(true);
        board.setDoubleBuffered(true);

        // Cria o painel do menu
        menuPanel = new MenuPanel(larguraJanela, alturaJanela, larguraPainel, alturaPainel, janela, e -> IniciarJogo());

        // Adiciona o painel do menu à janela
        janela.add(menuPanel);

        // Centraliza a janela e a torna visível
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);

    }

    public static void IniciarJogo() {
        // Remove o painel do menu da janela
        janela.remove(menuPanel);

        // Adiciona o tabuleiro do jogo à janela
        janela.add(board);

        // Configura o layout do jogo
        janela.setLayout(null);
        int margemX = (larguraJanela - larguraPainel) / 2;
        int margemY = (alturaJanela - alturaPainel) / 2;
        board.setBounds(margemX, margemY, larguraPainel, alturaPainel);
        painelGIF.setBounds(0, 0, larguraJanela, alturaJanela);

        // Redesenha a janela
        janela.revalidate();
        janela.repaint();

        // Solicita o foco para o tabuleiro do jogo
        board.requestFocusInWindow();

        // Inicia o jogo
        board.startGame();
    }
}