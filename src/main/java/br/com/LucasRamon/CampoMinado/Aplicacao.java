package br.com.LucasRamon.CampoMinado;

import br.com.LucasRamon.CampoMinado.modelo.Tabuleiro;

import javax.swing.text.TabableView;

public class Aplicacao {
    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro(6,6,6);

        tabuleiro.abrir(3,3);
        tabuleiro.alterarMarcacao(4,4);
        tabuleiro.alterarMarcacao(4,5);

        System.out.println(tabuleiro);
    }
}
