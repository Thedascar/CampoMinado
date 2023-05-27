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
}
