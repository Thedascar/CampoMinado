import br.com.LucasRamon.CampoMinado.excecao.ExplosaoException;
import br.com.LucasRamon.CampoMinado.modelo.Campo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CampoTeste {
    private Campo campo;

    @BeforeEach
    void iniciarCampo(){
         campo = new Campo(3,3);
    }
    @Test
    void testeVizinhoRealDIstancia1Esquerda(){
        Campo vizinho = new Campo(3,2);
        boolean res = campo.adicionarVizinho(vizinho);

        assertTrue(res);
    }

    @Test
    void testeVizinhoRealDIstancia1Direita(){
        Campo vizinho = new Campo(3,4);
        boolean res = campo.adicionarVizinho(vizinho);

        assertTrue(res);
    }

    @Test
    void testeVizinhoRealDIstancia1EmCima(){
        Campo vizinho = new Campo(2,2);
        boolean res = campo.adicionarVizinho(vizinho);

        assertTrue(res);
    }

    @Test
    void testeVizinhoRealDIstancia1EmBaixo(){
        Campo vizinho = new Campo(4,2);
        boolean res = campo.adicionarVizinho(vizinho);

        assertTrue(res);
    }

    @Test
    void testeVizinhoRealDIstancia2(){
        Campo vizinho = new Campo(2,2);
        boolean res = campo.adicionarVizinho(vizinho);

        assertTrue(res);
    }

    @Test
    void naotTesteVizinho(){
        Campo vizinho = new Campo(1,2);
        boolean res = campo.adicionarVizinho(vizinho);

        assertFalse(res);
    }


    @Test
    void testeValorPadraoAtributoMarcado(){
        assertFalse(campo.isMarcado());
    }

    @Test
    void testeAlternaMarcacao(){
        campo.alternarMarcacao();
        assertTrue(campo.isMarcado());
    }

    @Test
    void testeAlternaMarcacaoDuasVezes(){
        campo.alternarMarcacao();
        campo.alternarMarcacao();
        assertFalse(campo.isMarcado());
    }

    @Test
    void testeAbrirNaoMinadoNaoMarcado(){
        assertTrue(campo.abrir());
    }

    @Test
    void testeAbrirNaoMinadoEMarcado(){
        campo.alternarMarcacao();
        assertFalse(campo.abrir());
    }

    @Test
    void testeAbrirMinadoEMarcado(){
        campo.alternarMarcacao();
        campo.minar();
        assertFalse(campo.abrir());
    }

    @Test
    void testeAbrirMinadoNaoMarcado(){;
        campo.minar();
        assertThrows(ExplosaoException.class,() -> {
            campo.abrir();
        });
    }

    @Test
    void testeAbrirComVizinhos(){
        Campo campo11 = new Campo(1,1);
        Campo campo22 = new Campo(2,2);

        campo22.adicionarVizinho(campo11);

        campo.adicionarVizinho(campo22);
        campo.abrir();

        assertTrue(campo22.isAberto() && campo11.isAberto());
    }

    @Test
    void testeAbrirComVizinhos2(){
        Campo campo11 = new Campo(1,1);
        Campo campo12 = new Campo(1,1);
        campo12.minar();

        Campo campo22 = new Campo(2,2);
        campo22.adicionarVizinho(campo11);
        campo22.adicionarVizinho(campo12);

        campo.adicionarVizinho(campo22);
        campo.abrir();

        assertTrue(campo22.isAberto() && campo11.isFechado());
    }

}
