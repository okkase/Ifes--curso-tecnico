/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogo_anaconda;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;

/**
 *
 * @author 20231TIIMI0120
 */

 public class App {
    public static void main(String[] args) {
        int larguraPainel = 600;
        int alturaPainel = 600;
        JFrame janela = new JFrame("Jogo Betânio da Cobrinha");//cria a janela
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//faz com que o jogo pare de rodar quando for fehada
        janela.setResizable(false);//impede que a janela seja redimensionada
        Board board = new Board(larguraPainel, alturaPainel);//cria mapa
        //impede que a janelze(new Dimension(larguraPainel, alturaPainel));//seta altura e largura
        
        
        janela.add(board);//adiciona mapa na janela
        janela.pack();//redimensiona a janela para o mesmo tamanho do mapa
        janela.setLocationRelativeTo(null);//seta a posição da janela como null (centralizada)
        janela.setVisible(true);//deixa a janela visivel
        janela.repaint();

        
        
        
        
        
        
    }
}
  
