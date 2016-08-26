/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author yosh
 */
public class Tabuleiro {

    private JPanel tabuleiro[][];
    private int x;
    private int y;
    private int tamanho;

    public Tabuleiro(JFrame frame, int x, int y, int tamanho) {
        this.tabuleiro = new JPanel[9][9];
        this.x = x;
        this.y = y;
        this.tamanho = tamanho;
        criarTabuleiro(frame, x, y, tamanho);
    }

    
    public int getTamanho() {
        return tamanho;
    }

    /* Cores:
    Selecionado - C2C045 ~ 194 192 69
    Branco - F1EEBD ~ 241 238 189
    Preto - AC865A ~ 172 134 90
     */
    public void setTamanho(int tamanho) {    
        this.tamanho = tamanho;
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

    public JPanel[][] getTabuleiro() {
        return tabuleiro;
    }

    public void criarTabuleiro(JFrame frame, int x, int y, int tamanho) {
        int auxLinha, auxColuna;

        //Variáveis auxiliares que indicam a linha e a coluna do bloco
        auxLinha = auxColuna = 1;
        //Variaveis que indicam o ponto inicial de onde o tabuleiro deve ser criado

        for (int linha = 0; linha < tamanho * 8; linha += tamanho) {
            for (int coluna = 0; coluna < tamanho * 8; coluna += tamanho) {
                if (auxLinha % 2 == 0) {   //Se a linha for impar, primeiro campo é preto
                    this.tabuleiro[auxLinha][auxColuna] = new Campo("preto");
                    //Define tamanho dos blocos e sua localização
                    this.tabuleiro[auxLinha][auxColuna].setBounds(linha + x, coluna + y, tamanho, tamanho);
                    if (auxColuna % 2 == 0) {
                        this.tabuleiro[auxLinha][auxColuna].setBackground(new Color(241, 238, 189));
                    } else {
                        this.tabuleiro[auxLinha][auxColuna].setBackground(new Color(172, 134, 90));
                    }
                    frame.add(this.tabuleiro[auxLinha][auxColuna]);
                } else {
                    this.tabuleiro[auxLinha][auxColuna] = new Campo("branco");
                    this.tabuleiro[auxLinha][auxColuna].setBounds(linha + x, coluna + y, tamanho, tamanho);
                    if (auxColuna % 2 == 0) {
                        this.tabuleiro[auxLinha][auxColuna].setBackground(new Color(172, 134, 90));
                    } else {
                        this.tabuleiro[auxLinha][auxColuna].setBackground(new Color(241, 238, 189));
                    }
                    frame.add(this.tabuleiro[auxLinha][auxColuna]);
                }
                auxColuna++;
            }
            auxColuna = 1;
            auxLinha++;
        }
        frame.repaint();
    }
}
