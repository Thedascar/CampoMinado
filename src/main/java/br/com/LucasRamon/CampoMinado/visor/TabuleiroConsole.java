package br.com.LucasRamon.CampoMinado.visor;

import br.com.LucasRamon.CampoMinado.excecao.ExplosaoException;
import br.com.LucasRamon.CampoMinado.excecao.SairException;
import br.com.LucasRamon.CampoMinado.modelo.Tabuleiro;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class TabuleiroConsole {
    private Tabuleiro tabuleiro;
    private Scanner entrada = new Scanner(System.in);



    public TabuleiroConsole(Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;

        executarJogo();

    }

    private void executarJogo() {
        try{
            boolean continuar = true;

            while(continuar){
                cicloDoJogo();

                System.out.println("Outra partida? (S/n) ");
                String res = entrada.nextLine();

                if("n".equalsIgnoreCase(res)){
                    continuar = false;
                }else{
                    tabuleiro.reiniciar();
                }

            }
        }catch (SairException e){
            System.out.println("Bye");
        }finally {
            entrada.close();
        }
    }

    private void cicloDoJogo() {
        try {

            while(!tabuleiro.objetivoAlcancado()){
                System.out.print(tabuleiro);

                String digitado = capturarValorDigitado("Digite (x,y): ");

                Iterator<Integer> xy = Arrays.stream(digitado.split(","))
                        .map(e -> Integer.parseInt(e.trim())).iterator();

                digitado = capturarValorDigitado("1 - Abrir ou 2 - (Des)Marcar");

                if("1".equals(digitado)){
                    tabuleiro.abrir(xy.next(),xy.next());
                } else if ("2".equals(digitado)) {
                    tabuleiro.alterarMarcacao(xy.next(),xy.next());
                }

            }
            System.out.println("Ganhou!!!");
        }catch (ExplosaoException e){
            System.out.println(tabuleiro);
            System.out.println("Perdeu!!!!");
        }
    }

    private String capturarValorDigitado(String texto){
        System.out.println(texto);
        String digitado = entrada.nextLine();

        if("sair".equalsIgnoreCase(digitado)){
            throw new SairException();
        }
        return digitado;
    }
}
