package br.com.LucasRamon.CampoMinado;

import br.com.LucasRamon.CampoMinado.modelo.Tabuleiro;
import br.com.LucasRamon.CampoMinado.visor.TabuleiroConsole;

import javax.swing.text.TabableView;

public class Aplicacao {
    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro(6,6,6);
        new TabuleiroConsole(tabuleiro);

    }
}
